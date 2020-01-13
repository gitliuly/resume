package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.LnIndustry;
import com.ruoyi.system.service.ILnIndustryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 行业Controller
 *
 * @author guzf
 * @date 2020-01-13
 */
@Controller
@RequestMapping("/system/industry")
public class LnIndustryController extends BaseController {
    private String prefix = "system/industry";

    @Autowired
    private ILnIndustryService lnIndustryService;

    @RequiresPermissions("system:industry:view")
    @GetMapping()
    public String industry() {
        return prefix + "/industry";
    }

    /**
     * 查询行业列表
     */
    @RequiresPermissions("system:industry:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LnIndustry lnIndustry) {
        startPage();
        List<LnIndustry> list = lnIndustryService.selectLnIndustryList(lnIndustry);
        return getDataTable(list);
    }

    /**
     * 导出行业列表
     */
    @RequiresPermissions("system:industry:export")
    @Log(title = "行业", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LnIndustry lnIndustry) {
        List<LnIndustry> list = lnIndustryService.selectLnIndustryList(lnIndustry);
        ExcelUtil<LnIndustry> util = new ExcelUtil<LnIndustry>(LnIndustry.class);
        return util.exportExcel(list, "industry");
    }

    /**
     * 新增行业
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存行业
     */
    @RequiresPermissions("system:industry:add")
    @Log(title = "行业", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LnIndustry lnIndustry) {
        return toAjax(lnIndustryService.insertLnIndustry(lnIndustry));
    }

    /**
     * 修改行业
     */
    @GetMapping("/edit/{industryId}")
    public String edit(@PathVariable("industryId") Long industryId, ModelMap mmap) {
        LnIndustry lnIndustry = lnIndustryService.selectLnIndustryById(industryId);
        mmap.put("lnIndustry", lnIndustry);
        return prefix + "/edit";
    }

    /**
     * 修改保存行业
     */
    @RequiresPermissions("system:industry:edit")
    @Log(title = "行业", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LnIndustry lnIndustry) {
        return toAjax(lnIndustryService.updateLnIndustry(lnIndustry));
    }

    /**
     * 删除行业
     */
    @RequiresPermissions("system:industry:remove")
    @Log(title = "行业", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(lnIndustryService.deleteLnIndustryByIds(ids));
    }
}
