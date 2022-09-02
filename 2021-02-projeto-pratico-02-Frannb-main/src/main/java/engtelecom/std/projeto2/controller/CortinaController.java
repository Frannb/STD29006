package engtelecom.std.projeto2.controller;

import engtelecom.std.projeto2.banco.BancoDeDados;
import engtelecom.std.projeto2.entities.Cortina;
import engtelecom.std.projeto2.exceptions.ObjetoNaoEncontradoException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cortina")
public class CortinaController {
    private final BancoDeDados banco = new BancoDeDados();

    @GetMapping
    public List<Cortina> obterTodasLampadas(){
        return this.banco.getCortinas();
    }

    @GetMapping("/{id}")
    public Cortina obterPessoa(@PathVariable long id){
        for (Cortina c: this.banco.getCortinas()){
            if (c.getId() == id){
                return c;
            }
        }
        throw new ObjetoNaoEncontradoException(id);
    }

    @PutMapping("/{id}")
    public String atualizarLampada(@RequestBody Cortina cortina, @PathVariable long id){
        for (Cortina c: this.banco.getCortinas()){
            if (c.getId() == id){
                c.setStatus(cortina.isStatus());
                return "200 OK \n";
            }
        }
        throw new ObjetoNaoEncontradoException(id);
    }

}
