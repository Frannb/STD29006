package engtelecom.std.projeto2.controller;

import engtelecom.std.projeto2.banco.BancoDeDados;
import engtelecom.std.projeto2.entities.ArCondicionado;
import engtelecom.std.projeto2.exceptions.ObjetoNaoEncontradoException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ar-condicionado")
public class ArCondicionadoController {
    private final BancoDeDados banco = new BancoDeDados();

    @GetMapping
    public List<ArCondicionado> obterTodasLampadas(){
        return this.banco.getArCondicionados();
    }

    @GetMapping("/{id}")
    public ArCondicionado obterPessoa(@PathVariable long id){
        for (ArCondicionado a: this.banco.getArCondicionados()){
            if (a.getId() == id){
                return a;
            }
        }
        throw new ObjetoNaoEncontradoException(id);
    }

    @PutMapping("/{id}")
    public String atualizarLampada(@RequestBody ArCondicionado arCondicionado, @PathVariable long id){
        for (ArCondicionado a: this.banco.getArCondicionados()){
            if (a.getId() == id){
                a.setStatus(arCondicionado.isStatus());
                a.setModo(arCondicionado.getModo());
                a.setTemperatura(arCondicionado.getTemperatura());
                return "200 OK \n";
            }
        }
        throw new ObjetoNaoEncontradoException(id);
    }

}
