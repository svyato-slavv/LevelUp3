package ru.levelup.studentdb.service.impl;

import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.levelup.studentdb.bootstrap.model.Student;
import ru.levelup.studentdb.service.StudentsService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentServiceInMemory implements StudentsService {
    private final List<Student> students = new ArrayList<>();

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public List<Student> findAll() {
        return Collections.unmodifiableList(students);
    }
}
