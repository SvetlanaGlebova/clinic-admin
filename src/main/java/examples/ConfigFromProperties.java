package examples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//inject.service.title=имя
//inject.service.number=120
@Profile("dev")
@Component
@ConfigurationProperties(prefix = "inject")
public class ConfigFromProperties {
    @Value("${service.title}")
    private String title;

    @Value("${service.number}")
    private int version;

    //inject.fromPropertiesByName
    private String fromPropertiesByName;
}
