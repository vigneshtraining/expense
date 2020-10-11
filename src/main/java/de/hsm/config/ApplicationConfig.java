package de.hsm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class ApplicationConfig implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("de.hsm"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        List<VendorExtension> vendorExtensions = new ArrayList<>();
        return new ApiInfo("Expense Tracker REST API",
                "This is an API docs for Expense Tracker",
                "1.0.0",
                "",
                new Contact("Expense Tracker", "", "developer@gmail.com"),
                "OPEN", "", vendorExtensions);
    }


}
