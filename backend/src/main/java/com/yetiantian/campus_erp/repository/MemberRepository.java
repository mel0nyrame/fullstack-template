package com.yetiantian.campus_erp.repository;

import com.yetiantian.campus_erp.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}