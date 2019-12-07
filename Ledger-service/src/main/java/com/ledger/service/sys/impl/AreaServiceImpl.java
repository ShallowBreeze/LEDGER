package com.ledger.service.sys.impl;

import com.ledger.entity.Area;
import com.ledger.dao.AreaDao;
import com.ledger.service.sys.AreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统区域表t_sys_area   全国的区域信息 服务实现类
 * </p>
 *
 * @author pz
 * @since 2019-12-07
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaDao, Area> implements AreaService {

}
