package br.com.zup.simulador.simulador;

import br.com.zup.simulador.simulador.dtos.RetornoDTO;
import br.com.zup.simulador.simulador.dtos.SimuladorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/simulacao")
public class SimulacaoController {

    @Autowired
    private SimuladorService simulacao;


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public RetornoDTO simularInvestimento(@RequestBody @Valid SimuladorDTO simuladorDTO){
        return simulacao.retornoDTO(simuladorDTO);
    }

}
