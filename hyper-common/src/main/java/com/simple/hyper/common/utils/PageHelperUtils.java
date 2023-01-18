package com.simple.hyper.common.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.simple.hyper.common.base.query.PageQuery;
import org.springframework.util.Assert;

import java.util.List;
import java.util.function.Function;

/**
 * PageHelper工具类
 *
 * @author SinceNovember
 * @date 2022/11/25
 */
public final class PageHelperUtils {

    private PageHelperUtils() {
        throw new IllegalStateException("Utility class");
    }

    private static final int DEFAULT_PAGE_NUM = 1;

    private static final int DEFAULT_PAGE_SIZE = 10;

    private static final String DEFAULT_ORDER_BY = "order_num";

    private static final String DEFAULT_ORDER_TYPE = "desc";



    /**
     * 分页包装
     *
     * @param pageQuery 页面查询
     */
    public static void startPage(PageQuery pageQuery) {
        if (pageQuery.getPageSize() == 0) {
            pageQuery.setPageNum(DEFAULT_PAGE_NUM);
            pageQuery.setPageSize(DEFAULT_PAGE_SIZE);
        }
        if (StringUtils.isBlank(pageQuery.getOrderBy())) {
            pageQuery.setOrderBy(DEFAULT_ORDER_BY);
            pageQuery.setOrderType(DEFAULT_ORDER_TYPE);
        }
        PageHelper.startPage(pageQuery.getPageNum(), pageQuery.getPageSize(),
                StringUtils.toUnderlineCase(pageQuery.getOrderBy()) + " " + pageQuery.getOrderType());
    }

    /**
     * 将分页的dto列表转为分页vo列表
     *
     * @param sources         来源列表
     * @param convertFunction 转换函数
     * @return
     */
    public static <S, R> PageSerializable<R> convertPageDto2Vo(List<S> sources, Function<List<S>, List<R>> convertFunction) {
        Assert.notNull(sources, "sources cannot null");
        Assert.notNull(convertFunction, "convertFunction cannot null");

        PageSerializable pageSerializable = PageSerializable.of(sources);
        pageSerializable.setList(convertFunction.apply(sources));
        return (PageSerializable<R>) pageSerializable;
    }
}
