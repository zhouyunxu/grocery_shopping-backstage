package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 杂货店商品管理对象 zhd_good
 * 
 * @author ruoyi
 * @date 2023-02-26
 */
public class ZhdGood extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    private Long goodId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodName;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private BigDecimal goodPrice;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String goodDepict;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String goodUrl;

    /** 是否上架(0未上架    1上架) */
    @Excel(name = "是否上架(0未上架    1上架)")
    private String isGroup;

    /** 上架时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上架时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date upTime;

    /** 下架时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下架时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date downTime;

    public void setGoodId(Long goodId) 
    {
        this.goodId = goodId;
    }

    public Long getGoodId() 
    {
        return goodId;
    }
    public void setGoodName(String goodName) 
    {
        this.goodName = goodName;
    }

    public String getGoodName() 
    {
        return goodName;
    }
    public void setGoodPrice(BigDecimal goodPrice) 
    {
        this.goodPrice = goodPrice;
    }

    public BigDecimal getGoodPrice() 
    {
        return goodPrice;
    }
    public void setGoodDepict(String goodDepict) 
    {
        this.goodDepict = goodDepict;
    }

    public String getGoodDepict() 
    {
        return goodDepict;
    }
    public void setGoodUrl(String goodUrl) 
    {
        this.goodUrl = goodUrl;
    }

    public String getGoodUrl() 
    {
        return goodUrl;
    }
    public void setIsGroup(String isGroup) 
    {
        this.isGroup = isGroup;
    }

    public String getIsGroup() 
    {
        return isGroup;
    }
    public void setUpTime(Date upTime) 
    {
        this.upTime = upTime;
    }

    public Date getUpTime() 
    {
        return upTime;
    }
    public void setDownTime(Date downTime) 
    {
        this.downTime = downTime;
    }

    public Date getDownTime() 
    {
        return downTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("goodId", getGoodId())
            .append("goodName", getGoodName())
            .append("goodPrice", getGoodPrice())
            .append("goodDepict", getGoodDepict())
            .append("goodUrl", getGoodUrl())
            .append("isGroup", getIsGroup())
            .append("upTime", getUpTime())
            .append("downTime", getDownTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
