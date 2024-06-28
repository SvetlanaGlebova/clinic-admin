package examples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class ConfigClass {
    //-Dspring.profiles.active=имя_профиля1,имя_профиля2

@Profile({"dev", "prod"})
    @Primary //больше чем 1 Primary над bean-ами использовать нельзя - будет конфликт
    @Bean
    public Runnable runnable01(){
        return () -> System.out.println("runnable01");
    }
    @Profile(("prod"))
    @Bean("rBean")
    public Runnable runnable02(){
        return () -> System.out.println("runnable02");
    }

}
