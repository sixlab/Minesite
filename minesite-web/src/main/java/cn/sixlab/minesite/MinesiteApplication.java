package cn.sixlab.minesite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = {
        "cn.sixlab.minesite",
})
@EntityScan(basePackages = {
        "cn.sixlab.minesite.models",
})
@EnableJpaRepositories(basePackages = {
        "cn.sixlab.minesite.dao",
})
public class MinesiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinesiteApplication.class, args);
    }

}
