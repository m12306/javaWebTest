package dao;

import vo.Book;

import java.util.List;

/**
 * Description:
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/11/27 19:46
 * @version : 1.0
 */
public interface BookDao {

    public void add(Book book);

    public void delete(Book book);

    public List<Book> findAll();

    public List<Book> findBooksByCategoryId(int category_Id);

}
