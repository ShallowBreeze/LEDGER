package com.ledger.common.core.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ledger.common.core.entity.DataTable;

/**
 *
 * @author chen
 * @date 2017/9/21
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
public interface IBaseService<T> extends IService<T> {

    /**
     * DateTable 分页查询
     *
     * @param dt
     * @return
     */
    DataTable<T> pageSearch(DataTable<T> dt);
}
