package engtelecom.std.projeto2.controller;

import engtelecom.std.projeto2.banco.BancoDeDados;
import engtelecom.std.projeto2.entities.Portao;
import engtelecom.std.projeto2.exceptions.ObjetoNaoEncontradoException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portao")
public class PortaoController {
    private final BancoDeDados banco = new BancoDeDados();

    @GetMapping
    public List<Portao> obterTodasLampadas(){
        return this.banco.getPortoes();
    }

    @GetMapping("/{id}")
    public Portao obterPessoa(@PathVariable long id){
        for (Portao p: this.banco.getPortoes()){
            if (p.getId() == id){
                return p;
            }
        }
        throw new ObjetoNaoEncontradoException(id);
    }

    @PutMapping("/{id}")
    public String atualizarLampada(@RequestBody Portao portao, @PathVariable long id){
        for (Portao p: this.banco.getPortoes()){
            if (p.getId() == id){
                p.setStatus(portao.isStatus());
                return "200 OK \n";
            }
        }
        throw new ObjetoNaoEncontradoException(id);
    }

}
