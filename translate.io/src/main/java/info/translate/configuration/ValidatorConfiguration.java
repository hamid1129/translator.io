package info.translate.configuration;

import info.translate.domain.validator.UserValidator;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = UserValidator.class)
public class ValidatorConfiguration {

}
