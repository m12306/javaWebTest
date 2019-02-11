package test;

import main.vo.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    @org.junit.Test
    public void addUser(){
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
        UserService service=(UserService)context.getBean("userService");
        System.out.println(service);
        service.addUser();

    }
}

