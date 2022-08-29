package com.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {

        E dev = new E("dev")
                ;
        E ved = new E("ved");
        System.out.println(ved.hashCode() +  "  "+ dev.hashCode());
// same
        System.out.println(ved.equals(dev));
// false

        Map<E ,String> eStringMap = new HashMap<>();
        eStringMap.put(dev,"1-");
        eStringMap.put(ved,"-2");
        System.out.println(eStringMap);
    }
}
@AllArgsConstructor
@ToString
class E
{
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        E e = (E) o;

        return name != null ? name.equals(e.name) : e.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

