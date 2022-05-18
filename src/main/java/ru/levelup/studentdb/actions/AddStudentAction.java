package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.bootstrap.model.Group;
import ru.levelup.studentdb.bootstrap.model.Student;
import ru.levelup.studentdb.service.GroupService;
import ru.levelup.studentdb.service.StudentsInGroup;

@Component("studentAddAction")
@Scope("prototype")
@RequiredArgsConstructor
public class AddStudentAction implements Action {

    private String firstName;
    private String lastName;
    private String groupName;
    private final StudentsInGroup students;
    private final GroupService groupService;


    @Override
    public void setParams(String... param) {
        this.firstName = param[0];
        this.lastName = param[1];
        this.groupName =param[3];
    }

    @Override
    public void execute() {
        Student student=new Student(firstName,lastName);
        for (Group group:groupService.findAll()) {
            if (groupName.equals(group.getName())){
                students.addStudent(student,group);
            }
        }
        System.out.println("Student "+student.getFirstName()+" "+student.getLastName()+" added in group "+groupName);
    }
}
