package com.epc.platform.service.service.admin.impl;

import com.epc.administration.facade.admin.handle.ResourceHandle;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.Tree;
import com.epc.common.util.TreeUtils;
import com.epc.platform.service.domain.admin.SysAdminResource;
import com.epc.platform.service.domain.admin.SysAdminResourceCriteria;
import com.epc.platform.service.domain.admin.SysAdminRoleResource;
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

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-12 20:41
 * <p>@Author : luozhixin
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysAdminResourceServiceImpl implements SysAdminResourceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysAdminResourceServiceImpl.class);

    @Autowired
    private SysAdminResourceMapper sysAdminResourceMapper;
    @Autowired
    private SysAdminRoleResourceMapper sysAdminRoleResourceMapper;


    /**
     * 查询用户权限
     * @param userName
     * @return
     */
    @Override
    public List<SysAdminResource> findUserPermissions(String userName) {
        return this.sysAdminResourceMapper.findUserPermissions(userName);
    }

    /**
     * 查找对应资源
     * @param phone
     * @return
     */
    @Override
    public List<SysAdminResource> findResource(String phone) {
        return sysAdminResourceMapper.findResource(phone);
    }

    /**
     * 根据id查找资源信息
     * @param resourceId
     * @return
     */
    @Override
    public SysAdminResource findById(Long resourceId) {
        return sysAdminResourceMapper.selectByPrimaryKey(resourceId);
    }

    /**
     * 获取资源按钮树
     * @return
     */
    @Override
    public Tree<SysAdminResource> getResourceButtonTree() {
        List<Tree<SysAdminResource>> trees = new ArrayList<>();
        List<SysAdminResource> treeResource = sysAdminResourceMapper.selectByExample(new SysAdminResourceCriteria());
        buildTrees(trees,treeResource);
        return TreeUtils.build(trees);
    }

    /**
     * 获取资源页面树
     * @return
     */
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

    /**
     * 获取所有资源
     * @param resourceHandle
     * @return
     */
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
            LOGGER.error("findAllResources", e);
            return new ArrayList<>();
        }
    }

    /**
     * 根据name和type查找
     * @param resourceName
     * @param type
     * @return
     */
    @Override
    public Result<Boolean> findByNameAndType(String resourceName, String type) {
        final SysAdminResourceCriteria criteria = new SysAdminResourceCriteria();
        final SysAdminResourceCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andNameEqualTo(resourceName).andTypeEqualTo(type);
        List<SysAdminResource> sysAdminResourceList = sysAdminResourceMapper.selectByExample(criteria);
        return Result.success(sysAdminResourceList.isEmpty() ? true : false);
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
        sysAdminResourceMapper.insertSelective(sysAdminResource);
        SysAdminRoleResource sysAdminRoleResource = new SysAdminRoleResource();
        sysAdminRoleResource.setAmdinRoleId(Long.valueOf(Const.Role.ROLE_ADMIN));
        sysAdminRoleResource.setAdminResourceId(sysAdminResource.getId());
        sysAdminRoleResource.setCreateAt(new Date());
        sysAdminRoleResource.setUpdateAt(new Date());
        sysAdminRoleResource.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        sysAdminRoleResourceMapper.insertSelective(sysAdminRoleResource);
    }

    /**
     * 删除资源 目前只有admin有操作权限
     * @param resourcesIds
     */
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

    /**
     * 修改资源
     * @param resourceHandle
     */
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

    /**
     * 获取所有资源的url
     * @param p1
     * @return
     */
    @Override
    public Map<Object, Object> getAllUrl(String p1) {
        List<SysAdminResource> sysAdminResources = sysAdminResourceMapper.selectUrl();
        Map<Object, Object> resultMap = new HashMap<>();
        for (int i = 0; i < sysAdminResources.size(); i++) {
            resultMap.put(sysAdminResources.get(i).getName(),sysAdminResources.get(i).getUrl());
        }
        return resultMap;
    }

    /**
     * 获取删除掉的资源
     * @param list
     * @return
     */
    public int batchDeleteResource(List<Long> list) {
        final SysAdminResourceCriteria criteria = new SysAdminResourceCriteria();
        criteria.createCriteria().andIdIn(list);
        return this.sysAdminResourceMapper.deleteByExample(criteria);
    }

    /**
     * 校验资源
     * @param list
     * @return
     */
    public int batchDeleteRoleResource(List<Long> list) {
        final SysAdminRoleResourceCriteria criteria = new SysAdminRoleResourceCriteria();
        criteria.createCriteria().andIdIn(list);
        return this.sysAdminRoleResourceMapper.deleteByExample(criteria);
    }


    /**
     * 添加资源
     * @param trees
     * @param sysAdminResourceList
     */
    private void buildTrees(List<Tree<SysAdminResource>> trees, List<SysAdminResource> sysAdminResourceList) {
        sysAdminResourceList.forEach(resource -> {
            Tree<SysAdminResource> tree = new Tree<>();
            tree.setId(resource.getId().toString());
            tree.setParentId(resource.getParentId().toString());
            tree.setText(resource.getName());
            tree.setUrl(resource.getUrl());
            trees.add(tree);
        });
    }



}
