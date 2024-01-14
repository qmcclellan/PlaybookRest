package com.rest.playbookrest;

import com.rest.playbookrest.Aop.GlobalAop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class PlaybookRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaybookRestApplication.class, args);

    }

}
