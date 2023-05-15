package com.example.repository;

import com.example.entity.CategoryEntity;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findById(Long id);

    CategoryEntity findByName(String name);

    List<CategoryEntity> findDistinctByNameContainingIgnoreCase(String name);

    @Query(value = "SELECT COALESCE(max(c.id), 0) FROM pm_categorias c", nativeQuery = true)
    int findIdMax();

}
