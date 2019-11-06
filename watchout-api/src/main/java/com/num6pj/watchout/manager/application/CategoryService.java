package com.num6pj.watchout.manager.application;


import java.util.List;

import org.springframework.stereotype.Service;

import com.num6pj.watchout.manager.domain.Category;
import com.num6pj.watchout.manager.infra.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * 카테고리 목록 조회
     * @return 카테고리 목록
     * @throws Exception
     */
    public List<Category> findCategoryAllList() {
        return categoryRepository.findAll();
    }

    /**
     * 카테고리 생성
     * @param name 카테고리 명
     * @throws Exception
     */
    public void createCategory(String name, Long resourceId) {
        categoryRepository.save(new Category(name, resourceId));
    }

    /**
     * 카테고리 변경
     * @param id 카테고리 ID
     * @param name 카테고리 명
     * @throws Exception
     */
    public void changeCategory(Long id, String name) {
        categoryRepository.save(new Category(id, name));
    }
}
