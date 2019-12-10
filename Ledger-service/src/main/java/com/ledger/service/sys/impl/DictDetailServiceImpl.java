package com.ledger.service.sys.impl;

import com.ledger.entity.DictDetail;
import com.ledger.dao.DictDetailDao;
import com.ledger.service.sys.DictDetailService;
import com.ledger.common.core.service.impl.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 系统字典明细表t_sys_dict_detail 服务实现类
 * </p>
 *
 * @author pz
 * @since 2019-12-07
 */
@Slf4j
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DictDetailServiceImpl extends BaseService<DictDetailDao, DictDetail> implements DictDetailService {

}
