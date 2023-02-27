package com.ruoyi.web.controller.system;

import java.util.List;
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
import com.ruoyi.system.domain.ZhdGood;
import com.ruoyi.system.service.IZhdGoodService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 杂货店商品管理Controller
 * 
 * @author ruoyi
 * @date 2023-02-26
 */
@RestController
@RequestMapping("/system/good")
public class ZhdGoodController extends BaseController
{
    @Autowired
    private IZhdGoodService zhdGoodService;

    /**
     * 查询杂货店商品管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:good:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZhdGood zhdGood)
    {
        startPage();
        List<ZhdGood> list = zhdGoodService.selectZhdGoodList(zhdGood);
        return getDataTable(list);
    }

    /**
     * 导出杂货店商品管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:good:export')")
    @Log(title = "杂货店商品管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZhdGood zhdGood)
    {
        List<ZhdGood> list = zhdGoodService.selectZhdGoodList(zhdGood);
        ExcelUtil<ZhdGood> util = new ExcelUtil<ZhdGood>(ZhdGood.class);
        return util.exportExcel(list, "杂货店商品管理数据");
    }

    /**
     * 获取杂货店商品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:good:query')")
    @GetMapping(value = "/{goodId}")
    public AjaxResult getInfo(@PathVariable("goodId") Long goodId)
    {
        return AjaxResult.success(zhdGoodService.selectZhdGoodById(goodId));
    }

    /**
     * 新增杂货店商品管理
     */
    @PreAuthorize("@ss.hasPermi('system:good:add')")
    @Log(title = "杂货店商品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZhdGood zhdGood)
    {
        return toAjax(zhdGoodService.insertZhdGood(zhdGood));
    }

    /**
     * 修改杂货店商品管理
     */
    @PreAuthorize("@ss.hasPermi('system:good:edit')")
    @Log(title = "杂货店商品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZhdGood zhdGood)
    {
        return toAjax(zhdGoodService.updateZhdGood(zhdGood));
    }

    /**
     * 删除杂货店商品管理
     */
    @PreAuthorize("@ss.hasPermi('system:good:remove')")
    @Log(title = "杂货店商品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{goodIds}")
    public AjaxResult remove(@PathVariable Long[] goodIds)
    {
        return toAjax(zhdGoodService.deleteZhdGoodByIds(goodIds));
    }
}
