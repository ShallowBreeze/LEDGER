package com.ledger.auto.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统区域表t_sys_area   全国的区域信息
 * </p>
 *
 * @author pz
 * @since 2019-12-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_sys_area")
public class Area extends Model<Area> {

    private static final long serialVersionUID = 1L;

    /**
     * 区域id
     */
    @TableId("area_id")
    private String areaId;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * dkey
     */
    @TableField("jkey")
    private String jkey;


    @Override
    protected Serializable pkVal() {
        return this.areaId;
    }

}
