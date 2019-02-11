package cn.edu.ncu.forums.service;

import cn.edu.ncu.forums.dao.UserDao;
import cn.edu.ncu.forums.entity.User;
import cn.edu.ncu.forums.utils.Message;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

/**
 * Description: 用户服务层
 *              1.注册
 *              2.登录
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/14 22:17
 * @version : 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 注册新用户
     * @param user 用户对象
     */
    public Message addUser(User user) {
        user.setAuthority("user");
        user.setImage("1.png");
        //用户不存在，则进行注册
        if (userDao.findUserByUsername(user.getUsername()) == null) {
            userDao.save(user);
            System.out.println("注册成功");
            return new Message(1, "register successfully", user);
        }
        //用户已存在，返回错误信息
        else {
            System.out.println("注册失败");
            return new Message(0, "fail to register, the user has existed", null);
        }
    }

    /**
     * 登录，包含验证功能，验证用户是否存在，密码是否正确
     * @param user 前端通过http的post请求发来的user
     */
    public Message login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        //用户名为空
        if ("".equals(username)) {
            return new Message(0, "Please fill in the username", null);
        }

        //密码为空
        if (("".equals(password))) {
            return new Message(0, "Please fill in the password", null);
        }

        //数据库查询
        User userInDB = userDao.findUserByUsername(username);

        //用户不存在
        if (userInDB == null) {
            return new Message(10, "User is not existed", null);
        }

        //密码不正确
        if (!password.equals(userInDB.getPassword())) {
            return new Message(0, "Password Error", null);
        }

        //验证成功
        else {
            //生成令牌
            String jwtToken = Jwts.builder()
                    .setSubject(username)
                    .claim("roles", userInDB.getAuthority())
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "secretkey")
                    .compact();
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", userInDB.getId());
            map.put("username", userInDB.getUsername());
            map.put("image", userInDB.getImage());
            map.put("role", userInDB.getAuthority());
            map.put("token", jwtToken);
            return new Message(1, "success", map);
        }
    }

//    /**
//     * 通过id删除用户
//     * @param id 用户唯一标识id
//     */
//    public void deleteUserById(Long id) {
//        userDao.deleteById(id);
//    }

//    /**
//     * 查询所有用户
//     * @return list of users
//     */
//    public List<User> findAll() {
//        return userDao.findAll();
//    }

//    /**
//     * 通过用户名查找用户
//     * @param username 用户名
//     * @return 用户实体
//     */
//    public Message findUserByUsername(String username) {
//        if (userDao.findUserByUsername(username) != null) {
//            return new Message(110, "the user has existed", null);
//        }
//        return new Message(111, "allow you to do it", null);
//    }

    /**
     * 更新/完善用户信息,修改手机号，工作，地址
     * @param user 用户对象
     */
    public Message updateUser(User user) {
       userDao.updateUser(user.getPhone(), user.getWork(), user.getAddress(), user.getId());
        return new Message(1, "success",1);
    }

//    /**
//     * 修改用户头像
//     * @param user 用户
//     */
//    public void updateUserImage(User user) {
//        userDao.updateUserImage(user.getImage(), user.getId());
//    }

//    /**
//     * 修改密码
//     * @param user 用户
//     */
//    public void updateUserPassword(User user) {
//        userDao.updateUserPassword(user.getPassword(), user.getId());
//    }
}
