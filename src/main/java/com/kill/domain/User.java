package com.kill.domain;

import java.io.Serializable;

/**
 * 设置表名为user，并且标记该类为实体类 Hibernate
 */
//@Table(name = "syn_user")
//@Entity
public class User implements Serializable {
    /**
     * 设置主键生成策略
     */
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
    public int id;

//    @Column
    private String username;

//    @Column
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
