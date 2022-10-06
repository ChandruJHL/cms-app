package com.itss.cms.repository;
import com.itss.cms.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffEntity, Integer> {
}
