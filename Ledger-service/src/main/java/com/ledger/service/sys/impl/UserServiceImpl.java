package com.ledger.sys.service.impl;

import com.ledger.sys.entity.User;
import com.ledger.sys.dao.UserDao;
import com.ledger.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author pz
 * @since 2019-12-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
