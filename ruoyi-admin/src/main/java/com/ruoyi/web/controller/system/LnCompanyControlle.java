package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.LnCompany;
import com.ruoyi.system.domain.LnPosition;
import com.ruoyi.system.service.ILnCompanyService;
import com.ruoyi.system.service.ILnPositionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公司Controller
 *
 * @author mi
 * @date 2020-01-13
 */
@Controller
@RequestMapping("/system/company")
public class LnCompanyControlle extends BaseController {
    private String prefix = "system/company";
    @Autowired
    private ILnPositionService lnPositionService;
    @Autowired
    private ILnCompanyService lnCompanyService;

    @RequiresPermissions("system:company:view")
    @GetMapping()
    public String company()
    {
        return prefix + "/company";
    }

    /**
     * 查询公司列表
     */
    @RequiresPermissions("system:company:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LnCompany lnCompany)
    {
        startPage();
        List<LnCompany> list = lnCompanyService.selectLnCompanyList(lnCompany);
        return getDataTable(list);
    }

    /**
     * 导出公司列表
     */
    @RequiresPermissions("system:company:export")
    @Log(title = "公司", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LnCompany lnCompany)
    {
        List<LnCompany> list = lnCompanyService.selectLnCompanyList(lnCompany);
        ExcelUtil<LnCompany> util = new ExcelUtil<LnCompany>(LnCompany.class);
        return util.exportExcel(list, "company");
    }

    /**
     * 新增公司
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公司
     */
    @RequiresPermissions("system:company:add")
    @Log(title = "公司", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LnCompany lnCompany)
    {
        return toAjax(lnCompanyService.insertLnCompany(lnCompany));
    }

    /**
     * 修改公司
     */
    @GetMapping("/edit/{companyId}")
    public String edit(@PathVariable("companyId") Integer companyId, ModelMap mmap)
    {
        LnCompany lnCompany = lnCompanyService.selectLnCompanyById(companyId);
        //获取行业下的所有职位
        LnPosition lnPosition =new LnPosition();
        lnPosition.setIndustryId(lnCompany.getIndustryId());
        mmap.put("position",  lnPositionService.selectLnPositionList(lnPosition));
        mmap.put("lnCompany", lnCompany);
        return prefix + "/edit";
    }

    /**
     * 修改保存公司
     */
    @RequiresPermissions("system:company:edit")
    @Log(title = "公司", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LnCompany lnCompany,String jobsOnOffers)
    {
        System.out.println(jobsOnOffers);
        lnCompany.setJobsOnOffer(jobsOnOffers);
        return toAjax(lnCompanyService.updateLnCompany(lnCompany));
    }

    /**
     * 删除公司
     */
    @RequiresPermissions("system:company:remove")
    @Log(title = "公司", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lnCompanyService.deleteLnCompanyByIds(ids));
    }


    /**
     * ajax 动态获取职业
     */
    @PostMapping("/getlnPosition")
    @ResponseBody
    public AjaxResult getlnPosition(Long industryId) {
        LnPosition lnPosition =new LnPosition();
        lnPosition.setIndustryId(industryId);
        List<LnPosition> LnPositionList = lnPositionService.selectLnPositionList(lnPosition);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("LnPositionList", LnPositionList);
        return ajax;
    }
}
