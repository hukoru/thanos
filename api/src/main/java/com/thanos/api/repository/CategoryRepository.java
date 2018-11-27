package com.thanos.api.repository;

import com.thanos.api.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by jt on 6/13/17.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category,  Long> {

    Optional<Category> findByDescription(String description);
}
