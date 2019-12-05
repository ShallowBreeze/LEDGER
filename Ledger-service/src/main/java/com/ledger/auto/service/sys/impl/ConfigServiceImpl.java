package com.ledger.auto.sys.service.impl;

import com.ledger.auto.sys.entity.Config;
import com.ledger.auto.sys.mapper.ConfigMapper;
import com.ledger.auto.sys.service.ConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置参数t_sys_config 服务实现类
 * </p>
 *
 * @author pz
 * @since 2019-12-05
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {

}
