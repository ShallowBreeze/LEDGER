package pom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableConfigServer
@Configuration
public class LedgerConfigServerApplication extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(LedgerConfigServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LedgerConfigServerApplication.class, args);
        logger.info("配置中心启动成功！");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(LedgerConfigServerApplication.class);
    }
}
