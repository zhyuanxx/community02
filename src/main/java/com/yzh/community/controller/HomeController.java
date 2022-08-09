package com.yzh.community.controller;

import com.yzh.community.entity.DiscussPost;
import com.yzh.community.entity.Page;
import com.yzh.community.service.DiscussPostService;
import com.yzh.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model , Page page) {
        // 方法调用钱,SpringMVC会自动实例化Model和Page,并将Page注入Model.
        // 所以,在thymeleaf中可以直接访问Page对象中的数据.fssfsfsf
        //获取总数据数
        page.setRows(discussPostService.findDiscussPostRows(0));
        List<DiscussPost> discusss = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String,Object>> discussPosts=new ArrayList<>();
        //再将user信息放入 discusssPost中
        for (DiscussPost post : discusss) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("post",post);
            map.put("user",userService.findUserById(post.getUserId()));
            discussPosts.add(map);
        }
        model.addAttribute("discussPosts",discussPosts);
        //model.addAttribute("page",page);
        return "/index";
    }

}
