package com.num6pj.watchout.manager.ui;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.num6pj.watchout.manager.application.ManagerService;
import com.num6pj.watchout.manager.domain.Category;
import com.num6pj.watchout.manager.ui.vo.CategoryRequest;
import com.num6pj.watchout.manager.ui.vo.ResourceRequest;

import org.modelmapper.ModelMapper;

@RestController
public class ManagerController {

    private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }


    @PostMapping("resource/create")
    public void createResource(@RequestBody @Valid ResourceRequest resourceRequest) {
        managerService.createResource(resourceRequest.getName(),
                                      resourceRequest.getPath(),
                                      resourceRequest.getDesc());
    }

    @GetMapping("category/list")
    public List<CategoryRequest> getCategoryAllList() {
        return new ModelMapper().map(
                managerService.findCategoryAllList(),
                new TypeToken<List<CategoryRequest>>(){}.getType());
    }

    @PostMapping("category/create")
    public void createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        managerService.createCategory(categoryRequest.getCategoryName(),
                                      categoryRequest.getResourceName());
    }

    @PostMapping("category/change")
    public void changeCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        Long categoryId = categoryRequest.getId();
        if(categoryId == null) {
            Category category =
                    managerService.findCategoryByName(categoryRequest.getCategoryName())
                                  .orElseThrow(() -> new IllegalArgumentException("category is not valid "));
        }
        managerService.changeCategory(categoryId, categoryRequest.getCategoryName());
    }
}
