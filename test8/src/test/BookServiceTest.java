package test;
import main.vo.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookServiceTest {
    @org.junit.Test
    public void addBook(){
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
        BookService service=(BookService)context.getBean("bookService");
        System.out.println(service);
        service.addBook();
        service.deleteBookByID("123");

    }
}
