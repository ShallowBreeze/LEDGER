package com.ledger.service.sys.impl;

import com.ledger.entity.User;
import com.ledger.dao.UserDao;
import com.ledger.service.sys.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
