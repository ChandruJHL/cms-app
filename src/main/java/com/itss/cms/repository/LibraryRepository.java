package com.itss.cms.repository;

import com.itss.cms.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<LibraryEntity, Integer> {
}
