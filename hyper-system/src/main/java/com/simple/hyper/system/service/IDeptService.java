package com.simple.hyper.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.hyper.common.base.TreeModel;
import com.simple.hyper.system.model.entity.Dept;
import com.simple.hyper.system.model.query.DeptQuery;
import com.simple.hyper.system.model.vo.DeptVO;
import java.util.List;

public interface IDeptService extends IService<Dept> {

    /**
     * 分页获取部门
     *
     * @param deptQuery 部门查询
     * @return 分页部门VO
     */
    PageSerializable<DeptVO> pageDept(DeptQuery deptQuery);


    /**
     * 添加或更新部门
     *
     * @param deptQuery 部门查询
     */
    void addOrUpdateDept(DeptQuery deptQuery);

    /**
     * 通过id获取部门
     *
     * @param id id
     * @return 部门信息VO
     */
    DeptVO getDeptById(Integer id);

    /**
     * 菜单树模型列表
     *
     * @return
     */
    List<TreeModel> listDeptTreeModel();

    /**
     * 删除部门
     *
     * @param ids id
     */
    void deleteDept(List<Integer> ids);
}
