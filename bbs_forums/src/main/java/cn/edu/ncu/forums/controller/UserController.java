package cn.edu.ncu.forums.controller;

import cn.edu.ncu.forums.entity.User;
import cn.edu.ncu.forums.service.UserService;
import cn.edu.ncu.forums.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Description: 用户模块的api
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/14 22:41
 * @version : 1.0
 */
@Controller
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册api，url：localhost:8090/user/register
     * 请求类型： post
     * @param user 用户对象
     * @return 返回信息
     */
    @PostMapping("/register")
    @ResponseBody
    public Message register(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * 用户登录api，url: localhost:8090/user/login
     * @param user 用户对象
     * @return 返回信息
     */
    @PostMapping("/login")
    @ResponseBody
    public Message login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/updateUser")
    @ResponseBody
    public  Message updateUser(User user){
        return  userService.updateUser(user);
    }
//    /**
//     * 查询所有用户
//     * @return 所有用户列表
//     */
//    @GetMapping("/findAll")
//    public @ResponseBody
//    List<User> findAll() {
//        return userService.findAll();
//    }

//    /**
//     * 注册新用户
//     * @param user 用户对象
//     * @return 消息
//     */
//    @PostMapping("/register")
//    public @ResponseBody
//    Message register(@RequestBody User  user) {
//        return userServiceDao.addUser(user);
//    }

//    /**
//     * 注销用户，暂时不用
//     * @param user 用户对象
//     */
//    @PostMapping("/deleteUser")
//    public void deleteUser(User user) {
//        userService.deleteUserById(user.getId());
//    }

//    /**
//     * 查看用户是否存在
//     * @param username 用户名
//     * @return 消息
//     */
//    @GetMapping("/isExisted")
//    @ResponseBody
//    public Message isExited(@RequestParam ("username") String username) {
//        return userService.findUserByUsername(username);
//    }

//    /**
//     * 登录验证
//     * @param receivedUser 接收到的用户
//     * @return message
//     */
//    @PostMapping("/login")
//    @ResponseBody
//    public Message login(@RequestBody User receivedUser) {
//        return userServiceDao.login(receivedUser);
//    }
}
