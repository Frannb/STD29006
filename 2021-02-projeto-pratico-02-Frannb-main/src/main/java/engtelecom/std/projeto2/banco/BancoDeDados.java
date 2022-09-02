package engtelecom.std.projeto2.banco;
import engtelecom.std.projeto2.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class BancoDeDados {
    private List<ArCondicionado> arCondicionados = new ArrayList<>();
    private List<Dispositivo> dispositivos = new ArrayList<>();
    private List<Televisao> televisaos = new ArrayList<>();
    private AtomicLong contador = new AtomicLong(19);
    private List<Ambiente> ambiente = new ArrayList<>();
    private List<Cortina> cortinas = new ArrayList<>();
    private List<Lampada> lampadas = new ArrayList<>();
    private List<Cenario> cenario = new ArrayList<>();
    private List<Portao> portoes = new ArrayList<>();
    private List<Som> sons = new ArrayList<>();

    public BancoDeDados() {
        //Adicionando 3 televisões
        televisaos.add(new Televisao(1,false));
        televisaos.add(new Televisao(2,false));
        televisaos.add(new Televisao(3,false));

        //Adicionando 3 cortinas
        cortinas.add(new Cortina(4,false));
        cortinas.add(new Cortina(5,false));
        cortinas.add(new Cortina(6,false));

        //Adicionando 6 lampadas
        lampadas.add(new Lampada(7,false));
        lampadas.add(new Lampada(8,false));
        lampadas.add(new Lampada(9,false));
        lampadas.add(new Lampada(10,false));
        lampadas.add(new Lampada(11,false));
        lampadas.add(new Lampada(12,false));

        //Adicionando 2 portões
        portoes.add(new Portao(13,false));
        portoes.add(new Portao(14,false));

        //Adicionando 2 sons
        sons.add(new Som(15,false));
        sons.add(new Som(16,false));

        //Adicionando 3 ar-condicionados
        arCondicionados.add(new ArCondicionado(17,false));
        arCondicionados.add(new ArCondicionado(18,false));
        arCondicionados.add(new ArCondicionado(19,false));

        Ambiente a1 = new Ambiente("sala");
        a1.addDispositivoAmbiente(new ArCondicionado(19,false));
        a1.addDispositivoAmbiente(new Televisao(1,false));
        ambiente.add(a1);

        Ambiente a2 = new Ambiente("cozinha");
        a2.addDispositivoAmbiente(new Lampada(7,false));
        a2.addDispositivoAmbiente(new Lampada(8,false));
        ambiente.add(a2);

        Cenario c1 = new Cenario("festa");
        c1.addDispositivoCenario(new Lampada(12,false));
        c1.addDispositivoCenario(new Som(16,false));
        cenario.add(c1);

        Cenario c2 = new Cenario("amanhecer");
        c2.addDispositivoCenario(new Lampada(7,false));
        c2.addDispositivoCenario(new Lampada(8,false));
        cenario.add(c2);


    }

    public List<ArCondicionado> getArCondicionados() {
        return arCondicionados;
    }

    public List<Televisao> getTelevisaos() {
        return televisaos;
    }

    public List<Cortina> getCortinas() {
        return cortinas;
    }

    public List<Lampada> getLampadas() {
        return lampadas;
    }

    public List<Portao> getPortoes() {
        return portoes;
    }

    public List<Som> getSons() {
        return sons;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public List<Ambiente> getAmbiente() {
        return ambiente;
    }

    public AtomicLong getContador() {
        return contador;
    }

    public List<Cenario> getCenario() {
        return cenario;
    }
}
