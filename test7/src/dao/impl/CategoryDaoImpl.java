package dao.impl;

import dao.CategoryDao;
import dao.JDBCUtil;
import vo.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/11/27 19:09
 * @version : 1.0
 */
public class CategoryDaoImpl implements CategoryDao {

    @Override
    public void add(Category category) {
        Connection connection = null;
        PreparedStatement stat = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "insert into category values(?, ?, ?)";
            stat = connection.prepareStatement(sql);
            stat.setInt(1, category.getId());
            stat.setString(2, category.getName());
            stat.setString(3, category.getDescription());
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
    }

    @Override
    public void delete(Category category) {
        Connection connection = null;
        PreparedStatement stat = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "delete category where id = ? and name = ? and description = ?";
            stat = connection.prepareStatement(sql);
            stat.setInt(1, category.getId());
            stat.setString(2, category.getName());
            stat.setString(3, category.getDescription());
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
    }

    @Override
    public List<Category> findAll() {
        Connection connection = null;
        Statement stat = null;
        List<Category> list = new ArrayList<>();
        try {
            connection = JDBCUtil.getConnection();
            stat = connection.createStatement();
            String sql = "select id, name, description from category";
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                category.setDescription(resultSet.getString("description"));
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return list;
    }
}
