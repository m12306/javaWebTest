package service;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import vo.Category;

import java.util.List;

/**
 * Description:
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/11/27 19:23
 * @version : 1.0
 */
public class CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();

    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
