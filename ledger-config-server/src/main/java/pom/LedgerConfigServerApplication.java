package pom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class LedgerConfigServerApplication {
    private static final Logger logger = LoggerFactory.getLogger(LedgerConfigServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LedgerConfigServerApplication.class, args);
        logger.info("配置中心启动成功！");
    }

}
