package com.epc.user.service.common;


import java.util.List;

public class Role  {

    // 角色ID
    private int roleId;
    // 角色名
    private String roleName;
    // 说明
    private String comments;
    //公司Id
    private Integer companyId;

    // 该角色所拥有的权限
    //private List<Function> functionList;

    private List<Integer> functionIdList;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

//    public List<Function> getFunctionList() {
//        return functionList;
//    }
//
//    public void setFunctionList(List<Function> functionList) {
//        this.functionList = functionList;
//    }

    public List<Integer> getFunctionIdList() {
        return functionIdList;
    }

    public void setFunctionIdList(List<Integer> functionIdList) {
        this.functionIdList = functionIdList;
    }

}
