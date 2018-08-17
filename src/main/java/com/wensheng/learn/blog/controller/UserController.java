package com.wensheng.learn.blog.controller;

import com.wensheng.learn.blog.domain.User;
import com.wensheng.learn.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * userController
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello")
    public String hello() {
        return null;
    }

    /**
     * 查询所有用户
     * springMvc  返回一个页面的作用 视图和模型
     */
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userRepository.listUsers());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("/users/list", "userModel", model);
    }

    /**
     * 根据id来查询用户
     * springMvc  返回一个页面的作用 视图和模型
     *
     * @PathVarible 标识是在路径里面的
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {

        User userById = userRepository.getUserById(id);
        model.addAttribute("user", userById);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("/users/view", "userModel", model);
    }

    /**
     * 获取创建表单页面接口
     *
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("/users/form", "userModel", model);
    }

    /**
     * 保存user
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user) {
        user  = userRepository.saveOrUpdateUser(user);
        return new ModelAndView("/users/form", "userModel", user);
    }

}
