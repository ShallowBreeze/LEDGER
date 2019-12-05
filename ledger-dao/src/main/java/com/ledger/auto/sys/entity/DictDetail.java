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
 * 系统字典明细表t_sys_dict_detail
 * </p>
 *
 * @author pz
 * @since 2019-12-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_sys_dict_detail")
public class DictDetail extends Model<DictDetail> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dict_detail_id", type = IdType.AUTO)
    private Long dictDetailId;

    /**
     * 字典标签
     */
    @TableField("label")
    private String label;

    /**
     * 字典值
     */
    @TableField("value")
    private String value;

    /**
     * 排序
     */
    @TableField("sort")
    private String sort;

    /**
     * 字典id
     */
    @TableField("dict_id")
    private Long dictId;

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
        return this.dictDetailId;
    }

}
