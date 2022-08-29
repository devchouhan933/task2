package com.task.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Name", "Sub Classes"})
public class SubClass {

    @JsonProperty("Name")
    public String name;
    @JsonProperty("Sub Classes")
    public List<SubClass_1> subClasses = null;

}