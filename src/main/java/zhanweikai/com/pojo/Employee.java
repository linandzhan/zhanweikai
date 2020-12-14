package zhanweikai.com.pojo;

import lombok.ToString;

@ToString
public class Employee {
    private Long id;

    private String username;

    private String password;

    private String phone;

    private String type;

    private String role;

    private String image;

    public Employee(Long id, String username, String password, String phone, String type, String role, String image) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.type = type;
        this.role = role;
        this.image = image;
    }

    public Employee() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}