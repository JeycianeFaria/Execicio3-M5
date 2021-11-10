package br.com.zup.simulador.simulador.conversor;

import br.com.zup.simulador.simulador.dtos.RiscoDTO;
import br.com.zup.simulador.simulador.exeptions.RiscoInvalido;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConversorRiscoDTO implements Converter<String, RiscoDTO> {

    public ConversorRiscoDTO(){
        System.out.println("Criando ConversorRiscoDTO");
    }

    @Override
    public RiscoDTO convert(String risco){
        try {
            System.out.println("Iniciando RiscoDTO try");
            return RiscoDTO.valueOf(risco);
        }catch (IllegalArgumentException exeption){
            System.out.println("Iniciando RiscoDTO catch");
            throw new RiscoInvalido("Risco não reconhecido");
        }catch (Exception exception){
            System.out.println("Iniciando RiscoDTO catch 2");
            throw new RiscoInvalido("Risco não reconhecido");
        }

    }

}
