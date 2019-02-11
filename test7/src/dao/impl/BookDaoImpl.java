package dao.impl;

import dao.BookDao;
import dao.JDBCUtil;
import vo.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/11/27 19:48
 * @version : 1.0
 */
public class BookDaoImpl implements BookDao {
    @Override
    public void add(Book book) {

    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public List<Book> findBooksByCategoryId(int category_Id) {
        Connection connection = null;
        List<Book> books = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from book where category_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, category_Id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                book.setDescription(rs.getString("description"));
                book.setImage(rs.getString("image"));
                book.setCategory_id(rs.getString("category_id"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return books;
    }
}
