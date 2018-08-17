package com.wensheng.learn.blog.repository;

import com.wensheng.learn.blog.domain.User;

import java.util.List;

/**
 * user repository 接口：
 */
public interface UserRepository {
    /**
     * 创建或者修改用户
     *
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 根据id查询单个用户
     *
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 获取用户列表
     *
     * @return
     */
    List<User> listUsers();

}
