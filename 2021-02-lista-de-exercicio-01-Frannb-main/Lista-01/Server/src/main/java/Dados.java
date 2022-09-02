import java.util.ArrayList;

public class Dados {
    private String matricula;
    private String senha;
    private int quantAcertos = 0;
    private int quantRespondidas = 0;

    public Dados(String matricula, String senha) {
        this.matricula = matricula;
        this.senha = senha;
    }

    public void addQuantAcertos(){
        this.quantAcertos = quantRespondidas + 1;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAcertos() {
        return quantAcertos;
    }

    public void setAcertos(int acertos) {
        this.quantAcertos = acertos;
    }

    public int getRespondidas() {
        return quantRespondidas;
    }

    public void setRespondidas(int respondidas) {
        this.quantRespondidas = respondidas;
    }
}
