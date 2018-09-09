package com.epc.common.user;

/**
 * <p>Description : test
 * <p>Date : 2018/9/9/009 17:18
 * <p>@author : wjq
 */
public class User {
    private Integer id;
    private String name;
    private Integer role;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getRole() {
        return role;
    }

    public User setRole(Integer role) {
        this.role = role;
        return this;
    }
}
