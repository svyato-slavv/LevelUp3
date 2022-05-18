package ru.levelup.studentdb.service;

import ru.levelup.studentdb.bootstrap.model.Student;

import java.util.List;

public interface StudentsService {
    void save(Student student);
    List<Student> findAll();
}
