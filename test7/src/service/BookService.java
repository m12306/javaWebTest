package service;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import vo.Book;

import java.util.List;

/**
 * Description:
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/11/27 19:56
 * @version : 1.0
 */
public class BookService {
    private BookDao bookDao = new BookDaoImpl();

    public List<Book> getBooksByCategoryId(int category_id) {
        return bookDao.findBooksByCategoryId(category_id);
    }
}
