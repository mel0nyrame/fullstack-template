package com.yetiantian.campus_erp.repository;

import com.yetiantian.campus_erp.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByProjectId(Long projectId);
}