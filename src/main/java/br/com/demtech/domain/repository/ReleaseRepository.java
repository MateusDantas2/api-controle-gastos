package br.com.demtech.domain.repository;

import br.com.demtech.domain.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mateus Dantas
 */
public interface ReleaseRepository extends JpaRepository<Release, Long> {}
