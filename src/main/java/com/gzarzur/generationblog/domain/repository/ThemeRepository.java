package com.gzarzur.generationblog.domain.repository;

import com.gzarzur.generationblog.domain.models.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {

    Optional<Theme> findById(Long id);
}
