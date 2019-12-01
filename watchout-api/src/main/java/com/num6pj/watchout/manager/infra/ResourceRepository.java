package com.num6pj.watchout.manager.infra;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.num6pj.watchout.manager.domain.ResourceInfo;

public interface ResourceRepository extends JpaRepository<ResourceInfo, Long> {

    Optional<ResourceInfo> findByName(String name);
}
