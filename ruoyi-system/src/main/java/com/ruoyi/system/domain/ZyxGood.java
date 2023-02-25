package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品对象 zyx_good
 * 
 * @author yunszhou
 * @date 2022-01-12
 */
public class ZyxGood extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodName;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String goodDepict;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private BigDecimal goodPrice;

    /** 商品图片 */
    private String goodUrl;

    /** 使用方法 */
    @Excel(name = "使用方法")
    private String edibleMethod;


    /** 创建者 */
    @Excel(name = "创建者")
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间")
    private Date createTime;

    /** 更新者 */
    @Excel(name = "更新者")
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "更新时间")
    private Date updateTime;

    /** 备注 */
    @Excel(name = "备注")
    private String remark;

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getUpdateBy() {
        return updateBy;
    }

    @Override
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGoodName(String goodName) 
    {
        this.goodName = goodName;
    }

    public String getGoodName() 
    {
        return goodName;
    }
    public void setGoodDepict(String goodDepict) 
    {
        this.goodDepict = goodDepict;
    }

    public String getGoodDepict() 
    {
        return goodDepict;
    }
    public void setGoodPrice(BigDecimal goodPrice) 
    {
        this.goodPrice = goodPrice;
    }

    public BigDecimal getGoodPrice() 
    {
        return goodPrice;
    }
    public void setGoodUrl(String goodUrl) 
    {
        this.goodUrl = goodUrl;
    }

    public String getGoodUrl() 
    {
        return goodUrl;
    }
    public void setEdibleMethod(String edibleMethod) 
    {
        this.edibleMethod = edibleMethod;
    }

    public String getEdibleMethod() 
    {
        return edibleMethod;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goodName", getGoodName())
            .append("goodDepict", getGoodDepict())
            .append("goodPrice", getGoodPrice())
            .append("goodUrl", getGoodUrl())
            .append("edibleMethod", getEdibleMethod())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
