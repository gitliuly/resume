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
import com.ruoyi.system.domain.LnPosition;
import com.ruoyi.system.service.ILnPositionService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 职位Controller
 *
 * @author guzf
 * @date 2020-01-13
 */
@Controller
@RequestMapping("/system/position")
public class LnPositionController extends BaseController {
    private String prefix = "system/position";

    @Autowired
    private ILnPositionService lnPositionService;

    @RequiresPermissions("system:position:view")
    @GetMapping()
    public String position() {
        return prefix + "/position";
    }

    /**
     * 查询职位列表
     */
    @RequiresPermissions("system:position:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LnPosition lnPosition) {
        startPage();
        List<LnPosition> list = lnPositionService.selectLnPositionList(lnPosition);
        return getDataTable(list);
    }

    /**
     * 导出职位列表
     */
    @RequiresPermissions("system:position:export")
    @Log(title = "职位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LnPosition lnPosition) {
        List<LnPosition> list = lnPositionService.selectLnPositionList(lnPosition);
        ExcelUtil<LnPosition> util = new ExcelUtil<LnPosition>(LnPosition.class);
        return util.exportExcel(list, "position");
    }

    /**
     * 新增职位
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存职位
     */
    @RequiresPermissions("system:position:add")
    @Log(title = "职位", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LnPosition lnPosition) {
        return toAjax(lnPositionService.insertLnPosition(lnPosition));
    }

    /**
     * 修改职位
     */
    @GetMapping("/edit/{positionId}")
    public String edit(@PathVariable("positionId") Integer positionId, ModelMap mmap) {
        LnPosition lnPosition = lnPositionService.selectLnPositionById(positionId);
        mmap.put("lnPosition", lnPosition);
        return prefix + "/edit";
    }

    /**
     * 修改保存职位
     */
    @RequiresPermissions("system:position:edit")
    @Log(title = "职位", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LnPosition lnPosition) {
        return toAjax(lnPositionService.updateLnPosition(lnPosition));
    }

    /**
     * 删除职位
     */
    @RequiresPermissions("system:position:remove")
    @Log(title = "职位", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(lnPositionService.deleteLnPositionByIds(ids));
    }
}
