package com.epc.platform.service.service.admin.impl;

import com.epc.administration.facade.admin.handle.DeptHandle;
import com.epc.common.constants.Const;
import com.epc.common.util.Tree;
import com.epc.common.util.TreeUtils;
import com.epc.platform.service.domain.admin.SysAdminDept;
import com.epc.platform.service.domain.admin.SysAdminDeptCriteria;
import com.epc.platform.service.mapper.admin.SysAdminDeptMapper;
import com.epc.platform.service.service.admin.SysAdminDeptService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 19:27
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysAdminDeptServiceImpl implements SysAdminDeptService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysAdminDeptServiceImpl.class);
    @Autowired
    private SysAdminDeptMapper sysAdminDeptMapper;

    @Override
    public Tree<SysAdminDept> getDeptTree() {
        List<Tree<SysAdminDept>> trees = new ArrayList<>();
        List<SysAdminDept> depts = this.findAllDepts(new DeptHandle());
        depts.forEach(dept -> {
            Tree<SysAdminDept> tree = new Tree<>();
            tree.setId(dept.getId().toString());
            tree.setParentId(dept.getParentId().toString());
            tree.setText(dept.getDeptName());
            trees.add(tree);
        });
        return TreeUtils.build(trees);
    }

    @Override
    public List<SysAdminDept> findAllDepts(DeptHandle dept) {
        SysAdminDept sysAdminDept = new SysAdminDept();
        sysAdminDept.setDeptName(dept.getDeptName());
        try {
            final SysAdminDeptCriteria criteria = new SysAdminDeptCriteria();
            final SysAdminDeptCriteria.Criteria subCriteria = criteria.createCriteria();

            if (StringUtils.isNotBlank(sysAdminDept.getDeptName())) {
                subCriteria.andDeptNameEqualTo(dept.getDeptName());
            }
            criteria.setOrderByClause("id");
            return this.sysAdminDeptMapper.selectByExample(criteria);
        } catch (Exception e) {
            LOGGER.error("获取部门列表失败", e);
            return new ArrayList<>();
        }
    }

    @Override
    public SysAdminDept findById(Long deptId) {
        return sysAdminDeptMapper.selectByPrimaryKey(deptId);
    }

    @Override
    public SysAdminDept findByName(String deptName) {
        final SysAdminDeptCriteria criteria = new SysAdminDeptCriteria();
        final SysAdminDeptCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andDeptNameEqualTo(deptName);
        List<SysAdminDept> list = this.sysAdminDeptMapper.selectByExample(criteria);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void addDept(DeptHandle dept) {
        Date date = new Date();
        SysAdminDept sysAdminDept = new SysAdminDept();
        sysAdminDept.setDeptName(dept.getDeptName());
        sysAdminDept.setParentId(dept.getParentId());
        sysAdminDept.setParentId(dept.getParentId());
        sysAdminDept.setUpdateAt(date);
        sysAdminDept.setCreateAt(date);
        sysAdminDept.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        Long parentId = sysAdminDept.getParentId();
        if (parentId == null){
            sysAdminDept.setParentId(0L);}
        this.sysAdminDeptMapper.insertSelective(sysAdminDept);
    }

    @Override
    public void deleteDepts(String deptIds) {
        List<String> list = Arrays.asList(deptIds.split(","));
        List<Long> longList = list.stream().map(Long::parseLong).collect(Collectors.toList());

        this.batchDeleteDepts(longList);
        this.sysAdminDeptMapper.changeToTop(list);
    }

    @Override
    public void updateDept(DeptHandle dept) {
        SysAdminDept sysAdminDept = new SysAdminDept();
        sysAdminDept.setParentId(dept.getParentId());
        sysAdminDept.setDeptName(dept.getDeptName());
        this.sysAdminDeptMapper.updateByPrimaryKeySelective(sysAdminDept);
    }


    public int batchDeleteDepts(List<Long> list) {
        final SysAdminDeptCriteria criteria = new SysAdminDeptCriteria();
        criteria.createCriteria().andIdIn(list);
        return this.sysAdminDeptMapper.deleteByExample(criteria);
    }

}
