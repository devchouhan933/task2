package com.task.service;

import com.task.entity.Name;
import com.task.model.NameDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NameService {
    ResponseEntity<String> saveName(Name name);

    ResponseEntity<List<NameDto>> getAllName();
}
