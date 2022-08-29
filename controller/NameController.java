package com.task.controller;

import com.task.entity.Name;
import com.task.model.NameDto;
import com.task.service.NameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class NameController {
    @Autowired
    private NameService nameService;



    @PostMapping("/name")
    public ResponseEntity<String> savePerson(@RequestBody Name name) {
        log.info("inside PersonController.savePerson with : "+ name);
        return nameService.saveName(name);
    }

    @GetMapping("/names")
    public ResponseEntity<List<NameDto>> getAll(){
        return nameService.getAllName();
    }
}