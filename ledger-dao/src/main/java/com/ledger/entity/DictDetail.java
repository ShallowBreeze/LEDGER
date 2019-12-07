package com.ledger.entity;

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
 * 系统字典明细表t_sys_dict_detail
 * </p>
 *
 * @author pz
 * @since 2019-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder(toBuilder = true)
@TableName("t_sys_dict_detail")
@ApiModel(value="DictDetail对象", description="系统字典明细表t_sys_dict_detail")
public class DictDetail extends Model<DictDetail> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dict_detail_id", type = IdType.AUTO)
    private Long dictDetailId;

    @ApiModelProperty(value = "字典标签")
    @TableField("label")
    private String label;

    @ApiModelProperty(value = "字典值")
    @TableField("value")
    private String value;

    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private String sort;

    @ApiModelProperty(value = "字典id")
    @TableField("dict_id")
    private Long dictId;

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
        return this.dictDetailId;
    }

}
