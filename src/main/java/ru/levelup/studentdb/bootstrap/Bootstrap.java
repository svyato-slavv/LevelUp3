package ru.levelup.studentdb.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.bootstrap.model.Group;
import ru.levelup.studentdb.bootstrap.model.Student;
import ru.levelup.studentdb.service.CommandProcessor;
import ru.levelup.studentdb.service.GroupService;
import ru.levelup.studentdb.service.StudentsService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {
    private final CommandProcessor processor;

//    public Bootstrap(StudentsService studentsService,GroupService groupService) {
//        this.studentsService = studentsService;
//        this.groupService=groupService;
//      Заменили данный конструктор на аннотацию Lombok @RequiredArgsConstructor.
//    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Please,enter command");
        System.out.println(">");

        String line;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        while (!(line = bufferedReader.readLine()).equals("exit")) {
            String[] tokens = line.split(" ");
            processor.process(tokens[0], Arrays.copyOfRange(tokens,1, tokens.length));
        }

        System.out.println();
    }
}
