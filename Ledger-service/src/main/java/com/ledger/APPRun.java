package com.ledger;

import com.ledger.common.utils.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description:
 * @author: pengzhen@cmhit.com
 * @create: 2019-12-09 14:31
 **/
@EnableAsync
@SpringBootApplication(exclude={org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@EnableTransactionManagement
public class APPRun {
    private static final Logger logger = LoggerFactory.getLogger(APPRun.class);
    public static void main(String[] args) {
        SpringApplication.run(APPRun.class);
        logger.info("服务启动成功！");
    }
    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }
}
