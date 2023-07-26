//package portal.identity.configs;
//
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import org.springdoc.core.models.GroupedOpenApi;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public OpenAPI apiInfo() {
//        return new OpenAPI().info(new Info().title("后端接口文档").version("1.0.0"));
//    }
//
//    @Bean
//    public GroupedOpenApi httpApi() {
//        return GroupedOpenApi.builder()
//                .group("http")
//                .pathsToMatch("/**")
//                .build();
//    }
//}