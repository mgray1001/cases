package com.cases;

import java.util.Date;

import com.cases.model.Forum;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class CasesStart {

    public static void maing(String[] args) {
        ApplicationContext ctx = SpringApplication.run(CasesStart.class, args);

       // CasesStart t = new CasesStart();
       // t.testMain();
//
//        System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }


   static Forum getNewCase() {
        Forum c = new Forum();
        c.setCaseId("1000");
        c.setJid("abcdef1234");
        c.setStart(new Date());
        c.setDescription("test case");

        return c;
    }

}
