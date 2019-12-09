package com.ledger.aspect;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import com.ledger.common.utils.IpUtils;
import com.ledger.common.utils.ServletUtils;
import com.ledger.common.utils.ThrowableUtil;
import com.ledger.entity.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.*;

@Aspect
@Component
public class SLogAspect {

    /**
     * 保存日志到数据库的线程池
     */
    ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("SLogAspect-Thread-%d").build();

    ExecutorService executor = new ThreadPoolExecutor(5,200,0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024),
            threadFactory,
            new ThreadPoolExecutor.AbortPolicy());


    /**
     * 配置切入点
     */
    @Pointcut("@annotation(com.ledger.annotation.SLog)")
    public void logPointCut() {
    }

    /**
     * 配置环绕通知,使用在方法logPointcut()上注册的切入点
     *
     * @param point join point for advice
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        // 获取request
        HttpServletRequest request = ServletUtils.getHttpServletRequest();
        //获取请求的ip
        String ip = IpUtils.getIpAddr(request);
        Log log = new Log("INFO");
        SaveLogTask saveLogTask = new SaveLogTask(point, time, ip,log);
        //保存日志到数据库
        executor.execute(saveLogTask);

        return result;
    }

    /**
     * 配置异常通知
     *
     * @param joinPoint join point for advice
     * @param e exception
     */
    @AfterThrowing(pointcut = "logPointCut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        // 获取request
        HttpServletRequest request = ServletUtils.getHttpServletRequest();
        //获取请求的ip
        String ip = IpUtils.getIpAddr(request);
        Log log = new Log("ERROR");
        log.setMsg(ThrowableUtil.getStackTrace(e));
        SaveLogTask saveLogTask = new SaveLogTask((ProceedingJoinPoint) joinPoint, time, ip,log);
        //保存日志到数据库
        executor.execute(saveLogTask);
    }


}
