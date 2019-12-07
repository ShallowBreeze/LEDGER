package com.ledger.service.sys.impl;

import com.ledger.entity.Dict;
import com.ledger.dao.DictDao;
import com.ledger.service.sys.DictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统字典表t_sys_dict 服务实现类
 * </p>
 *
 * @author pz
 * @since 2019-12-07
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictDao, Dict> implements DictService {

}
