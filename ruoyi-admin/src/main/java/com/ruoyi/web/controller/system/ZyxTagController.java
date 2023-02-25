package com.ruoyi.web.controller.system;

import java.util.List;

import cn.hutool.core.lang.Assert;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.domain.ZyxTagVo;
import com.ruoyi.system.service.ISysUserService;
import io.swagger.annotations.ApiImplicitParam;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.poi.hssf.record.DVALRecord;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ZyxTag;
import com.ruoyi.system.service.IZyxTagService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 配置广告Controller
 * 
 * @author zyx
 * @date 2022-05-07
 */
@RestController
@RequestMapping("/system/tag")
public class ZyxTagController extends BaseController
{
    @Autowired
    private IZyxTagService zyxTagService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ISysUserService sysUserService;


    /**
     * 通过tag 名字访问接口
     */
    @ApiImplicitParam(name = "tag", value = "广告tag", required = false, paramType = "path", dataType = "String")
    @GetMapping("/getInfo")
    public AjaxResult getInfo(ZyxTag zyxTag,
                              String tag)
    {
        //List<ZyxTag> list = zyxTagService.selectZyxTagList(zyxTag);

        System.out.println(tag);

        //zyxTag.setTag(String.valueOf(tag));
        //查询info信息
        ZyxTagVo list = zyxTagService.selectByInfo(zyxTag);
        String tagInfo1 = list.getTagInfo();
        System.out.println(list);
        System.out.println(tagInfo1);
        String s = String.valueOf(tagInfo1);

        //解析 json 格式字符串
        //com.alibaba.fastjson.JSONArray array = com.alibaba.fastjson.JSONArray.parseArray(s);
       /* com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(s);
        String tagInfo = jsonObject.getString("tagInfo");
        System.out.println(tagInfo);*/

        return AjaxResult.success("查询成功",tagInfo1);
    }



    /**
     * 查询配置广告列表
     */
    //@PreAuthorize("@ss.hasPermi('system:tag:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyxTag zyxTag)
    {
        startPage();
        List<ZyxTag> list = zyxTagService.selectZyxTagList(zyxTag);
        return getDataTable(list);
    }

    /**
     * 导出配置广告列表
     */
    @PreAuthorize("@ss.hasPermi('system:tag:export')")
    @Log(title = "配置广告", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyxTag zyxTag)
    {
        List<ZyxTag> list = zyxTagService.selectZyxTagList(zyxTag);
        ExcelUtil<ZyxTag> util = new ExcelUtil<ZyxTag>(ZyxTag.class);
        return util.exportExcel(list, "配置广告数据");
    }

    /**
     * 获取配置广告详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:tag:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyxTagService.selectZyxTagById(id));
    }

    /**
     * 新增配置广告
     */
    @PreAuthorize("@ss.hasPermi('system:tag:add')")
    @Log(title = "配置广告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyxTag zyxTag)
    {
        //获取创建者
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());  //后台用户
        String username = loginUser.getUsername();   //英文名称
        SysUser sysUser = sysUserService.selectUserByUserName(username);
        String nickName = sysUser.getNickName();    //中文名称

        zyxTag.setCreateBy(nickName);
        zyxTagService.insertZyxTag(zyxTag);
        return AjaxResult.success("新增成功");
    }

    /**
     * 修改配置广告
     */
    @PreAuthorize("@ss.hasPermi('system:tag:edit')")
    @Log(title = "配置广告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyxTag zyxTag)
    {
        //获取创建者
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());  //后台用户
        String username = loginUser.getUsername();   //英文名称
        SysUser sysUser = sysUserService.selectUserByUserName(username);
        String nickName = sysUser.getNickName();    //中文名称

        zyxTag.setUpdateBy(nickName);
        zyxTagService.updateZyxTag(zyxTag);
        return AjaxResult.success("修改成功");
    }

    /**
     * 删除配置广告
     */
    @PreAuthorize("@ss.hasPermi('system:tag:remove')")
    @Log(title = "配置广告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyxTagService.deleteZyxTagByIds(ids));
    }
}
