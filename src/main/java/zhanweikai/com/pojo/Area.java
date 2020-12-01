package zhanweikai.com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area {
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
     * 场地状态。  不存数据表，因为状态会不断变化的
     */

    private Boolean status;



}
