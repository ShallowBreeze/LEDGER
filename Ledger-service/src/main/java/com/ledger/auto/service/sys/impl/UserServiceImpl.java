package com.ledger.auto.sys.service.impl;

import com.ledger.auto.sys.entity.User;
import com.ledger.auto.sys.mapper.UserMapper;
import com.ledger.auto.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author pz
 * @since 2019-12-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
