package humanChatbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // 추가적인 MVC 설정이 필요하면 여기에 작성
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
}