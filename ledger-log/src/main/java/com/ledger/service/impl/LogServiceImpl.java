package com.ledger.service.impl;

import com.ledger.entity.Log;
import com.ledger.dao.LogDao;
import com.ledger.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志记录表 服务实现类
 * </p>
 *
 * @author pz
 * @since 2019-12-05
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogDao, Log> implements LogService {

}
