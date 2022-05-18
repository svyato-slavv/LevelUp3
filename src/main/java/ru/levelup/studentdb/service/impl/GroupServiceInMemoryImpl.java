package ru.levelup.studentdb.service.impl;

import org.springframework.stereotype.Service;
import ru.levelup.studentdb.bootstrap.model.Group;
import ru.levelup.studentdb.bootstrap.model.Student;
import ru.levelup.studentdb.service.GroupService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupServiceInMemoryImpl implements GroupService {

    private List<Group> groups = new ArrayList<>();

    @Override
    public void save(Group group) {
        groups.add(group);
    }

    @Override
    public List<Group> findAll() {
        return Collections.unmodifiableList(groups);
    }

}
