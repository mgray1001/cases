package com.cases;

import java.util.Date;

import com.cases.model.Case;
import com.cases.repository.ICaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

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


   static Case getNewCase() {
        Case c = new Case();
        c.setCaseId("1000");
        c.setJid("abcdef1234");
        c.setStart(new Date());
        c.setDescription("test case");

        return c;
    }

}
