package engtelecom.std.projeto2.entities;

import java.util.ArrayList;
import java.util.List;

public class Ambiente {
    private String nome;
    private final List<Dispositivo> dispositivos =  new ArrayList<>();

    public Ambiente(String nome) {
        this.nome = nome;
    }

    public Ambiente() {
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

    public void addDispositivoAmbiente(Dispositivo dispositivo){
        this.dispositivos.add(dispositivo);
    }
}
