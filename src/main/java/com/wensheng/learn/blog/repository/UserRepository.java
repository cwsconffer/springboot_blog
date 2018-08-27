package com.wensheng.learn.blog.repository;

import com.wensheng.learn.blog.domain.User;
import org.springframework.data.repository.CrudRepository;


/**
 * user repository 接口：
 */
public interface UserRepository extends CrudRepository<User,Long> {


}
