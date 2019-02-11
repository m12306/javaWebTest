package dao;

import vo.Category;

import java.util.List;

/**
 * Description:
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/11/27 19:08
 * @version : 1.0
 */
public interface CategoryDao {

    public void add(Category category);

    public void delete(Category category);

    public List<Category> findAll();

}
