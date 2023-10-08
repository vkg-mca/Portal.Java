//package portal.finance.configs;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//
//@Configuration
//@PropertySource("file:config.properties")
//public class ApplicationConfiguration {
//
//    @Value("${gMapReportUrl}")
//    private String gMapReportUrl;
//
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
//
//}