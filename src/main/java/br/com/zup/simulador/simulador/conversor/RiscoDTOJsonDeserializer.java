package br.com.zup.simulador.simulador.conversor;

import br.com.zup.simulador.simulador.dtos.RiscoDTO;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class RiscoDTOJsonDeserializer extends StdDeserializer<RiscoDTO> {

    public RiscoDTOJsonDeserializer() {
        this(null);
    }

    protected RiscoDTOJsonDeserializer(Class vc) {
        super(vc);
    }

    @Override
    public RiscoDTO deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ConversorRiscoDTO conversorRiscoDTO = new ConversorRiscoDTO();
        return conversorRiscoDTO.convert(jsonParser.getText());
    }
}
