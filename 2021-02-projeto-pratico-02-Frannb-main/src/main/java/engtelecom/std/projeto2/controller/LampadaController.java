package engtelecom.std.projeto2.controller;
import engtelecom.std.projeto2.entities.Lampada;
import engtelecom.std.projeto2.banco.BancoDeDados;
import engtelecom.std.projeto2.exceptions.ObjetoNaoEncontradoException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lampada")
public class LampadaController {
    private final BancoDeDados banco = new BancoDeDados();

    @GetMapping
    public List<Lampada> obterTodasLampadas(){
        return this.banco.getLampadas();
    }

    @GetMapping("/{id}")
    public Lampada obterPessoa(@PathVariable long id){
        for (Lampada l: this.banco.getLampadas()){
            if (l.getId() == id){
                return l;
            }
        }
        throw new ObjetoNaoEncontradoException(id);
    }

    @PutMapping("/{id}")
    public String atualizarLampada(@RequestBody Lampada lampada, @PathVariable long id){
        for (Lampada l: this.banco.getLampadas()){
            if (l.getId() == id){
                l.setStatus(lampada.isStatus());
                return "200 OK \n";
            }
        }
        throw new ObjetoNaoEncontradoException(id);
    }
}
