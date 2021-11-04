package br.com.zup.simulador.simulador;

import br.com.zup.simulador.simulador.dtos.SimuladorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simulacao")
public class SimulacaoController {

    @Autowired
    private SimuladorService simulacao;


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void simularInvestimento(@RequestBody SimuladorDTO simuladorDTO){

    }

}
