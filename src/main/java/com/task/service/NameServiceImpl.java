package com.task.service;

import com.task.entity.Name;
import com.task.model.NameDto;
import com.task.model.SubClass;
import com.task.model.SubClass_1;
import com.task.repository.NameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class NameServiceImpl implements NameService {
    @Autowired
    private NameRepository nameRepository;

    @PostConstruct
    public void save() {
        List<Name> people = Stream.of(new Name(1, "red", "Wizard", 0), new Name(2, "green", "Priest", 0), new Name(3, "white", "Warrior", 0), new Name(4, "yellow", "Rogue", 0), new Name(5, "blue", "Mage", 1), new Name(6, "lighblue", "Specialist wizard", 1), new Name(7, "lighgreen", "Cleric", 2), new Name(8, "grey", "Druid", 2), new Name(9, "lightgrey", "Priest of specific mythos", 2), new Name(10, "red", "Fighter", 3), new Name(11, "green", "Paladin", 3), new Name(12, "white", "Ranger", 3), new Name(13, "yellow", "Thief", 4), new Name(14, ",blue", "Bard ", 4), new Name(15, "lighblue", "Assassin", 13)).collect(Collectors.toList());
        nameRepository.saveAll(people);
    }

    @Override
    public ResponseEntity<String> saveName(Name name) {
        log.info("inside NameServiceImpl.saveName with : " + name);
        return nameRepository.save(name) != null ? new ResponseEntity<>("Name is saved with name :" + name, HttpStatus.CREATED) : new ResponseEntity<>("can't save the name :" + name, HttpStatus.BAD_GATEWAY);
    }

    @Override
    public ResponseEntity<List<NameDto>> getAllName() {
        List<Name> names = nameRepository.findAll();
        List<NameDto> nameDos = names.stream().filter(name -> name.getParentID() == 0).map(name -> NameDto.builder().name(name.getName()).subClasses(getSubclasses(names, name.getId())).build()).collect(Collectors.toList());
        return new ResponseEntity<>(nameDos, HttpStatus.OK);
    }

    private List<SubClass> getSubclasses(List<Name> names, Integer id) {
        List<SubClass> subClasses = names.stream().filter(name -> name.getParentID() == id).map(name -> SubClass.builder().name(name.getName()).subClasses(getSubclasses_1(names, name.getId())).build()).collect(Collectors.toList());
        return subClasses.isEmpty() ? null : subClasses;
    }

    private List<SubClass_1> getSubclasses_1(List<Name> names, Integer id) {
        List<SubClass_1> subClass_1List = names.stream().filter(name -> name.getParentID() == id).map(name -> SubClass_1.builder().name(name.getName()).build()).collect(Collectors.toList());
        return subClass_1List.isEmpty() ? null : subClass_1List;
    }




}
