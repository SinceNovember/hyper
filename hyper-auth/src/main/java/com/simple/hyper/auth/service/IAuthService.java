package com.simple.hyper.auth.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.simple.hyper.auth.model.query.AuthQuery;

public interface IAuthService {

    SaTokenInfo login(AuthQuery query);

    void logout(String token);
}
