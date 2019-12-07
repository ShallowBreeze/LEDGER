package com.ledger.service.sys.impl;

import com.ledger.entity.Config;
import com.ledger.dao.ConfigDao;
import com.ledger.service.sys.ConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置参数t_sys_config 服务实现类
 * </p>
 *
 * @author pz
 * @since 2019-12-07
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigDao, Config> implements ConfigService {

}
