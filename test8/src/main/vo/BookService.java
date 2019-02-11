package main.vo;

import main.dao.BookDao;
import main.vo.Book;

public class BookService {
    String bookId;
    private BookDao bookDao;
    public BookService(String bookId){
        this.bookId=bookId;
    }
    public BookService(){

    }
    public void addBook(){
        System.out.print(bookId);
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    public void deleteBookByID(String ID){
        bookDao.deleteBookByID(ID);
    }
}
