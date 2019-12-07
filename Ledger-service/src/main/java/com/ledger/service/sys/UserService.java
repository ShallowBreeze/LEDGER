package com.ledger.service.sys;

import com.ledger.entity.User;
import com.ledger.common.core.service.IBaseService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author pz
 * @since 2019-12-07
 */
public interface UserService extends IBaseService<User> {

    User getByLoginName(String loginName);
}
