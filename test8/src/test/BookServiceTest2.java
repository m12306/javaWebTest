package test;

import main.vo.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring.xml")
public class BookServiceTest2 {
        @Autowired
        BookService b;
        @Test
    public void test(){
            System.out.println(b);
          b.deleteBookByID("45");
}
}
