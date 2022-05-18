package ru.levelup.studentdb.service;

import ru.levelup.studentdb.bootstrap.model.Group;
import ru.levelup.studentdb.bootstrap.model.Student;

import java.util.List;

public interface StudentsInGroup {
    void addStudent(Student student, Group group);

    List<Student> listStudents(Group group);
}
