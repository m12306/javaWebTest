package cn.edu.ncu.forums.controller;

import cn.edu.ncu.forums.entity.Article;
import cn.edu.ncu.forums.service.ArticleService;
import cn.edu.ncu.forums.utils.Message;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/21 14:05
 * @version : 1.0
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 添加文章api, url: localhost:8090/article/addArticle
     * @param article 文章
     * @return message
     */
    @PostMapping("/addArticle")
    @ResponseBody
    public Message addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }

    /**
     * 获取所有文章列表
     * @return message
     */
    @GetMapping("/list")
    @ResponseBody
    public Message getAllArticles() {
        return articleService.findAllUserArticle();
    }

    /**
     * 查询所有文章（分页查询）api, url: localhost:8090/article/getArticlePage
     * @param page 第几页，从0开始
     * @param size 页面大小
     * @return 一页问斩的列表
     */
    @GetMapping("/getArticlePage")
    @ResponseBody
    public Message getArticlePage(@RequestParam ("page") Integer page, @RequestParam ("size") Integer size) {
        return articleService.findBookPage(page, size);
    }

    /**
     * 管理员对文章加精api, url: localhost:8090/article/setPicked
     * @param picked 精选？
     * @param articleId 文章id
     * @return message
     */
    @GetMapping("/setPicked")
    @ResponseBody
    public Message setPicked(@RequestParam("picked") Boolean picked, @RequestParam("id") Long articleId) {
        return articleService.updatePicked(picked, articleId);
    }
    /**
     * 用户或管理员修改文章api, url: localhost:8090/article/updateContent
     * @return message
     */
    @PostMapping("/updateContent")
    @ResponseBody
    public Message updateContent(@RequestBody Article art) {
        System.out.println(art);
        return articleService.updateArticle(art);
    }
    /**
     * 用户或管理员删除文章api, url: localhost:8090/article/delete
     * @param articleId 文章Id
     * @return message
     */
    @PostMapping("/delete")
    @ResponseBody
    public Message delete(Long articleId) {
        return articleService.delete(articleId);
    }

    /**
     * 通过id查找文章api, url: localhost:8090/article/findById
     * @param id 文章的id
     * @return message
     */
    @GetMapping("/findById")
    @ResponseBody
    public Message findById(@RequestParam ("articleId") Long id) {
        return articleService.findById(id);
    }

    @GetMapping("/content")
    @ResponseBody
    public Message getContentById(@RequestParam ("articleId") Long id) {
        return articleService.getContent(id);
    }

    /**
     * 设置置顶、取消置顶
     * @param article 文章对象
     * @return message
     */
    @PostMapping("/updateTop")
    @ResponseBody
    public Message updateTop(@RequestBody Article article) {
        System.out.println(article);
        return articleService.setIsTop(article);
    }

    /**
     * 点赞api
     */
    @PostMapping("like")
    @ResponseBody
    public Message like(@RequestBody Article article) {
        return articleService.like(article);
    }

    /**
     * 取消点赞
     */
    @PostMapping("recover")
    @ResponseBody
    public Message recover(@RequestBody Article article) {
        return articleService.recoverLiked(article);

    }
}
