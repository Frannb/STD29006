package engtelecom.std.projeto2.controller;

import engtelecom.std.projeto2.banco.BancoDeDados;
import engtelecom.std.projeto2.entities.*;
import engtelecom.std.projeto2.exceptions.ObjetoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/cenario")
public class CenarioController {
    private final BancoDeDados banco = new BancoDeDados();

    @GetMapping
    public List<String> obterTodosCenarios() {
        List<String> cNomeList = new ArrayList<>();
        for (Cenario c : this.banco.getCenario()) {
            cNomeList.add(c.getNome());
        }
        return cNomeList;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String adicionarCenario(@RequestBody Cenario c){
        Cenario cen = new Cenario(c.getNome());
        this.banco.getCenario().add(cen);
        return "200 OK \n";
    }

    @DeleteMapping
    public String excluirCenario(@RequestBody Cenario c){
        if (!this.banco.getCenario().removeIf(cenario -> cenario.getNome().equals(c.getNome()))){
            return "400 \n";
        }
        return "200 OK \n";
    }

    @GetMapping("/{nome_cenario}")
    public Cenario obterTodosDispositivosCenario(@PathVariable String nome_cenario) {
        for(Cenario c: this.banco.getCenario()){
            if (c.getNome().equals(nome_cenario)){
                return c;
            }
        }
        throw new ObjetoNaoEncontradoException(nome_cenario);
    }

    @PostMapping("/{nome_cenario}")
    @ResponseStatus(HttpStatus.CREATED)
    public String adicionarDispositivoCenario(@RequestBody Map<String,String> m, @PathVariable String nome_cenario) {
        String retorno = null;
        if (m.get("temperatura") != null) { //É UM AR-CONDICIONADO
            for (Cenario c : this.banco.getCenario()) {
                if (c.getNome().equals(nome_cenario)) {
                    c.addDispositivoCenario(new ArCondicionado(this.banco.getContador().incrementAndGet(),
                            Boolean.parseBoolean(m.get("status")),
                            Integer.parseInt(m.get("temperatura")),
                            Integer.parseInt(m.get("modo"))));
                    retorno = "ok";
                }
            }
        } else if (m.get("volume") != null) { //É UMA TV
            for (Cenario c : this.banco.getCenario()) {
                if (c.getNome().equals(nome_cenario)) {
                    c.addDispositivoCenario(new Televisao(this.banco.getContador().incrementAndGet(),
                            Boolean.parseBoolean(m.get("status")),
                            Integer.parseInt(m.get("volume")),
                            Integer.parseInt(m.get("canal"))));
                    retorno = "ok";
                }
            }
        } else if ((m.get("volume") != null) && (m.get("modo") != null)) { //É UM SOM
            for (Cenario c : this.banco.getCenario()) {
                if (c.getNome().equals(nome_cenario)) {
                    c.addDispositivoCenario(new Som(this.banco.getContador().incrementAndGet(),
                            Boolean.parseBoolean(m.get("status")),
                            Integer.parseInt(m.get("volume")),
                            Integer.parseInt(m.get("modo"))));
                    retorno = "ok";
                }
            }
        } else { // É UM DISPOSITIVO
            for (Cenario c : this.banco.getCenario()) {
                if (c.getNome().equals(nome_cenario)) {
                    c.addDispositivoCenario(new Dispositivo(this.banco.getContador().incrementAndGet(),
                            Boolean.parseBoolean(m.get("status"))));
                    retorno = "ok";
                }
            }
        }
        return (retorno != null) ? "200 OK \n" : "400 \n";
    }

    @GetMapping("/{nome_cenario}/{dispositivo}")
    public List<Dispositivo> obterDispositivoDeUmCenario(@PathVariable String nome_cenario, @PathVariable int dispositivo) {
        for(Cenario c: this.banco.getCenario()){
            if (c.getNome().equals(nome_cenario)){
                return c.getDispositivos();
            }
        }
        throw new ObjetoNaoEncontradoException(nome_cenario);
    }

    @DeleteMapping("/{nome_cenario}/{dispositivo}")
    public String excluirDispositivoDeUmAmbiente(@PathVariable String nome_cenario, @PathVariable int dispositivo) {
        for(Cenario c: this.banco.getCenario()){
            if (c.getNome().equals(nome_cenario)){
                c.getDispositivos().removeIf(cen -> cen.getId() == dispositivo);
                return "200 OK \n";
            }
        }
        return "400 \n";
    }

}
