package com.ledger.service.sys.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ledger.entity.User;
import com.ledger.dao.UserDao;
import com.ledger.service.sys.UserService;
import com.ledger.common.core.service.impl.BaseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author pz
 * @since 2019-12-07
 */
@Service
public class UserServiceImpl extends BaseService<UserDao, User> implements UserService {

    @Override
    public User getByLoginName(String loginName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getLoginName, loginName);
        return getOne(queryWrapper);
    }
}
