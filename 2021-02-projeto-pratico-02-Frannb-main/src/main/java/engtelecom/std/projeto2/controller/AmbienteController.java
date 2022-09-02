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
@RequestMapping("/ambiente")
public class AmbienteController {
    private final BancoDeDados banco = new BancoDeDados();

    @GetMapping
    public List<String> obterTodosAmbientes() {
        List<String> aNomeList = new ArrayList<>();
        for (Ambiente a : this.banco.getAmbiente()) {
            aNomeList.add(a.getNome());
        }
        return aNomeList;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String adicionarAmbiente(@RequestBody Ambiente a){
        Ambiente amb = new Ambiente(a.getNome());
        this.banco.getAmbiente().add(amb);
        return "200 OK \n";
    }

    @DeleteMapping
    public String excluirAmbiente(@RequestBody Ambiente a){
        if (!this.banco.getAmbiente().removeIf(ambiente -> ambiente.getNome().equals(a.getNome()))){
            return "400 \n";
        }
        return "200 OK \n";
    }

    @GetMapping("/{nome_ambiente}")
    public Ambiente obterTodosDispositivosAmbiente(@PathVariable String nome_ambiente) {
        for(Ambiente a: this.banco.getAmbiente()){
            if (a.getNome().equals(nome_ambiente)){
                return a;
            }
        }
        throw new ObjetoNaoEncontradoException(nome_ambiente);
    }

    @PostMapping("/{nome_ambiente}")
    @ResponseStatus(HttpStatus.CREATED)
    public String adicionarDispositivo(@RequestBody Map<String,String> m, @PathVariable String nome_ambiente) {
        String retorno = null;
        if (m.get("temperatura") != null) { //É UM AR-CONDICIONADO
            for (Ambiente a : this.banco.getAmbiente()) {
                if (a.getNome().equals(nome_ambiente)) {
                    a.addDispositivoAmbiente(new ArCondicionado(this.banco.getContador().incrementAndGet(),
                            Boolean.parseBoolean(m.get("status")),
                            Integer.parseInt(m.get("temperatura")),
                            Integer.parseInt(m.get("modo"))));
                    retorno = "ok";
                }
            }
        } else if (m.get("volume") != null) { //É UMA TV
            for (Ambiente a : this.banco.getAmbiente()) {
                if (a.getNome().equals(nome_ambiente)) {
                    a.addDispositivoAmbiente(new Televisao(this.banco.getContador().incrementAndGet(),
                            Boolean.parseBoolean(m.get("status")),
                            Integer.parseInt(m.get("volume")),
                            Integer.parseInt(m.get("canal"))));
                    retorno = "ok";
                }
            }
        } else if ((m.get("volume") != null) && (m.get("modo") != null)) { //É UM SOM
            for (Ambiente a : this.banco.getAmbiente()) {
                if (a.getNome().equals(nome_ambiente)) {
                    a.addDispositivoAmbiente(new Som(this.banco.getContador().incrementAndGet(),
                            Boolean.parseBoolean(m.get("status")),
                            Integer.parseInt(m.get("volume")),
                            Integer.parseInt(m.get("modo"))));
                    retorno = "ok";
                }
            }
        } else { // É UM DISPOSITIVO
            for (Ambiente a : this.banco.getAmbiente()) {
                if (a.getNome().equals(nome_ambiente)) {
                    a.addDispositivoAmbiente(new Dispositivo(this.banco.getContador().incrementAndGet(),
                            Boolean.parseBoolean(m.get("status"))));
                    retorno = "ok";
                }
            }
        }
        return (retorno != null) ? "200 OK \n" : "400 \n";
    }

    @GetMapping("/{nome_ambiente}/{dispositivo}")
    public List<Dispositivo> obterDispositivoDeUmAmbiente(@PathVariable String nome_ambiente, @PathVariable int dispositivo) {
        for(Ambiente a: this.banco.getAmbiente()){
            if (a.getNome().equals(nome_ambiente)){
                return a.getDispositivos();
            }
        }
        throw new ObjetoNaoEncontradoException(nome_ambiente);
    }

    @DeleteMapping("/{nome_ambiente}/{dispositivo}")
    public String excluirDispositivoDeUmAmbiente(@PathVariable String nome_ambiente, @PathVariable int dispositivo) {
        for(Ambiente a: this.banco.getAmbiente()) {
            if (a.getNome().equals(nome_ambiente)) {
                a.getDispositivos().removeIf(disp -> disp.getId() == dispositivo);
                return "200 OK \n";
            }
        }
            return "400 \n";
    }

}
