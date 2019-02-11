package test;

import main.vo.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookTest {
    @org.junit.Test
            public  void addBook(){
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
        Book a=(Book)context.getBean("book");
        System.out.println(a);
        System.out.println(a.getBookName());

    }


}
