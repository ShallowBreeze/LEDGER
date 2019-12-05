package com.ledger.auto.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统配置参数t_sys_config
 * </p>
 *
 * @author pz
 * @since 2019-12-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_sys_config")
public class Config extends Model<Config> {

    private static final long serialVersionUID = 1L;

    /**
     * 参数id
     */
    @TableId(value = "config_id", type = IdType.AUTO)
    private Long configId;

    /**
     * 备注信息
     */
    @TableField("remark")
    private String remark;

    /**
     * key
     */
    @TableField("jkey")
    private String jkey;

    /**
     * value
     */
    @TableField("jvalue")
    private String jvalue;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 创建人
     */
    @TableField("create_name")
    private String createName;

    /**
     * 更新人
     */
    @TableField("update_name")
    private String updateName;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 是否删除，0-正常，1-删除
     */
    @TableField("is_delete")
    private String isDelete;


    @Override
    protected Serializable pkVal() {
        return this.configId;
    }

}
