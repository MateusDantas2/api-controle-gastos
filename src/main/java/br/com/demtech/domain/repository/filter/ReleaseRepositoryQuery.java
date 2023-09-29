package br.com.demtech.domain.repository.filter;

import br.com.demtech.domain.entity.Release;
import br.com.demtech.domain.model.ReleaseFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Mateus Dantas
 */
public interface ReleaseRepositoryQuery {

    public Page<Release> filter(ReleaseFilter releaseFilter, Pageable pageable);
}
