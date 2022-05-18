package ru.levelup.studentdb.service;

import ru.levelup.studentdb.bootstrap.model.Group;
import ru.levelup.studentdb.bootstrap.model.Student;

import java.util.List;

public interface GroupService {
    void save(Group group);
    List<Group> findAll();



}
