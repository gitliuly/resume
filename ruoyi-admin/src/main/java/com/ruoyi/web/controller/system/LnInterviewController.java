package com.ruoyi.web.controller.system;

import java.util.List;

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
import com.ruoyi.system.domain.LnInterview;
import com.ruoyi.system.service.ILnInterviewService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 面试记录Controller
 *
 * @author guzf
 * @date 2020-01-16
 */
@Controller
@RequestMapping("/system/interview")
public class LnInterviewController extends BaseController {
    private String prefix = "system/interview";

    @Autowired
    private ILnInterviewService lnInterviewService;

    @RequiresPermissions("system:interview:view")
    @GetMapping()
    public String interview() {
        return prefix + "/interview";
    }

    /**
     * 查询面试记录列表
     */
    @RequiresPermissions("system:interview:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LnInterview lnInterview) {
        startPage();
        List<LnInterview> list = lnInterviewService.selectLnInterviewList(lnInterview);
        return getDataTable(list);
    }

    /**
     * 导出面试记录列表
     */
    @RequiresPermissions("system:interview:export")
    @Log(title = "面试记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LnInterview lnInterview) {
        List<LnInterview> list = lnInterviewService.selectLnInterviewList(lnInterview);
        ExcelUtil<LnInterview> util = new ExcelUtil<LnInterview>(LnInterview.class);
        return util.exportExcel(list, "interview");
    }

    /**
     * 新增面试记录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存面试记录
     */
    @RequiresPermissions("system:interview:add")
    @Log(title = "面试记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LnInterview lnInterview) {
        return toAjax(lnInterviewService.insertLnInterview(lnInterview));
    }

    /**
     * 修改面试记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        LnInterview lnInterview = lnInterviewService.selectLnInterviewById(id);
        mmap.put("lnInterview", lnInterview);
        return prefix + "/edit";
    }

    /**
     * 修改保存面试记录
     */
    @RequiresPermissions("system:interview:edit")
    @Log(title = "面试记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LnInterview lnInterview) {
        return toAjax(lnInterviewService.updateLnInterview(lnInterview));
    }

    /**
     * 删除面试记录
     */
    @RequiresPermissions("system:interview:remove")
    @Log(title = "面试记录", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(lnInterviewService.deleteLnInterviewByIds(ids));
    }
}
