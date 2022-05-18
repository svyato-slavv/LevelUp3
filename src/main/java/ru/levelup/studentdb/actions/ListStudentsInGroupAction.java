package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.bootstrap.model.Group;
import ru.levelup.studentdb.service.GroupService;
import ru.levelup.studentdb.service.StudentsInGroup;

@Component("studentlistAction")
@Scope("prototype")
@RequiredArgsConstructor
public class ListStudentsInGroupAction implements Action{

    private String groupName;
    private final GroupService groupService;

    private final StudentsInGroup students;
    @Override
    public void setParams(String... param) {
        this.groupName=param[1];
    }

    @Override
    public void execute() {
        for (Group group:groupService.findAll()) {
            if (groupName.equals(group.getName())){
                System.out.println(students.listStudents(group));
            }
        }
    }
}
