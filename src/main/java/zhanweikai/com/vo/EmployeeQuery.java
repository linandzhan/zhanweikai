package zhanweikai.com.vo;

import lombok.Data;

@Data
public class EmployeeQuery {
    private int page = 1;
    private int pageSize = 5;

    private Long id;
    private String username;
    private String role;
    private String type;
}
