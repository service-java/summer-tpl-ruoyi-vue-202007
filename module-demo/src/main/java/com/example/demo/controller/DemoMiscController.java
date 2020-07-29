package com.example.demo.controller;

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
import com.example.common.annotation.Log;
import com.example.common.core.controller.BaseController;
import com.example.common.core.domain.AjaxResultVO;
import com.example.common.enums.BusinessType;
import com.example.demo.entity.DemoMisc;
import com.example.demo.service.DemoMiscService;
import com.example.common.utils.poi.ExcelUtil;
import com.example.common.core.page.TableDataInfo;

/**
 * 示例模块Controller
 *
 * @author example
 * @date 2020-07-29
 */
@RestController
@RequestMapping("/demo/misc")
public class DemoMiscController extends BaseController
{
    @Autowired
    private DemoMiscService demoMiscService;

    /**
     * 查询示例模块列表
     */
    @PreAuthorize("@ss.hasPermi('demo:misc:list')")
    @GetMapping("/list")
    public TableDataInfo list(DemoMisc demoMisc)
    {
        startPage();
        List<DemoMisc> list = demoMiscService.selectDemoMiscList(demoMisc);
        return getDataTable(list);
    }

    /**
     * 导出示例模块列表
     */
    @PreAuthorize("@ss.hasPermi('demo:misc:export')")
    @Log(title = "示例模块", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResultVO export(DemoMisc demoMisc)
    {
        List<DemoMisc> list = demoMiscService.selectDemoMiscList(demoMisc);
        ExcelUtil<DemoMisc> util = new ExcelUtil<DemoMisc>(DemoMisc.class);
        return util.exportExcel(list, "misc");
    }

    /**
     * 获取示例模块详细信息
     */
    @PreAuthorize("@ss.hasPermi('demo:misc:query')")
    @GetMapping(value = "/{id}")
    public AjaxResultVO getInfo(@PathVariable("id") Long id)
    {
        return AjaxResultVO.success(demoMiscService.selectDemoMiscById(id));
    }

    /**
     * 新增示例模块
     */
    @PreAuthorize("@ss.hasPermi('demo:misc:add')")
    @Log(title = "示例模块", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResultVO add(@RequestBody DemoMisc demoMisc)
    {
        return toAjax(demoMiscService.insertDemoMisc(demoMisc));
    }

    /**
     * 修改示例模块
     */
    @PreAuthorize("@ss.hasPermi('demo:misc:edit')")
    @Log(title = "示例模块", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResultVO edit(@RequestBody DemoMisc demoMisc)
    {
        return toAjax(demoMiscService.updateDemoMisc(demoMisc));
    }

    /**
     * 删除示例模块
     */
    @PreAuthorize("@ss.hasPermi('demo:misc:remove')")
    @Log(title = "示例模块", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResultVO remove(@PathVariable Long[] ids)
    {
        return toAjax(demoMiscService.deleteDemoMiscByIds(ids));
    }
}
