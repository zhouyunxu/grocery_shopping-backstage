package com.ruoyi.nuo.controller;

import java.util.List;

import com.ruoyi.nuo.domain.ZhouCotent;
import com.ruoyi.nuo.service.IZhouCotentService;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 信息Controller
 *
 * @author ruoyi
 * @date 2021-07-22
 */
@RestController
@RequestMapping("/system/cotent")
public class ZhouCotentController extends BaseController
{
    @Autowired
    private IZhouCotentService zhouCotentService;

    /**
     * 查询信息列表
     */
    //@PreAuthorize("@ss.hasPermi('system:cotent:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZhouCotent zhouCotent)
    {
        startPage();
        List<ZhouCotent> list = zhouCotentService.selectZhouCotentList(zhouCotent);
        return getDataTable(list);
    }

    /**
     * 导出信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:cotent:export')")
    @Log(title = "信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZhouCotent zhouCotent)
    {
        List<ZhouCotent> list = zhouCotentService.selectZhouCotentList(zhouCotent);
        ExcelUtil<ZhouCotent> util = new ExcelUtil<ZhouCotent>(ZhouCotent.class);
        return util.exportExcel(list, "信息数据");
    }

    /**
     * 获取信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cotent:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zhouCotentService.selectZhouCotentById(id));
    }

    /**
     * 新增信息
     */
    @PreAuthorize("@ss.hasPermi('system:cotent:add')")
    @Log(title = "信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZhouCotent zhouCotent)
    {
        return toAjax(zhouCotentService.insertZhouCotent(zhouCotent));
    }

    /**
     * 修改信息
     */
    @PreAuthorize("@ss.hasPermi('system:cotent:edit')")
    @Log(title = "信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZhouCotent zhouCotent)
    {
        return toAjax(zhouCotentService.updateZhouCotent(zhouCotent));
    }

    /**
     * 删除信息
     */
    @PreAuthorize("@ss.hasPermi('system:cotent:remove')")
    @Log(title = "信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhouCotentService.deleteZhouCotentByIds(ids));
    }
}
