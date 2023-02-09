package com.simple.hyper.monitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.hyper.monitor.model.dto.LoginLogDTO;
import com.simple.hyper.monitor.model.entity.LoginLog;
import com.simple.hyper.monitor.model.query.LoginLogQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/6
 */
@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {

    @Select("<script>" +
            "select * from t_login_log " +
            "<where>" +
            "<if test=\"nickname != null and nickname != ''\">" +
            "and nickname like concat('%', #{nickname}, '%') " +
            "</if>" +
            "</where> " +
            "order by login_time desc" +
            "</script>")
    List<LoginLogDTO> selectLoginLogList(LoginLogQuery loginLogQuery);

}
