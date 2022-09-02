package engtelecom.std.projeto2.controller;

import engtelecom.std.projeto2.banco.BancoDeDados;
import engtelecom.std.projeto2.entities.Som;
import engtelecom.std.projeto2.exceptions.ObjetoNaoEncontradoException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/som")
public class SomController {
    private final BancoDeDados banco = new BancoDeDados();

    @GetMapping
    public List<Som> obterTodasLampadas(){
        return this.banco.getSons();
    }

    @GetMapping("/{id}")
    public Som obterPessoa(@PathVariable long id){
        for (Som s: this.banco.getSons()){
            if (s.getId() == id){
                return s;
            }
        }
        throw new ObjetoNaoEncontradoException(id);
    }

    @PutMapping("/{id}")
    public String atualizarLampada(@RequestBody Som som, @PathVariable long id){
        for (Som s: this.banco.getSons()){
            if (s.getId() == id){
                s.setStatus(som.isStatus());
                s.setModo(som.getModo());
                s.setVolume(som.getVolume());
                return "200 OK \n";
            }
        }
        throw new ObjetoNaoEncontradoException(id);
    }

}
