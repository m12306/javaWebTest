package test;

import main.vo.CategoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CategoryTest {
    @org.junit.Test
    public void addCategory(){
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
        CategoryService service=(CategoryService)context.getBean("categoryService");
        System.out.println(service);
        service.addCategory();}
}
