package com.ledger.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统字典表t_sys_dict
 * </p>
 *
 * @author pz
 * @since 2019-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder(toBuilder = true)
@TableName("t_sys_dict")
@ApiModel(value="Dict对象", description="系统字典表t_sys_dict")
public class Dict extends Model<Dict> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dict_id", type = IdType.AUTO)
    private Long dictId;

    @ApiModelProperty(value = "字典名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "描述")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "创建人")
    @TableField("create_name")
    private String createName;

    @ApiModelProperty(value = "更新人")
    @TableField("update_name")
    private String updateName;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除，0-正常，1-删除")
    @TableField("is_delete")
    private String isDelete;


    @Override
    protected Serializable pkVal() {
        return this.dictId;
    }

}
