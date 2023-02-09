package com.simple.hyper.auth.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.simple.hyper.auth.mapper.AuthMapper;
import com.simple.hyper.auth.model.query.AuthQuery;
import com.simple.hyper.auth.service.IAuthService;
import com.simple.hyper.common.consts.MsgConsts;
import com.simple.hyper.common.ex.HyperException;
import com.simple.hyper.system.model.enums.StatusType;
import com.simple.hyper.system.model.vo.UserVO;
import com.simple.hyper.system.service.IUserService;
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

    private final IUserService userService;

    @Override
    public UserVO getLoginUserInfo() {
        return userService.getUserById(StpUtil.getLoginIdAsInt());
    }

    @Override
    public SaTokenInfo login(AuthQuery query) {
        UserVO userVO = authMapper.selectUserIdByUsernameAndPassword(query);
        if (userVO == null) {
            throw new HyperException(MsgConsts.LOGIN_ERROR_MSG);
        }
        if (userVO.getStatus() == StatusType.LOCK) {
            throw new HyperException(MsgConsts.USER_LOCK_MSG);
        }
        StpUtil.login(userVO.getId(), query.isRememberMe());
        return StpUtil.getTokenInfo();
    }

    @Override
    public void logout(String token) {
        StpUtil.logoutByTokenValue(token);
    }
}
