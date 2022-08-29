package com.task.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;


@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Name", "Sub Classes"})
public class NameDto {

    @JsonProperty("Name")
    public String name;
    @JsonProperty("Sub Classes")
    public List<SubClass> subClasses =null;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NameDto nameDto = (NameDto) o;

        if (name != null ? !name.equals(nameDto.name) : nameDto.name != null) return false;
        return subClasses != null ? subClasses.equals(nameDto.subClasses) : nameDto.subClasses == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (subClasses != null ? subClasses.hashCode() : 0);
        return result;
    }
}