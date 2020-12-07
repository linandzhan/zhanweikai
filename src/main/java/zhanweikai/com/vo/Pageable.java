package zhanweikai.com.vo;

import lombok.Data;

@Data
public class Pageable {
    private int page;
    private int size;
    private String sort;
}
