package com.ledger.service.sys.impl;

import com.ledger.entity.Config;
import com.ledger.dao.ConfigDao;
import com.ledger.service.sys.ConfigService;
import com.ledger.common.core.service.impl.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 系统配置参数t_sys_config 服务实现类
 * </p>
 *
 * @author pz
 * @since 2019-12-07
 */
@Slf4j
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ConfigServiceImpl extends BaseService<ConfigDao, Config> implements ConfigService {

}
