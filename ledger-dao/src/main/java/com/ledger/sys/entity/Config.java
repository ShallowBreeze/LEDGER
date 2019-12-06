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
 * 系统配置参数t_sys_config
 * </p>
 *
 * @author pz
 * @since 2019-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder(toBuilder = true)
@TableName("t_sys_config")
@ApiModel(value="Config对象", description="系统配置参数t_sys_config")
public class Config extends Model<Config> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参数id")
    @TableId(value = "config_id", type = IdType.AUTO)
    private Long configId;

    @ApiModelProperty(value = "备注信息")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "key")
    @TableField("jkey")
    private String jkey;

    @ApiModelProperty(value = "value")
    @TableField("jvalue")
    private String jvalue;

    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;

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
        return this.configId;
    }

}
