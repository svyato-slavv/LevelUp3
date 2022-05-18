package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.bootstrap.model.Group;
import ru.levelup.studentdb.bootstrap.model.Student;
import ru.levelup.studentdb.service.GroupService;

import java.util.List;

@Component("groupcreateAction")
@Scope("prototype")
@RequiredArgsConstructor
public class CreateGroupAction implements Action{

    private String name;

    private final GroupService groupService;
    @Override
    public void setParams(String... param) {
        this.name=param[0];
    }

    @Override
    public void execute() {
        Group group=new Group(name);
        groupService.save(group);
    }
}
