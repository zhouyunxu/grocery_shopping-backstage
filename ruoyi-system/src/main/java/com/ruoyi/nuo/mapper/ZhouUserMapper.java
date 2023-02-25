package com.ruoyi.nuo.mapper;

import java.util.List;
import com.ruoyi.nuo.domain.ZhouUser;

/**
 * 个人用户Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-22
 */
public interface ZhouUserMapper 
{
    /**
     * 查询个人用户
     * 
     * @param id 个人用户ID
     * @return 个人用户
     */
    public ZhouUser selectZhouUserById(Long id);

    /**
     * 查询个人用户列表
     * 
     * @param zhouUser 个人用户
     * @return 个人用户集合
     */
    public List<ZhouUser> selectZhouUserList(ZhouUser zhouUser);

    /**
     * 新增个人用户
     * 
     * @param zhouUser 个人用户
     * @return 结果
     */
    public int insertZhouUser(ZhouUser zhouUser);

    /**
     * 修改个人用户
     * 
     * @param zhouUser 个人用户
     * @return 结果
     */
    public int updateZhouUser(ZhouUser zhouUser);

    /**
     * 删除个人用户
     * 
     * @param id 个人用户ID
     * @return 结果
     */
    public int deleteZhouUserById(Long id);

    /**
     * 批量删除个人用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhouUserByIds(Long[] ids);
}
