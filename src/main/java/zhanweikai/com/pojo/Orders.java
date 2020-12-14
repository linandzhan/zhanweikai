package zhanweikai.com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;



public class Orders {

    private Long orderId;

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


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getStartChartered() {
        return startChartered;
    }

    public void setStartChartered(LocalDateTime startChartered) {
        this.startChartered = startChartered;
    }

    public LocalDateTime getEndChartered() {
        return endChartered;
    }

    public void setEndChartered(LocalDateTime endChartered) {
        this.endChartered = endChartered;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getAreaAmont() {
        return areaAmont;
    }

    public void setAreaAmont(Double areaAmont) {
        this.areaAmont = areaAmont;
    }

    public Area getAreaId() {
        return areaId;
    }

    public void setAreaId(Area areaId) {
        this.areaId = areaId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", createTime=" + createTime +
                ", startChartered=" + startChartered +
                ", endChartered=" + endChartered +
                ", paymentAmount=" + paymentAmount +
                ", discountAmount=" + discountAmount +
                ", areaAmont=" + areaAmont +
                ", areaId=" + areaId +
                ", employeeId=" + employeeId +
                ", userId=" + userId +
                '}';
    }
}
