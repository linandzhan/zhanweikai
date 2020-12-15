package zhanweikai.com.pojo;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@ToString
public class Period {


    /**
     * 时间段id
     */
    private Long periodId;
    /**
     * 时间段名
     */
    private String period_time;

    /**
     * 开始时间
     */
    private LocalTime startTime;

    /**
     * 结束时间
     */
    private LocalTime endTime;

}
