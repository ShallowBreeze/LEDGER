package com.ledger.entity;

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
 * 系统日志记录表
 * </p>
 *
 * @author pz
 * @since 2019-12-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_sys_log")
public class Log extends Model<Log> {

    private static final long serialVersionUID = 1L;

    /**
     * 日志id
     */
    @TableId(value = "log_id", type = IdType.AUTO)
    private Long logId;

    /**
     * 备注信息
     */
    @TableField("remark")
    private String remark;

    /**
     * 日志来源类型
     */
    @TableField("type")
    private String type;

    /**
     * 模块名称
     */
    @TableField("tag")
    private String tag;

    /**
     * 全类名或者操作url
     */
    @TableField("src")
    private String src;

    /**
     * ip
     */
    @TableField("ip")
    private String ip;

    /**
     * 信息
     */
    @TableField("msg")
    private String msg;

    /**
     * 请求参数
     */
    @TableField("params")
    private String params;

    /**
     * 用户登录名
     */
    @TableField("login_name")
    private String loginName;

    /**
     * 用户名称
     */
    @TableField("name")
    private String name;

    /**
     * 使用时长 毫米单位
     */
    @TableField("use_time")
    private Long useTime;

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
        return this.logId;
    }

}
