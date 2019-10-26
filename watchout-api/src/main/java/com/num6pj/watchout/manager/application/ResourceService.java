package com.num6pj.watchout.manager.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.num6pj.watchout.manager.domain.ResourceInfo;
import com.num6pj.watchout.manager.infra.ResourceRepository;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<ResourceInfo> findResourceAllList() {
        return resourceRepository.findAll();
    }

    public Optional<ResourceInfo> findResource(String name) {
        return resourceRepository.findByName(name);
    }

    public void createResource(String name, String path, String desc) {
        resourceRepository.save(new ResourceInfo(name, path, desc));
    }

    public void changeResource(Long id, String name, String path, String desc) {
        resourceRepository.save(new ResourceInfo(id, name, path, desc));
    }
}
