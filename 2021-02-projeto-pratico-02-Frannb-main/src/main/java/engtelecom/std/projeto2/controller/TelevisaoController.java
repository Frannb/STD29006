package engtelecom.std.projeto2.controller;

import engtelecom.std.projeto2.banco.BancoDeDados;
import engtelecom.std.projeto2.entities.Televisao;
import engtelecom.std.projeto2.exceptions.ObjetoNaoEncontradoException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/televisao")
public class TelevisaoController {
    private final BancoDeDados banco = new BancoDeDados();

    @GetMapping
    public List<Televisao> obterTodasLampadas(){
        return this.banco.getTelevisaos();
    }

    @GetMapping("/{id}")
    public Televisao obterPessoa(@PathVariable long id){
        for (Televisao t: this.banco.getTelevisaos()){
            if (t.getId() == id){
                return t;
            }
        }
        throw new ObjetoNaoEncontradoException(id);
    }

    @PutMapping("/{id}")
    public String atualizarLampada(@RequestBody Televisao televisao, @PathVariable long id){
        for (Televisao t: this.banco.getTelevisaos()){
            if (t.getId() == id){
                t.setStatus(televisao.isStatus());
                t.setCanal(televisao.getCanal());
                t.setVolume(televisao.getVolume());
                return "200 OK \n";
            }
        }
        throw new ObjetoNaoEncontradoException(id);
    }

}
