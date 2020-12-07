package zhanweikai.com.pojo;

import java.util.Date;

public class User {
    private Long userId;

    private String password;

    private String roles;

    private String status;

    private String phone;

    private Date creatTime;

    private String userName;

    public User(Long userId, String password, String roles, String status, String phone, Date creatTime) {
        this.userId = userId;
        this.password = password;
        this.roles = roles;
        this.status = status;
        this.phone = phone;
        this.creatTime = creatTime;
    }

    public User(Long userId, String password, String roles, String status, String phone, Date creatTime, String userName) {
        this.userId = userId;
        this.password = password;
        this.roles = roles;
        this.status = status;
        this.phone = phone;
        this.creatTime = creatTime;
        this.userName = userName;
    }

    public User() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}