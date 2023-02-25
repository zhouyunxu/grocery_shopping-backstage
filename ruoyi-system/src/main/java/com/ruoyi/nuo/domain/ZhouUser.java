package com.ruoyi.nuo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 个人用户对象 zhou_user
 *
 * @author ruoyi
 * @date 2021-06-22
 */
public class ZhouUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String name;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;


    //扩展字段
    private List<ZhouCotent> cotentList;

    private List<ZhouUser> userList;

    public List<ZhouUser> getUserList() {
        return userList;
    }

    public void setUserList(List<ZhouUser> userList) {
        this.userList = userList;
    }

    public List<ZhouCotent> getCotentList() {
        return cotentList;
    }

    public void setCotentList(List<ZhouCotent> cotentList) {
        this.cotentList = cotentList;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setAge(Long age)
    {
        this.age = age;
    }

    public Long getAge()
    {
        return age;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("age", getAge())
            .append("email", getEmail())
            .toString();
    }
}
