

package tomyjan.moeclassroommanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * SpringBoot启动核心
 */
@SpringBootApplication
@EnableConfigurationProperties
@EnableTransactionManagement
@MapperScan("tomyjan.moeclassroommanager.mapper")
public class HomeManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeManageApplication.class, args);
    }

}
