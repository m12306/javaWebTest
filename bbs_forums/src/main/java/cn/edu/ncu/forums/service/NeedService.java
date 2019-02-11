package cn.edu.ncu.forums.service;

import cn.edu.ncu.forums.dao.NeedDao;
import cn.edu.ncu.forums.entity.Need;
import cn.edu.ncu.forums.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: need的服务层
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/21 21:03
 * @version : 1.0
 */
@Service
public class NeedService {

    @Autowired
    private NeedDao needDao;

    /**
     * 添加需求
     * @param need 需求对象
     * @return 返回信息
     */
    public Message addNeed(Need need) {
        needDao.save(need);
        return new Message(1, "add need successfully", need);
    }

    /**
     * 根据需求id删除需求
     * @param needId 需求id
     * @return 返回信息
     */
    public Message deleteNeed(Long needId) {
        needDao.deleteById(needId);
        return new Message(1, "delete need successfully", null);
    }

    /**
     * 分页查询，返回一页的need对象
     * @param page 第几页
     * @param size 页得大小
     * @return 返回消息
     */
    public Message findNeedPage(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "createdTime");
        Page<Need> bookPage = needDao.findAll(pageable);
        List<Need> needs = new ArrayList<>();
        for (Need need: bookPage) {
            needs.add(need);
        }
        return new Message(1, "get the needs successfully", needs);
    }
}
