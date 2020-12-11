package zhanweikai.com.vo.kuozhan;

import com.google.common.collect.Lists;
import lombok.Data;
import zhanweikai.com.pojo.Permission;

import java.util.List;
@Data
public class PermissionTree extends Permission {
    private Boolean checked = false;
    private List<PermissionTree> children = Lists.newArrayList();
}
