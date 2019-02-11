package cn.edu.ncu.forums.dao;

import cn.edu.ncu.forums.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description: 用户模块的数据库操作封装
 *                 1.通过用户名查询用户
 *                 2. ...
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/14 21:49
 * @version : 1.0
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return 用户
     */
    User findUserByUsername(String username);

    /**
     * 修改用户信息
     * @param phone 手机号
     * @param work 工作
     * @param address 地址
     * @param id id
     */
    @Transactional
    @Modifying
    @Query("update User set phone = ?1, work = ?2, address = ?3 where id = ?4")
    void updateUser(String phone, String work, String address, Long id);

//    /**
//     * 修改用户头像
//     * @param image 头像url
//     * @param id 用户id
//     */
//    @Transactional
//    @Modifying
//    @Query("update User set image = ?1 where id = ?2")
//    void updateUserImage(String image, Long id);

//    /**
//     * 修改用户密码
//     * @param newPassword 新密码
//     * @param id 用户id
//     */
//    @Transactional
//    @Modifying
//    @Query("update User set password = ?1 where id = ?2")
//    void updateUserPassword(String newPassword, Long id);

//    /**
//     * 查询所有用户
//     * @return 用户列表
//     */
//    List<User> findAll();
}
