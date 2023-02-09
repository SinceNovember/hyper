package com.simple.hyper.auth.mapper;

import com.simple.hyper.auth.model.query.AuthQuery;
import com.simple.hyper.system.model.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AuthMapper {

    @Select("select * from t_user where deleted != 1 "
            + "and username =#{username} and password =#{password} ")
    UserVO selectUserIdByUsernameAndPassword(AuthQuery query);
}
