package ru.levelup.studentdb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.actions.Action;
import ru.levelup.studentdb.actions.CreateStudentAction;
import ru.levelup.studentdb.actions.ListStudentAction;
import ru.levelup.studentdb.bootstrap.model.Student;
import ru.levelup.studentdb.service.CommandProcessor;
import ru.levelup.studentdb.service.StudentsService;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class CommandProcessImpl implements CommandProcessor, ApplicationContextAware {
    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    @Override
    public void process(String cmd, String... args) {
        Object actionObject=ctx.getBean(args[0]+cmd+"Action");
        if (actionObject instanceof Action) {
            Action action = (Action) actionObject;
            action.setParams(Arrays.copyOfRange(args,1,args.length));
            action.execute();
            if ("create".equals(cmd)&&"student".equals(args[0])){
                System.out.println("Student created");
            }else if ("create".equals(cmd)&&"group".equals(args[0])){
                System.out.println("Group created");
            }
        }else {
            System.out.println("Unknown");
        }
    }

//    @Override
//    public void process(String cmd, String... args) {
//        if ("create".equals(cmd)) {
//            if ("student".equals(args[0])) {
//                CreateStudentAction action = ctx.getBean(CreateStudentAction.class);
//                action.setParams(Arrays.copyOfRange(args, 1, args.length));
//                action.execute();
//                System.out.println("Student created");
//            } else if ("group".equals(args[0])) {
//
//            } else {
//                System.out.println("Unknown arg " + args[0]);
//            }
//
//        } else if ("list".equals(cmd)) {
//            if ("students".equals(args[0])) {
//                ListStudentAction action=ctx.getBean(ListStudentAction.class);
//                action.execute();
//            }
//
//        } else if ("save".equals(cmd)) {
//
//        } else if ("load".equals(cmd)) {
//
//        } else {
//            System.out.println("Unknown command");
//        }
//    }


}
