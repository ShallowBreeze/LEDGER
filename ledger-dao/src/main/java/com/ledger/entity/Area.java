package com.ledger.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * 系统区域表t_sys_area   全国的区域信息
 * </p>
 *
 * @author pz
 * @since 2019-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder(toBuilder = true)
@TableName("t_sys_area")
@ApiModel(value="Area对象", description="系统区域表t_sys_area   全国的区域信息")
public class Area extends Model<Area> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "区域id")
    @TableId("area_id")
    private String areaId;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "dkey")
    @TableField("jkey")
    private String jkey;


    @Override
    protected Serializable pkVal() {
        return this.areaId;
    }

}
