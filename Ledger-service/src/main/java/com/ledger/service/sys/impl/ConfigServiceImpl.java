package com.ledger.sys.service.impl;

import com.ledger.sys.entity.Config;
import com.ledger.sys.dao.ConfigDao;
import com.ledger.sys.service.ConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置参数t_sys_config 服务实现类
 * </p>
 *
 * @author pz
 * @since 2019-12-06
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigDao, Config> implements ConfigService {

}
