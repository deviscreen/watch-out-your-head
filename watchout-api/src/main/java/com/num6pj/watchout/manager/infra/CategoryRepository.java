package com.num6pj.watchout.manager.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import com.num6pj.watchout.manager.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
