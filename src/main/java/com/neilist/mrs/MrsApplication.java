package com.neilist.mrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@SpringBootApplication
public class MrsApplication {

	@Autowired
	private ThymeleafProperties thymeleafProperties;

	@Value("${spring.thymeleaf.templates_root:}")
	private String templatesRoot;

	public MrsApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(MrsApplication.class, args);
	}

	@Bean
	public ITemplateResolver defaultTemplateResolver() {
		FileTemplateResolver resolver = new FileTemplateResolver();
		resolver.setSuffix(thymeleafProperties.getSuffix());
		resolver.setPrefix(templatesRoot);
		resolver.setTemplateMode(thymeleafProperties.getMode());
		resolver.setCacheable(thymeleafProperties.isCache());
		return resolver;
	}
}
