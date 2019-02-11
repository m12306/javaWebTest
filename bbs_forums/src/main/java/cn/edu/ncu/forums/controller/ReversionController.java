package cn.edu.ncu.forums.controller;

import cn.edu.ncu.forums.entity.Reversion;
import cn.edu.ncu.forums.service.ReversionService;
import cn.edu.ncu.forums.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Description: reversion的api
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/21 22:32
 * @version : 1.0
 */
@Controller
@RequestMapping(path = "reversion")
public class ReversionController {

    @Autowired
    private ReversionService reversionService;

    /**
     * 添加评论api
     * url: localhost:8090/reversion/addReversion
     * @param reversion 回复对象
     * @return message
     */
    @PostMapping("addReversion")
    @ResponseBody
    public Message addReversion(@RequestBody Reversion reversion) {
        return reversionService.addReversion(reversion);
    }

    /**
     * 通过评论的id查询所有的对应的回复
     * url: localhost:8090/reversion/getByCommentId
     * @param commentId 评论的id
     * @return 返回消息
     */
    @GetMapping("getByCommentId")
    @ResponseBody
    public Message getReversionsByCommentId(@RequestParam ("commentId") Long commentId) {
        return reversionService.findByCommentId(commentId);
    }

    /**
     * 通过回复的id删除回复
     * url: localhost:8090/reversion/delete
     * @param reversionId 回复的id
     * @return 返回消息
     */
    @PostMapping("delete")
    @ResponseBody
    public Message deleteReversion(Long reversionId) {
        return reversionService.delete(reversionId);
    }

    /**
     * 通过评论id查询所有的回复api
     * @param commentId 评论id
     * @return message
     */
    @GetMapping("getRWUs")
    @ResponseBody
    public Message getRWUs(@RequestParam ("commentId") Long commentId) {
        return reversionService.getAllRWUByCommentId(commentId);
    }

    @GetMapping("getRWU")
    @ResponseBody
    public Message getRWUById(@RequestParam ("reversionId") Long reversionId) {
        return reversionService.getRWUById(reversionId);
    }
}
