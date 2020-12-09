package zhanweikai.com.vo;

import lombok.Data;

@Data
public class CulculateDTO {
    private Long userId;
    private Double reduceBalance;
    private String discount;
    private Double actualBalance;
}
