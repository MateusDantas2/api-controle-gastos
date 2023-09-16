package br.com.demtech.service;

import br.com.demtech.domain.entity.Release;
import br.com.demtech.domain.repository.ReleaseRepository;
import br.com.demtech.exceptions.EmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Mateus Dantas
 */
@Service
public class ReleaseService {

    @Autowired
    private ReleaseRepository releaseRepository;

    public List<Release> listReleases() {
        List<Release> releases = releaseRepository.findAll();
        if (releases.isEmpty()) {
            throw new EmptyException("Dados não encontrados na base de dados!");
        }
        return releases;
    }
}
