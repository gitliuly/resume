package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.LnPosition;
import com.ruoyi.system.domain.LnResume;
import com.ruoyi.system.service.ILnPositionService;
import com.ruoyi.system.service.ILnResumeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 个人简历Controller
 *
 * @author mi
 * @date 2020-01-13
 */
@Controller
@RequestMapping("/system/resume")
public class LnResumeController extends BaseController {
    private String prefix = "system/resume";

    @Autowired
    private ILnResumeService lnResumeService;
    @Autowired
    private ILnPositionService lnPositionService;
    @RequiresPermissions("system:resume:view")
    @GetMapping()
    public String resume()
    {
        return prefix + "/resume";
    }

    /**
     * 查询个人简历列表
     */
    @RequiresPermissions("system:resume:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LnResume lnResume)
    {
        startPage();
        List<LnResume> list = lnResumeService.selectLnResumeList(lnResume);
        return getDataTable(list);
    }

    /**
     * 导出个人简历列表
     */
    @RequiresPermissions("system:resume:export")
    @Log(title = "个人简历", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LnResume lnResume)
    {
        List<LnResume> list = lnResumeService.selectLnResumeList(lnResume);
        ExcelUtil<LnResume> util = new ExcelUtil<LnResume>(LnResume.class);
        return util.exportExcel(list, "resume");
    }

    /**
     * 新增个人简历
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存个人简历
     */
    @RequiresPermissions("system:resume:add")
    @Log(title = "个人简历", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LnResume lnResume)
    {
        return toAjax(lnResumeService.insertLnResume(lnResume));
    }

    /**
     * 修改个人简历
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        LnResume lnResume = lnResumeService.selectLnResumeById(id);
        LnPosition lnPosition =new LnPosition();
        lnPosition.setIndustryId(lnResume.getIndustryId());
        mmap.put("position",  lnPositionService.selectLnPositionList(lnPosition));
        mmap.put("lnResume", lnResume);
        return prefix + "/edit";
    }

    /**
     * 修改保存个人简历
     */
    @RequiresPermissions("system:resume:edit")
    @Log(title = "个人简历", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LnResume lnResume)
    {
        return toAjax(lnResumeService.updateLnResume(lnResume));
    }

    /**
     * 删除个人简历
     */
    @RequiresPermissions("system:resume:remove")
    @Log(title = "个人简历", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lnResumeService.deleteLnResumeByIds(ids));
    }
}
