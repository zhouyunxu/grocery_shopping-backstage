package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ZhdGood;

/**
 * 杂货店商品管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-26
 */
public interface ZhdGoodMapper 
{
    /**
     * 查询杂货店商品管理
     * 
     * @param goodId 杂货店商品管理ID
     * @return 杂货店商品管理
     */
    public ZhdGood selectZhdGoodById(Long goodId);

    /**
     * 查询杂货店商品管理列表
     * 
     * @param zhdGood 杂货店商品管理
     * @return 杂货店商品管理集合
     */
    public List<ZhdGood> selectZhdGoodList(ZhdGood zhdGood);

    /**
     * 新增杂货店商品管理
     * 
     * @param zhdGood 杂货店商品管理
     * @return 结果
     */
    public int insertZhdGood(ZhdGood zhdGood);

    /**
     * 修改杂货店商品管理
     * 
     * @param zhdGood 杂货店商品管理
     * @return 结果
     */
    public int updateZhdGood(ZhdGood zhdGood);

    /**
     * 删除杂货店商品管理
     * 
     * @param goodId 杂货店商品管理ID
     * @return 结果
     */
    public int deleteZhdGoodById(Long goodId);

    /**
     * 批量删除杂货店商品管理
     * 
     * @param goodIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhdGoodByIds(Long[] goodIds);
}
