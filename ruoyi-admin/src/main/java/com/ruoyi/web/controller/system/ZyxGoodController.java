package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import io.swagger.annotations.*;
import org.springframework.data.redis.core.RedisTemplate;
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
import com.ruoyi.system.domain.ZyxGood;
import com.ruoyi.system.service.IZyxGoodService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.validation.constraints.Size;

/**
 * 商品Controller
 * 
 * @author yunszhou
 * @date 2022-01-12
 */
@Api(description = "用户管理")
@RestController
@RequestMapping("/system/good")
public class ZyxGoodController extends BaseController
{
    @Autowired
    private IZyxGoodService zyxGoodService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    public RedisTemplate redisTemplate;


    @Autowired
    private ISysDeptService deptService;



    /**
     * 查询商品列表
     */
    //@PreAuthorize("@ss.hasPermi('system:good:list')")
    //@Api(description = "用户管理")
    @ApiOperation("商品管理查询接口")
    @GetMapping("/list")
    public TableDataInfo list(ZyxGood zyxGood)
    {
        startPage();
        List<ZyxGood> list = zyxGoodService.selectZyxGoodList(zyxGood);

        String deptIds = "100,101";
        String[] split = deptIds.split(",");
        for (int i = 0; i < split.length; i++) {
            String deptId = split[i];

            //sysUserService.


        }



        //存到redis一个值
//        redisCache.setCacheObject("zhou","1");
//
//        //redisCache.setCacheObject("zhou");
//        Object zhou = redisCache.getCacheObject("zhou");
//        System.out.println(zhou);
//
//        //执行完以后把redis中的值删除掉
//        redisCache.deleteObject("zhou");
//
//        Object zhou1 = redisCache.getCacheObject("zhou");
//        System.out.println(zhou1);


        //测试redis中存值
       /* //redisCache.setCacheObject(zhou,"zhangsan",10, TimeUnit.SECONDS);
        //Boolean zhou1 = redisTemplate.expire("yun", 10, TimeUnit.SECONDS);
        String value = "zhangsan";

        //获取值
        String captcha = redisCache.getCacheObject("zhou");
        System.out.println(captcha);
        if (captcha == null){
            redisCache.setCacheObject("zhou",value,60,TimeUnit.SECONDS);
        }
        System.out.println(captcha);*/


        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @ApiOperation("商品管理导出接口")
    @PreAuthorize("@ss.hasPermi('system:good:export')")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyxGood zyxGood)
    {
        List<ZyxGood> list = zyxGoodService.selectZyxGoodList(zyxGood);
        ExcelUtil<ZyxGood> util = new ExcelUtil<ZyxGood>(ZyxGood.class);
        return util.exportExcel(list, "商品数据");
    }

    /**
     * 获取商品详细信息
     */
    @ApiOperation("获取商品详细信息接口")
    //@ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('system:good:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyxGoodService.selectZyxGoodById(id));
    }

    /**
     * 新增商品
     */
    @ApiOperation("新增商品接口")
    @PreAuthorize("@ss.hasPermi('system:good:add')")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @RepeatSubmit   //TODO ==>  接口同一参数可以防止重复提交  redis 控制时间 10秒钟一次
    @PostMapping
    public AjaxResult add(@RequestBody ZyxGood zyxGood)
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());  //后台用户
        String username = loginUser.getUsername();   //英文名称
        SysUser sysUser = sysUserService.selectUserByUserName(username);
        String nickName = sysUser.getNickName();    //中文名称

        zyxGood.setCreateBy(nickName);
        return toAjax(zyxGoodService.insertZyxGood(zyxGood));
    }

    /**
     * 修改商品
     */
    @ApiOperation("修改商品接口")
    @PreAuthorize("@ss.hasPermi('system:good:edit')")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyxGood zyxGood)
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());  //后台用户
        String username = loginUser.getUsername();   //英文名称
        SysUser sysUser = sysUserService.selectUserByUserName(username);
        String nickName = sysUser.getNickName();    //中文名称


        zyxGood.setUpdateBy(nickName);
        return toAjax(zyxGoodService.updateZyxGood(zyxGood));
    }

    /**
     * 删除商品
     */
    @PreAuthorize("@ss.hasPermi('system:good:remove')")
    @Log(title = "商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyxGoodService.deleteZyxGoodByIds(ids));
    }
}
