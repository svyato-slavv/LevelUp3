package ru.levelup.studentdb.service.impl;

import org.springframework.stereotype.Service;
import ru.levelup.studentdb.bootstrap.model.Group;
import ru.levelup.studentdb.bootstrap.model.Student;
import ru.levelup.studentdb.service.StudentsInGroup;

import java.util.Collections;
import java.util.List;

@Service
public class StudentsInGroupImpl implements StudentsInGroup {
    @Override
    public void addStudent(Student student,Group group) {
        group.getStudentList().add(student);
    }

    @Override
    public List<Student> listStudents(Group group) {
        return Collections.unmodifiableList(group.getStudentList());
    }
}
