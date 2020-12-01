package zhanweikai.com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    private Long userId;

    /**
     * 订单创建时间
     */

    private LocalDateTime createTime;

    /**
     * 包场开始时间
     */

    private LocalDateTime startChartered;

    /**
     * 包场结束时间
     */

    private LocalDateTime endChartered;
    /**
     * 支付金额
     */

    private Double paymentAmount;

    /**
     * 优惠金额
     */

    private Double discountAmount;

    /**
     * 场地包场价格
     */

    private Double areaAmont;


    private Customer customer;


    private Area area;


    private Employee employee;
}
