package zhanweikai.com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.beans.Transient;


@ToString
public class Area {
    /**
     * 场地当天处于活动状态 （通过，订单类型可知，是否将该场地的状态改变）
     */
    public static final String STATUS_ACTIVITY ="activity";

    /**
     * 场地当天处于维护状态（工作人员，手动操作，是否处于维护）
     */
    public static final String STATUS_MAINTAIN = "maintain";

    /**
     * 场地类型 标准场
     */
   public static  final String TYPE_STANDARD = "standard";

    /**
     * 场地类型 小场
     */
    public static  final String TYPE_SMALL = "small";

    /**
     * 场地id
     */

    private Long areaId;


    /**
     * 场地号
     */

    private String number;

    /**
     * 租赁价格
     */

    private Double rentalPrice;

    /**
     * 场地状态
     */

    private String status;

    /**
     * 是否空余（是否已经被租了，临时字段,不做永久保存）
     */
    private Boolean isSpare;

    /**
     * 馆内有两个管理员，一个负责一半
     */
    private Employee employeeId;

    private String type;

    private String beiyong2;

    public Area() {
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(Double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBeiyong2() {
        return beiyong2;
    }

    public void setBeiyong2(String beiyong2) {
        this.beiyong2 = beiyong2;
    }

    public Boolean getIsSpare() {
        return isSpare;
    }

    public void setIsSpare(Boolean spare) {
        isSpare = spare;
    }
}
