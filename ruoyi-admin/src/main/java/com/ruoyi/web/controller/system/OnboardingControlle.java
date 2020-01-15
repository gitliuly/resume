package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.LnResume;
import com.ruoyi.system.service.ILnResumeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 入职列表 Controller
 *
 * @author mi
 * @date 2020-01-15
 */
@Controller
@RequestMapping("/system/onboarding")
public class OnboardingControlle extends BaseController {

    private String prefix = "system/resume";
    @Autowired
    private ILnResumeService lnResumeService;
    @RequiresPermissions("system:onboarding:view")
    @GetMapping()
    public String resume()
    {
        return prefix + "/onboarding";
    }
    /**
     * 查询个人简历列表
     */
    @RequiresPermissions("system:onboarding:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LnResume lnResume)
    {
        lnResume.setStatus("1");
        startPage();
        List<LnResume> list = lnResumeService.selectLnResumeList(lnResume);
        return getDataTable(list);
    }
    @RequiresPermissions("system:onboarding:remove")
    @Log(title = "入职人员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lnResumeService.deleteLnResumeByIds(ids));
    }

}
