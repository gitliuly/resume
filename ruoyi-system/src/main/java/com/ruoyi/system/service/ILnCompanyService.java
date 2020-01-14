package com.ruoyi.system.service;

import com.ruoyi.system.domain.LnCompany;

import java.util.List;
/**
 * 公司Service接口
 *
 * @author mi
 * @date 2020-01-13
 */
public interface ILnCompanyService {
    /**
     * 查询公司
     *
     * @param companyId 公司ID
     * @return 公司
     */
    public LnCompany selectLnCompanyById(Integer companyId);

    /**
     * 查询公司列表
     *
     * @param lnCompany 公司
     * @return 公司集合
     */
    public List<LnCompany> selectLnCompanyList(LnCompany lnCompany);

    /**
     * 新增公司
     *
     * @param lnCompany 公司
     * @return 结果
     */
    public int insertLnCompany(LnCompany lnCompany);

    /**
     * 修改公司
     *
     * @param lnCompany 公司
     * @return 结果
     */
    public int updateLnCompany(LnCompany lnCompany);

    /**
     * 批量删除公司
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLnCompanyByIds(String ids);

    /**
     * 删除公司信息
     *
     * @param companyId 公司ID
     * @return 结果
     */
    public int deleteLnCompanyById(Integer companyId);
}
