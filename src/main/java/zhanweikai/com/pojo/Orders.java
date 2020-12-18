package zhanweikai.com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 会员或非会员包场订单
 */
@Data
@ToString
public class Orders {

    /**
     * 会员订单
     */
    public static final String TYPE_ORDER_MEMBER = "member";

    /**
     * 非会员订单
     */
    public static final String TYPE_ORDER_NON_MEMBER = "non-member";

    private Long orderId;


    private String type;
    /**
     * 订单创建时间
     */

    private LocalDateTime createTime;

    /**
     * 包场开始时间(几月加号打球）
     */

    private LocalDate playDay;

    /**
     * 所属哪个时间段的场次
     */
    private Period periodId;

//    /**
//     * 包场结束时间
//     */
//
//    private LocalDateTime endChartered;
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


//    private Customer customer;

    /**
     * 所属场地
     */
    private Area areaId;

    /**
     * 哪个员工创建的订单
     */
    private Employee employeeId;
    /**
     * 客户
     */
    private User userId;

    /**
     * 预约人电话
     */
    private String phone;


}
