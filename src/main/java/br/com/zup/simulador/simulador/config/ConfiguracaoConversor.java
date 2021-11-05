package br.com.zup.simulador.simulador.config;

import br.com.zup.simulador.simulador.conversor.ConversorRiscoDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfiguracaoConversor implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new ConversorRiscoDTO());
    }

}
