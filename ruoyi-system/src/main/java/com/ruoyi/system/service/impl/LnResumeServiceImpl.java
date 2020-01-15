package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.LnResume;
import com.ruoyi.system.domain.SysResumePost;
import com.ruoyi.system.mapper.LnResumeMapper;
import com.ruoyi.system.mapper.SysResumePostMapper;
import com.ruoyi.system.service.ILnResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 个人简历Service业务层处理
 *
 * @author mi
 * @date 2020-01-13
 */
@Service
public class LnResumeServiceImpl implements ILnResumeService {
    @Autowired
    private LnResumeMapper lnResumeMapper;
    @Autowired
    private SysResumePostMapper sysResumePostMapper;

    /**
     * 查询个人简历
     *
     * @param id 个人简历ID
     * @return 个人简历
     */
    @Override
    public LnResume selectLnResumeById(Integer id)
    {
        return lnResumeMapper.selectLnResumeById(id);
    }

    /**
     * 查询个人简历列表
     *
     * @param lnResume 个人简历
     * @return 个人简历
     */
    @Override
    public List<LnResume> selectLnResumeList(LnResume lnResume)
    {
        return lnResumeMapper.selectLnResumeList(lnResume);
    }

    /**
     * 新增个人简历
     *
     * @param lnResume 个人简历
     * @return 结果
     */
    @Override
    @Transactional
    public int insertLnResume(LnResume lnResume)
    {
        lnResume.setCreateTime(DateUtils.getNowDate());
        int i= lnResumeMapper.insertLnResume(lnResume);
        // 新增简历企业关联
        insertResumePost(lnResume);
        return i;
    }

    /**
     * 修改个人简历
     *
     * @param lnResume 个人简历
     * @return 结果
     */
    @Override
    @Transactional
    public int updateLnResume(LnResume lnResume)
    {
        //删除
       sysResumePostMapper.deleteSysResumePostById(lnResume.getId());
        // 新增简历企业关联
        insertResumePost(lnResume);
        return lnResumeMapper.updateLnResume(lnResume);
    }
    @Override
    public int eitOnboarding(LnResume lnResume){
        return lnResumeMapper.updateLnResume(lnResume);
    }

    /**
     * 删除个人简历对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLnResumeByIds(String ids)
    {
        return lnResumeMapper.deleteLnResumeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除个人简历信息
     *
     * @param id 个人简历ID
     * @return 结果
     */
    @Override
    public int deleteLnResumeById(Integer id)
    {
        return lnResumeMapper.deleteLnResumeById(id);
    }


    /**
     * 新增简历企业信息
     *
     * @param lnResume 简历对象
     */
    public void insertResumePost(LnResume lnResume){
        Long[] posts = lnResume.getPostIds();
        if (StringUtils.isNotNull(posts)) {
            //新增
            List<SysResumePost> list = new ArrayList<SysResumePost>();
            for (Long postId : posts) {
                SysResumePost up = new SysResumePost();
                up.setResumeId((long)lnResume.getId());
                up.setCompanyId(postId);
                list.add(up);
            }
            if (list.size() > 0)
            {
                sysResumePostMapper.batchResumePost(list);
            }
        }
    }

    /**
     * 删除职位前判断是否有求职该职位
     *
     * @param positionId 职位ID
     * @return 结果
     */
    @Override
    public int selectResumeResult(String positionId) {
        return lnResumeMapper.selectResumeResult(positionId);
    }
}
