package com.ruoyi.nuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.nuo.domain.ZhouCotent;
import com.ruoyi.nuo.mapper.ZhouCotentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.nuo.mapper.ZhouUserMapper;
import com.ruoyi.nuo.domain.ZhouUser;
import com.ruoyi.nuo.service.IZhouUserService;

/**
 * 个人用户Service业务层处理
 *
 * @author ruoyi
 * @date 2021-06-22
 */
@Service
public class ZhouUserServiceImpl implements IZhouUserService
{
    @Autowired
    private ZhouUserMapper zhouUserMapper;

    @Autowired
    private ZhouCotentMapper zhouCotentMapper;


    /**
     * 查询个人用户
     *
     * @param id 个人用户ID
     * @return 个人用户
     */
    @Override
    public ZhouUser selectZhouUserById(Long id)
    {
        return zhouUserMapper.selectZhouUserById(id);
    }

    /**
     * 查询个人用户列表
     *
     * @param zhouUser 个人用户
     * @return 个人用户
     */
    @Override
    public List<ZhouUser> selectZhouUserList(ZhouUser zhouUser)
    {

        //在这里把内容表的数据返回
        //1.创建一个集合
        List<ZhouUser> userList = new ArrayList<>();
        //查询出用户
        List<ZhouUser> users = zhouUserMapper.selectZhouUserList(zhouUser);


        //查询出内容表的数据
        ZhouCotent zhouCotent = new ZhouCotent();
        List<ZhouCotent> zhouCotents = zhouCotentMapper.selectZhouCotentList(zhouCotent);
        for (ZhouUser user : users) {
            user.setCotentList(zhouCotents);
            userList.add(user);
        }
        System.out.println(userList);

        List<ZhouUser> List = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            List.add(userList.get(i));
        }
        System.out.println(List);


        return List;
    }

    /**
     * 新增个人用户
     *
     * @param zhouUser 个人用户
     * @return 结果
     */
    @Override
    public int insertZhouUser(ZhouUser zhouUser)
    {
        return zhouUserMapper.insertZhouUser(zhouUser);
    }

    /**
     * 修改个人用户
     *
     * @param zhouUser 个人用户
     * @return 结果
     */
    @Override
    public int updateZhouUser(ZhouUser zhouUser)
    {
        return zhouUserMapper.updateZhouUser(zhouUser);
    }

    /**
     * 批量删除个人用户
     *
     * @param ids 需要删除的个人用户ID
     * @return 结果
     */
    @Override
    public int deleteZhouUserByIds(Long[] ids)
    {
        return zhouUserMapper.deleteZhouUserByIds(ids);
    }

    /**
     * 删除个人用户信息
     *
     * @param id 个人用户ID
     * @return 结果
     */
    @Override
    public int deleteZhouUserById(Long id)
    {
        return zhouUserMapper.deleteZhouUserById(id);
    }
}
