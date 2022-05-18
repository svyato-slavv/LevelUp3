package ru.levelup.studentdb.bootstrap.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Group {
    public Group(String name) {
        this.name = name;
    }

    private String name;

    private List<Student> studentList=new ArrayList<>();
}
