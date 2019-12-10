package com.ledger.service.sys.impl;

import com.ledger.entity.Area;
import com.ledger.dao.AreaDao;
import com.ledger.service.sys.AreaService;
import com.ledger.common.core.service.impl.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 系统区域表t_sys_area   全国的区域信息 服务实现类
 * </p>
 *
 * @author pz
 * @since 2019-12-07
 */
@Slf4j
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class AreaServiceImpl extends BaseService<AreaDao, Area> implements AreaService {

}
