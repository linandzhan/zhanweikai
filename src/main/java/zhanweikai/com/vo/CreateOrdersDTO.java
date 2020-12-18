package zhanweikai.com.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateOrdersDTO {
    private Long areaId;

    private String phone;

    private String type;

    private LocalDate playDay;

    private Long periodId;
}
