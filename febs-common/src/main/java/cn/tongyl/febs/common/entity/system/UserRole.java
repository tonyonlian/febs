package cn.tongyl.febs.common.entity.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author create by Tunyl on 2021/9/5
 * @version 1.0
 */
@Data
@TableName("t_user_role")
public class UserRole implements Serializable {
    private static final long serialVersionUID = -31116L;
    @TableField(value = "USER_ID")
    private Long userId;
    @TableField(value = "ROLE_ID")
    private Long roleId;
}
