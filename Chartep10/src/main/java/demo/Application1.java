package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by win7 on 2021/8/10.
 */
@SpringBootApplication
@ComponentScan("com.demo.test")
public class Application1 {
    public static void main(String[] args) {
        SpringApplication.run(Application1.class,args);
    }
}
