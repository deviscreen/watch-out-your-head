package com.num6pj.watchout.manager.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.num6pj.watchout.manager.domain.Category;
import com.num6pj.watchout.manager.domain.ResourceInfo;

@Service
public class ManagerService {

    private final CategoryService categoryService;
    private final ResourceService resourceService;

    public ManagerService(CategoryService categoryService,
                          ResourceService resourceService) {
        this.categoryService = categoryService;
        this.resourceService = resourceService;
    }

    public List<Category> findCategoryAllList() {
        return categoryService.findCategoryAllList();
    }

    public List<ResourceInfo> findResourceAllList() {
        return resourceService.findResourceAllList();
    }

    public void createCategory(String categoryName, String resourceName) {
        ResourceInfo resourceInfo = resourceService.findResource(resourceName)
                                                   .orElseThrow(() -> new IllegalArgumentException("resource is not found: " + resourceName));
        categoryService.createCategory(categoryName, resourceInfo.getId());
    }

    public void createResource(String name, String path, String desc) {
        resourceService.createResource(name, path, desc);
    }

    public void changeCategory(Long id, String name) {
        categoryService.changeCategory(id, name);
    }

    public Optional<Category> findCategoryByName(String categoryName) {
        return categoryService.findCategory(categoryName);
    }
}
