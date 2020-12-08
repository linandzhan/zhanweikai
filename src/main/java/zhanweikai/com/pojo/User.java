package zhanweikai.com.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class User {
    public static final String LEVEL_MIDDLE ="middle";
    public static final String LEVEL_LOW ="low";
    public static final String LEVEL_HIGH ="high";


    private Long userId;

    private String password;

    private String level;

    private String status;

    private String phone;

    private LocalDate creatTime;

    private String userName;

    private Double balance;

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
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(LocalDate creatTime) {
        this.creatTime = creatTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}