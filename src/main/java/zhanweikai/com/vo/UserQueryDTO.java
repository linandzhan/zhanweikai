package zhanweikai.com.vo;

import lombok.Data;

@Data
public class UserQueryDTO {
    private int page;
    private int size;
    private String sort;
    private String phone;
    private String userName;
}
