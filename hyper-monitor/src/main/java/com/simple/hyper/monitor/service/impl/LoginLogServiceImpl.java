package com.simple.hyper.monitor.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.simple.hyper.common.utils.PageHelperUtils;
import com.simple.hyper.monitor.mapper.LoginLogMapper;
import com.simple.hyper.monitor.mapping.LoginLogMapping;
import com.simple.hyper.monitor.model.dto.LoginLogDTO;
import com.simple.hyper.monitor.model.entity.LoginLog;
import com.simple.hyper.monitor.model.query.LoginLogQuery;
import com.simple.hyper.monitor.model.vo.LoginLogVO;
import com.simple.hyper.monitor.service.ILoginLogService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/6
 */
@Service
@RequiredArgsConstructor
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements
        ILoginLogService {

    @Override
    public PageSerializable<LoginLogVO> pageLoginLog(LoginLogQuery loginLogQuery) {
        PageHelper.startPage(loginLogQuery.getPageNum(), loginLogQuery.getPageSize());
        List<LoginLogDTO> loginLogDTOS = baseMapper.selectLoginLogList(
                loginLogQuery);

        if (CollectionUtils.isEmpty(loginLogDTOS)) {
            return new PageSerializable<>();
        }
        return PageHelperUtils.convertPageDto2Vo(loginLogDTOS,
                LoginLogMapping.INSTANCE::toLoginLogVOList);
    }

    @Override
    public void addLoginLog(LoginLogQuery loginLogQuery) {
        LoginLogDTO loginLogDTO = LoginLogMapping.INSTANCE.toLoginLogDTO(
                loginLogQuery);
        this.save(LoginLogMapping.INSTANCE.toLoginLog(loginLogDTO));
    }

    @Override
    public LoginLogVO getLoginLogById(Integer id) {
        return LoginLogMapping.INSTANCE.toLoginLogVO(getById(id));
    }

    @Override
    public void deleteLoginLog(List<Integer> ids) {
        remove(Wrappers.<LoginLog>lambdaUpdate()
                .in(LoginLog::getId, ids));
    }
}
