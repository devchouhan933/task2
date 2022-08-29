package com.task.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "NAME")
public class Name {
    @Id
   // @Column(columnDefinition = "ID")
    private Integer id;
   // @Column(columnDefinition = "COLOR")
    private String color;
   // @Column(columnDefinition = "NAME")
    private String name;
   // @Column(columnDefinition = "PARENTID")
    private Integer parentID;
}
