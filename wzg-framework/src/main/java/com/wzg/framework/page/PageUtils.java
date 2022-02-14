package com.wzg.framework.page;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.function.Function;

/**
 * <p>
 * 分页工具类
 * </p>
 *
 * @author LuoPing
 * @since 2022/2/14
 */
public class PageUtils {
    /**
     * page类型转化
     *
     * @param iPage IPage对象
     * @param fun Function函数接口
     * @return PageVO
     */
    public static <T, U> PageVO<T> toPageVO(IPage<U> iPage, Function<List<U>, List<T>> fun) {
        PageVO<T> pageVO = new PageVO<>();
        pageVO.setTotal(iPage.getTotal());
        pageVO.setPageNum(iPage.getCurrent());
        pageVO.setPageSize(iPage.getSize());
        List<U> records = iPage.getRecords();
        if (CollectionUtil.isEmpty(records)) {
            return pageVO;
        }
        List<T> list = fun.apply(records);
        pageVO.setData(list);
        return pageVO;
    }
}
