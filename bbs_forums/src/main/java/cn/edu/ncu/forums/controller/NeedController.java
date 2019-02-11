package cn.edu.ncu.forums.controller;

import cn.edu.ncu.forums.entity.Need;
import cn.edu.ncu.forums.service.NeedService;
import cn.edu.ncu.forums.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Description: need的api
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/21 21:14
 * @version : 1.0
 */
@Controller
@RequestMapping("/need")
public class NeedController {
    @Autowired
    private NeedService needService;

    /**
     * 添加需求api，url: localhost:8090/need/addNeed
     * @param need 需求对象
     * @return 返回消息
     */
    @PostMapping("/addNeed")
    @ResponseBody
    public Message addNeed(@RequestBody Need need) {
        return needService.addNeed(need);
    }

    /**
     * 通过需求id删除需求api，url: localhost:8090/need/deleteNeed
     * @param needId 需求id
     * @return 返回消息
     */
    @PostMapping("/deleteNeed")
    @ResponseBody
    public Message deleteNeed(Long needId) {
        return needService.deleteNeed(needId);
    }

    /**
     * 通过页数和页大小获取一页的需求
     * url: localhost:8090/need/getNeedPage?page=?&size=?
     * @param page 第几页
     * @param size 页的大小
     * @return message
     */
    @GetMapping("/getNeedPage")
    @ResponseBody
    public Message getNeedPage(@RequestParam ("page") Integer page, @RequestParam ("size") Integer size) {
        return needService.findNeedPage(page, size);
    }
}
