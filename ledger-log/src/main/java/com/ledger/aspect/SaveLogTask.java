package com.ledger.aspect;

import com.alibaba.fastjson.JSON;

import com.ledger.annotation.SLog;
import com.ledger.common.shiro.ShiroUser;
import com.ledger.common.shiro.SysUser;
import com.ledger.common.utils.SpringContextHolder;
import com.ledger.dao.LogDao;
import com.ledger.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 *
 * @author chen
 * @date 2017/9/19
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
public class SaveLogTask implements Runnable {

    private LogDao logDao = SpringContextHolder.getBean(LogDao.class);

    private ProceedingJoinPoint joinPoint;
    private long time;
    private String ip;

    public SaveLogTask(ProceedingJoinPoint point, long time, String ip) {
        this.joinPoint = point;
        this.time = time;
        this.ip = ip;
    }

    @Override
    public void run() {
        saveLog(joinPoint, time, ip);
    }

/**
* @Description:  保存日志 到数据库
* @Param: [joinPoint, time, ip]
* @return: void
* @Author: pengzhen@cmhit.com
* @Date: 2019/12/5
*/
    private void saveLog(ProceedingJoinPoint joinPoint, long time, String ip) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Log log = new Log();
        SLog sLog =method.getAnnotation(SLog.class);

        if (log != null) {
            // 注解上的描述
            log.setMsg(sLog.value());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.setSrc(className + "." + methodName + "()");

        // 请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            String params = JSON.toJSONString(args[0]);
            log.setParams(params);
        } catch (Exception e) {

        }

        // 设置IP地址
        log.setIp(ip);
        // 用户名
        ShiroUser currUser = SysUser.ShiroUser();

        if (null == currUser) {
            if (null != log.getParams()) {
                log.setName(log.getParams());
                log.setLoginName(log.getParams());
            } else {
                log.setName("获取用户信息为空");
                log.setLoginName("获取用户信息为空");
                log.setCreateName(null);
            }
        } else {
            log.setName(currUser.getName());
            log.setLoginName(currUser.getUsername());

        }

        log.setUseTime(time);


        // 保存系统日志
        log.insert();
    }
}
