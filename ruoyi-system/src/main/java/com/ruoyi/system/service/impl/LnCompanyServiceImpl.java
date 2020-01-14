package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.LnCompany;
import com.ruoyi.system.domain.LnIndustry;
import com.ruoyi.system.mapper.LnCompanyMapper;
import com.ruoyi.system.mapper.LnIndustryMapper;
import com.ruoyi.system.service.ILnCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公司Service业务层处理
 *
 * @author mi
 * @date 2020-01-13
 */
@Service
public class LnCompanyServiceImpl  implements ILnCompanyService {
    @Autowired
    private LnCompanyMapper lnCompanyMapper;
    @Autowired
    private LnIndustryMapper lnIndustryMapper;

    /**
     * 查询公司
     *
     * @param companyId 公司ID
     * @return 公司
     */
    @Override
    public LnCompany selectLnCompanyById(Integer companyId)
    {
        return lnCompanyMapper.selectLnCompanyById(companyId);
    }

    /**
     * 查询公司列表
     *
     * @param lnCompany 公司
     * @return 公司
     */
    @Override
    public List<LnCompany> selectLnCompanyList(LnCompany lnCompany)
    {
        List<LnCompany> LnCompanyList=lnCompanyMapper.selectLnCompanyList(lnCompany);
        for (LnCompany list:LnCompanyList){
            //取出行业
            LnIndustry lnIndustry=lnIndustryMapper.selectLnIndustryById(list.getIndustryId());
            list.setIndustryName(lnIndustry.getIndustryName());
        }
        return LnCompanyList;
    }

    /**
     * 新增公司
     *
     * @param lnCompany 公司
     * @return 结果
     */
    @Override
    public int insertLnCompany(LnCompany lnCompany)
    {
        lnCompany.setCreateTime(DateUtils.getNowDate());
        return lnCompanyMapper.insertLnCompany(lnCompany);
    }

    /**
     * 修改公司
     *
     * @param lnCompany 公司
     * @return 结果
     */
    @Override
    public int updateLnCompany(LnCompany lnCompany)
    {
        return lnCompanyMapper.updateLnCompany(lnCompany);
    }

    /**
     * 删除公司对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLnCompanyByIds(String ids)
    {
        return lnCompanyMapper.deleteLnCompanyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公司信息
     *
     * @param companyId 公司ID
     * @return 结果
     */
    @Override
    public int deleteLnCompanyById(Integer companyId)
    {
        return lnCompanyMapper.deleteLnCompanyById(companyId);
    }
}
