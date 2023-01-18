package com.simple.hyper.auth.mapper;

import com.simple.hyper.auth.model.query.AuthQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AuthMapper {

    @Select("select id from t_user where deleted != 1 and username =#{username} and password =#{password} ")
    Integer selectUserIdByUsernameAndPassword(AuthQuery query);
}
