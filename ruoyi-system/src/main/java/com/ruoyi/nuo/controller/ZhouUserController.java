package com.ruoyi.nuo.controller;

import java.util.List;

import cn.hutool.core.lang.Console;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.nuo.domain.ZhouUser;
import com.ruoyi.nuo.service.IZhouUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.yaml.snakeyaml.events.Event;

/**
 * 个人用户Controller
 *
 * @author ruoyi
 * @date 2021-06-22
 */
@RestController
@RequestMapping("/nuo/nuoyi")
public class ZhouUserController extends BaseController
{
    @Autowired
    private IZhouUserService zhouUserService;

    /**
     * 查询个人用户列表
     */
    //@PreAuthorize("@ss.hasPermi('nuo:nuoyi:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZhouUser zhouUser)
    {
        startPage();
        List<ZhouUser> list = zhouUserService.selectZhouUserList(zhouUser);
        return getDataTable(list);
    }


    @GetMapping("/testList")
    public AjaxResult testList()
    {

        String url = "http://sh.bydq.com:8088/system/cpazsq/outSourceLists";

        HttpResponse res = HttpRequest.post(url).execute();
        //预定义的头信息
        Console.log(res.header(Header.CONTENT_ENCODING));
        //自定义头信息
        Console.log(res.header("Content-Disposition"));

        String result1= HttpUtil.get("https://www.baidu.com");



        HttpResponse response = null;


        return AjaxResult.success("查询成功",result1);
    }




    /**
     * 导出个人用户列表
     */
    @PreAuthorize("@ss.hasPermi('nuo:nuoyi:export')")
    @Log(title = "个人用户", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZhouUser zhouUser)
    {
        List<ZhouUser> list = zhouUserService.selectZhouUserList(zhouUser);
        ExcelUtil<ZhouUser> util = new ExcelUtil<ZhouUser>(ZhouUser.class);
        return util.exportExcel(list, "个人用户数据");
    }

    /**
     * 获取个人用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('nuo:nuoyi:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zhouUserService.selectZhouUserById(id));
    }

    /**
     * 新增个人用户
     */
    @PreAuthorize("@ss.hasPermi('nuo:nuoyi:add')")
    @Log(title = "个人用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZhouUser zhouUser)
    {
        return toAjax(zhouUserService.insertZhouUser(zhouUser));
    }

    /**
     * 修改个人用户
     */
    @PreAuthorize("@ss.hasPermi('nuo:nuoyi:edit')")
    @Log(title = "个人用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZhouUser zhouUser)
    {
        return toAjax(zhouUserService.updateZhouUser(zhouUser));
    }

    /**
     * 删除个人用户
     */
    @PreAuthorize("@ss.hasPermi('nuo:nuoyi:remove')")
    @Log(title = "个人用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhouUserService.deleteZhouUserByIds(ids));
    }
}
