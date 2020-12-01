package zhanweikai.com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * 客户会员
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer{
    /**
     * 普通会员
     */
    public static final String TYPE_ORDINARY_CUSTOMER = "OrdinaryCustomer";
    /**
     * 黄金会员  充200即变为黄金会员，以后可享受8折价
     */
    public static final String TYPE_GOLD_CUSTOMER = "GoldCustomer";
    /**
     * 钻石会员  充500即变为钻石会员，以后可享受7折价
     */
    public static final String TYPE_DIAMOND_CUSTOMER = "DiamondCustomer";


    /**
     * 客户id
     */

    private Long customerId;


    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 客户电话
     */
    private String phone;


    /**
     *客户类型 （非会员， 黄金会员，钻石会员）
     */
    private String type;




}
