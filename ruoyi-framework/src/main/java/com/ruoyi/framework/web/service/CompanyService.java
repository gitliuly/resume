package com.ruoyi.framework.web.service;

import com.ruoyi.system.domain.LnIndustry;
import com.ruoyi.system.domain.LnPosition;
import com.ruoyi.system.service.ILnIndustryService;
import com.ruoyi.system.service.ILnPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * html调用 thymeleaf 实现字典读取
 *
 * @author mi
 */
@Service("company")
public class CompanyService {
    @Autowired
    private ILnIndustryService lnIndustryService;
    @Autowired
    private ILnPositionService lnPositionService;
    //取出所有行业
    public List<LnIndustry> getLnIndustry(){
        LnIndustry lnIndustry=new LnIndustry();
        List<LnIndustry> list = lnIndustryService.selectLnIndustryList(lnIndustry);
        return list;
    }
    //取出行业下的职业
    public List<LnPosition> getLnPosition(long IndustryId){
        LnPosition lnPosition =new LnPosition();
        lnPosition.setIndustryId(IndustryId);
        List<LnPosition> list =lnPositionService.selectLnPositionList(lnPosition);
        return list;
    }


}
