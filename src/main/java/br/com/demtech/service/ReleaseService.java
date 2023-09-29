package br.com.demtech.service;

import br.com.demtech.domain.entity.Release;
import br.com.demtech.domain.model.ReleaseFilter;
import br.com.demtech.domain.repository.ReleaseRepository;
import br.com.demtech.dto.ResponseStandard;
import br.com.demtech.event.ResourceCreatedEvent;
import br.com.demtech.exceptions.EmptyException;
import br.com.demtech.exceptions.ReleaseException;
import br.com.demtech.validations.release.ReleaseValidation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Mateus Dantas
 */
@Service
public class ReleaseService {

    @Autowired
    private ReleaseRepository releaseRepository;
    @Autowired
    private ReleaseValidation releaseValidation;
    @Autowired
    private ApplicationEventPublisher publisher;

    public ResponseStandard createRelease(Release release, HttpServletResponse response) {
        releaseValidation.validateFieldsExists(release.getIdCategory(), release.getIdPerson());
        Release savedRelease = releaseRepository.save(release);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, savedRelease.getId()));

        return ResponseStandard.success("Cadastro concluído com sucesso!");
    }

    public Page<Release> listReleases(ReleaseFilter releaseFilter, Pageable pageable) {
        Page<Release> releases = releaseRepository.filter(releaseFilter, pageable);
        if (releases.isEmpty()) {
            throw new EmptyException("Dados não encontrados na base de dados!");
        }
        return releases;
    }

    public Release listReleaseById(Long id) {
        return releaseRepository.findById(id)
            .orElseThrow(() -> new ReleaseException(id));
    }

    public void deleteRelease(Long id) {
        Optional<Release> release = releaseRepository.findById(id);
        if (release.isPresent()) {
            releaseRepository.deleteById(id);
        } else {
            throw new ReleaseException(id);
        }
    }
}
