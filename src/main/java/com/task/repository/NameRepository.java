package com.task.repository;

import com.task.entity.Name;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository<Name ,Integer> {
}
