package com.ledger.service.sys.impl;

import com.ledger.entity.Dict;
import com.ledger.dao.DictDao;
import com.ledger.service.sys.DictService;
import com.ledger.common.core.service.impl.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 系统字典表t_sys_dict 服务实现类
 * </p>
 *
 * @author pz
 * @since 2019-12-07
 */
@Slf4j
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DictServiceImpl extends BaseService<DictDao, Dict> implements DictService {

}
