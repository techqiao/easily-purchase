package com.epc.platform.service.service.admin.impl;

import com.epc.administration.facade.admin.handle.ResourceHandle;
import com.epc.common.constants.Const;
import com.epc.common.util.Tree;
import com.epc.common.util.TreeUtils;
import com.epc.platform.service.domain.admin.SysAdminResource;
import com.epc.platform.service.domain.admin.SysAdminResourceCriteria;
import com.epc.platform.service.domain.admin.SysAdminRoleResourceCriteria;
import com.epc.platform.service.mapper.admin.SysAdminResourceMapper;
import com.epc.platform.service.mapper.admin.SysAdminRoleResourceMapper;
import com.epc.platform.service.service.admin.SysAdminResourceService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-12 20:41
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysAdminResourceServiceImpl implements SysAdminResourceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysAdminResourceServiceImpl.class);

    @Autowired
    private SysAdminResourceMapper sysAdminResourceMapper;
    @Autowired
    private SysAdminRoleResourceMapper sysAdminRoleResourceMapper;
    @Autowired
    private WebApplicationContext applicationContext;


    @Override
    public List<SysAdminResource> findUserPermissions(String userName) {
        return this.sysAdminResourceMapper.findUserPermissions(userName);
    }

    @Override
    public List<SysAdminResource> findResource(String phone) {
        return sysAdminResourceMapper.findResource(phone);
    }

    @Override
    public SysAdminResource findById(Long resourceId) {
        return sysAdminResourceMapper.selectByPrimaryKey(resourceId);
    }

    @Override
    public Tree<SysAdminResource> getResourceButtonTree() {
        List<Tree<SysAdminResource>> trees = new ArrayList<>();
        List<SysAdminResource> treeResource = sysAdminResourceMapper.selectByExample(new SysAdminResourceCriteria());
        buildTrees(trees,treeResource);
        return TreeUtils.build(trees);
    }

    @Override
    public Tree<SysAdminResource> getResourceTree() {
        List<Tree<SysAdminResource>> trees = new ArrayList<>();
        final SysAdminResourceCriteria criteria = new SysAdminResourceCriteria();
        final SysAdminResourceCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andTypeEqualTo("page");
        criteria.setOrderByClause("id");
        List<SysAdminResource> sysAdminResourceList = sysAdminResourceMapper.selectByExample(criteria);
        buildTrees(trees, sysAdminResourceList);
        return TreeUtils.build(trees);
    }

    @Override
    public List<SysAdminResource> findAllResources(ResourceHandle resourceHandle) {
        SysAdminResource sysAdminResource = new SysAdminResource();
        sysAdminResource.setName(resourceHandle.getName());
        sysAdminResource.setType(resourceHandle.getType());
        try {
            final SysAdminResourceCriteria criteria = new SysAdminResourceCriteria();
            final SysAdminResourceCriteria.Criteria subCriteria = criteria.createCriteria();
            if(StringUtils.isNotBlank(sysAdminResource.getName())) {
                subCriteria.andNameEqualTo(sysAdminResource.getName());
            }
            if(StringUtils.isNotBlank(sysAdminResource.getType())) {
                subCriteria.andTypeEqualTo(sysAdminResource.getType());
            }
            criteria.setOrderByClause("id desc");

            return this.sysAdminResourceMapper.selectByExample(criteria);
        } catch (NumberFormatException e) {
            LOGGER.error("error", e);
            return new ArrayList<>();
        }
    }

    @Override
    public SysAdminResource findByNameAndType(String resourceName, String type) {
        final SysAdminResourceCriteria criteria = new SysAdminResourceCriteria();
        final SysAdminResourceCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andNameEqualTo(resourceName).andTypeEqualTo(type);
        List<SysAdminResource> sysAdminResourceList = sysAdminResourceMapper.selectByExample(criteria);
        return sysAdminResourceList.isEmpty() ? null : sysAdminResourceList.get(0);
    }

    /**
     * 新增資源
     * @param resourceHandle
     */
    @Override
    public void addResource(ResourceHandle resourceHandle) {
        SysAdminResource sysAdminResource = new SysAdminResource();
        sysAdminResource.setParentId(resourceHandle.getParentId());
        sysAdminResource.setUrl(resourceHandle.getUrl());
        sysAdminResource.setTitle(resourceHandle.getTitle());
        sysAdminResource.setName(resourceHandle.getName());
        sysAdminResource.setType(resourceHandle.getType());
        sysAdminResource.setCreateAt(new Date());
        sysAdminResource.setUpdateAt(new Date());
        if (sysAdminResource.getParentId() == null) {
            sysAdminResource.setParentId(0L);
        }
        if (Const.RESOURCE_TYPE.ACTION.equals(sysAdminResource.getType())) {
            sysAdminResource.setUrl(null);
        }
        this.sysAdminResourceMapper.insertSelective(sysAdminResource);
    }

    @Override
    public void deleteResources(String resourcesIds) {
        List<String> list = Arrays.asList(resourcesIds.split(","));
        List<Long> longList = list.stream().map(Long::parseLong).collect(Collectors.toList());
        //删除资源
        this.batchDeleteResource(longList);
        //删除资源所关联角色
        this.batchDeleteRoleResource(longList);
        this.sysAdminResourceMapper.changeToTop(longList);

    }

    @Override
    public void updateResource(ResourceHandle resourceHandle) {
        SysAdminResource sysAdminResource = new SysAdminResource();

        sysAdminResource.setUpdateAt(new Date());
        if(sysAdminResource.getParentId() == null) {
            sysAdminResource.setParentId(0L);
        }
        if(Const.RESOURCE_TYPE.PAGE.equals(resourceHandle.getType())) {
            sysAdminResource.setUrl(null);
        }
        sysAdminResourceMapper.updateByPrimaryKeySelective(sysAdminResource);
    }

    @Override
    public Map<Object, Object> getAllUrl(String p1) {
        List<SysAdminResource> sysAdminResources = sysAdminResourceMapper.selectUrl();
        Map<Object, Object> resultMap = new HashMap<>();
        for (int i = 0; i < sysAdminResources.size(); i++) {
            resultMap.put(sysAdminResources.get(i).getName(),sysAdminResources.get(i).getUrl());
        }
        return resultMap;
    }

    public int batchDeleteResource(List<Long> list) {
        final SysAdminResourceCriteria criteria = new SysAdminResourceCriteria();
        criteria.createCriteria().andIdIn(list);
        return this.sysAdminResourceMapper.deleteByExample(criteria);
    }

    public int batchDeleteRoleResource(List<Long> list) {
        final SysAdminRoleResourceCriteria criteria = new SysAdminRoleResourceCriteria();
        criteria.createCriteria().andIdIn(list);
        return this.sysAdminRoleResourceMapper.deleteByExample(criteria);
    }


    /**
     *
     * @param trees
     * @param sysAdminResourceList
     */
    private void buildTrees(List<Tree<SysAdminResource>> trees, List<SysAdminResource> sysAdminResourceList) {
        sysAdminResourceList.forEach(resource -> {
            Tree<SysAdminResource> tree = new Tree<>();
            tree.setId(resource.getId().toString());
            tree.setParentId(resource.getParentId().toString());
            tree.setText(resource.getName());
            trees.add(tree);
        });
    }



}
