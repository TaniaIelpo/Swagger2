package co.develhope.exerciseSwagger2.config;

/**
 * @author Tania Ielpo
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration

public class SpringFoxConfig {

    @Bean
    public Docket api() {

        ApiInfo apiInfo = new ApiInfo(
                "First Exercise on Swagger",
                "A simple swagger example API documentation",
                "1.0.0",
                "https://it.wikipedia.org/wiki/Licenza_MIT",
                new Contact("Tania", "https://develhope.co", "taniaie@tiscali.it"),
                "MIT",
                "https://it.wikipedia.org/wiki/Licenza_MIT",
                Collections.emptyList()
        );

        Tag tagMath = new Tag("math-controller","The math controller");
        Tag tagDefault = new Tag("default-controller","The default controller");

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo)
                .tags(tagMath,tagDefault)
                ;
    }
}
