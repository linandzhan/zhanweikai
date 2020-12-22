package zhanweikai.com.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class OrdersSearchDTO {
    private Long orderId;

    private String phone;

    private String employeeName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createTime;

    private String periodTime;

    private LocalDate playDay;

    private String areaName;
}
