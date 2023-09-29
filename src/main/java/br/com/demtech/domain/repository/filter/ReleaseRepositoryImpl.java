package br.com.demtech.domain.repository.filter;

import br.com.demtech.domain.entity.Release;
import br.com.demtech.domain.model.ReleaseFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Mateus Dantas
 */
public class ReleaseRepositoryImpl implements ReleaseRepositoryQuery {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Release> filter(ReleaseFilter releaseFilter, Pageable pageable) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Release> criteria = builder.createQuery(Release.class);
        Root<Release> root = criteria.from(Release.class);

        Predicate[] predicates = createRestrictions(releaseFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Release> query = entityManager.createQuery(criteria);

        Long totalRecords = total(releaseFilter);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        List<Release> releases = query.getResultList();

        return new PageImpl<>(releases, pageable, totalRecords);
    }

    private Predicate[] createRestrictions(ReleaseFilter releaseFilter, CriteriaBuilder builder, Root<Release> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (releaseFilter.getDescription() != null && !releaseFilter.getDescription().isBlank()) {
            predicates.add(
                builder.like(
                builder.lower(
                root.get("description")), "%" + releaseFilter.getDescription().toLowerCase() + "%")
            );
        }

        if (releaseFilter.getDueDateFrom() != null) {
            predicates.add(
                builder.greaterThanOrEqualTo(
                root.get("dueDate"), releaseFilter.getDueDateFrom())
            );
        }

        if (releaseFilter.getDueDateTo() != null) {
            predicates.add(
                builder.lessThanOrEqualTo(
                root.get("dueDate"), releaseFilter.getDueDateTo())
            );
        }
        return predicates.toArray(new Predicate[predicates.size()]);
    }

    private void addPaginationRestrictions(TypedQuery<Release> query, Pageable pageable) {
        int currentPage = pageable.getPageNumber();
        int totalRecordsPerPage = pageable.getPageSize();
        int firstPageRecord = currentPage * totalRecordsPerPage;

        query.setFirstResult(firstPageRecord);
        query.setMaxResults(totalRecordsPerPage);
    }

    private Long total(ReleaseFilter releaseFilter) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Release> root = criteria.from(Release.class);

        Predicate[] predicates = createRestrictions(releaseFilter, builder, root);
        criteria.where(predicates);
        criteria.select(builder.count(root));

        return entityManager.createQuery(criteria).getSingleResult();
    }
}
