package dev.harsh.accessModifiers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student{
    private int id;
    protected int age;
    String name;
    public int rollNo;
}