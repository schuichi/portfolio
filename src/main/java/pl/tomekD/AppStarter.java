package pl.tomekD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@EnableAutoConfiguration
public class AppStarter {
       public  static void main(String[] args){
           SpringApplication.run(AppStarter.class, args);
       }
}
