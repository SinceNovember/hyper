package com.simple.hyper.auth.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.simple.hyper.auth.mapper.AuthMapper;
import com.simple.hyper.auth.model.query.AuthQuery;
import com.simple.hyper.auth.service.IAuthService;
import com.simple.hyper.common.consts.MsgConsts;
import com.simple.hyper.common.ex.HyperException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/18
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final AuthMapper authMapper;

    @Override
    public SaTokenInfo login(AuthQuery query) {
        Integer userId = authMapper.selectUserIdByUsernameAndPassword(query);
        if (userId == null) {
            throw new HyperException(MsgConsts.LOGIN_ERROR_MSG);
        }
        StpUtil.login(userId);
        return StpUtil.getTokenInfo();
    }

    @Override
    public void logout(String token) {
        StpUtil.logoutByTokenValue(token);
    }
}
