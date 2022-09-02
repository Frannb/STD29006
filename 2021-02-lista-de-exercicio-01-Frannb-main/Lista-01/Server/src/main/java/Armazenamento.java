import java.util.ArrayList;

public class Armazenamento {
    private ArrayList<Dados> autenticacao = new ArrayList<>();

    public void carregarDados(){
        Dados d1 = new Dados("1910066330","m321");
        autenticacao.add(d1);
        Dados d2 = new Dados("1920030407","jose23");
        autenticacao.add(d2);
        Dados d3 = new Dados("1810017999","livi1");
        autenticacao.add(d3);
        Dados d4 = new Dados("2020045962","debian8");
        autenticacao.add(d4);
    }
    public ArrayList<Dados> getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(ArrayList<Dados> autenticacao) {
        this.autenticacao = autenticacao;
    }
}
