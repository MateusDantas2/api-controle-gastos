package br.com.demtech.domain.repository.filter;

import br.com.demtech.domain.entity.Release;
import br.com.demtech.domain.model.ReleaseFilter;

import java.util.List;

/**
 *
 * @author Mateus Dantas
 */
public interface ReleaseRepositoryQuery {

    public List<Release> filter(ReleaseFilter releaseFilter);
}
