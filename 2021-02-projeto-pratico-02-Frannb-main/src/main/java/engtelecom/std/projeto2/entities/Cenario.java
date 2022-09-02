package engtelecom.std.projeto2.entities;

import java.util.ArrayList;
import java.util.List;

public class Cenario {
    private String nome;
    private final List<Dispositivo> dispositivos =  new ArrayList<>();

    public Cenario(String nome) {
        this.nome = nome;
    }

    public Cenario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void addDispositivoCenario(Dispositivo dispositivo){
        this.dispositivos.add(dispositivo);
    }

}
