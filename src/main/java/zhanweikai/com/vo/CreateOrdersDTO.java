package zhanweikai.com.vo;

import lombok.Data;
import zhanweikai.com.pojo.Area;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CreateOrdersDTO {
    private Long orderId;

    private Long areaId;

    private String phone;

    private String level;

    private LocalDate playDay;

    private Long periodId;

    private Long userId;

    private Long employeeId;

    private LocalDateTime createTime;

    private Double paymentAmount;

    private Double areaAmont;

    private Double discountAmount;
}
