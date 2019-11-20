package com.ersc.mapper;

import com.ersc.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author yyl
 * @Date 2019/11/18 0018 上午 1:18
 * @Version 1.0
 */
public interface UserMapper {
    /**
     * 查询操作
     */
    @Select("SELECT * FROM Tb_user")
    List<User> findAll();
}
