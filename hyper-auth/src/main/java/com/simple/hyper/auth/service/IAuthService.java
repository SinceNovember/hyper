package com.simple.hyper.auth.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.simple.hyper.auth.model.query.AuthQuery;
import com.simple.hyper.system.model.vo.UserVO;

public interface IAuthService {

    /**
     * 获取登录用户信息
     *
     * @return 用户信息VO
     */
    UserVO getLoginUserInfo();

    /**
     * 登录
     *
     * @param query 查询
     * @return
     */
    SaTokenInfo login(AuthQuery query);

    /**
     * 注销
     *
     * @param token 令牌
     * @return
     */
    void logout(String token);
}
