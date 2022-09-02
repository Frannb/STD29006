package monitor;
import edu.princeton.cs.algs4.Draw;

public class Robo {
    private int id;
    private double x;
    private double y;
    private String imagem;
    private boolean selecionado;

    public Robo(double x, double y, String imagemNome, int idJogador) {
        this.x = Math.floor(x);
        this.y = Math.floor(y);
        this.id = idJogador;
        this.imagem = imagemNome;
        this.selecionado = false;
    }

    public Robo(String imagemNome, int idJogador) {
        this.x = Math.floor(this.x);
        this.y = Math.floor(this.y);
        this.id = idJogador;
        this.imagem = imagemNome;
        this.selecionado = false;
    }


    public void desenhar(Draw desenho){
        if(selecionado){
            desenho.picture(x + 0.5, y + 0.5, this.imagem + "-selecionado.png", .375);
        }else {
            desenho.picture(x + 0.5, y + 0.5,  this.imagem + ".png", .375);
        }
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void marcaDesmarca() {
        this.selecionado = ! this.selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        if ((x == (this.x + 1)) || (x == (this.x - 1))) {
            this.x = x;
        }
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        if ((y == (this.y + 1)) || (y == (this.y - 1))) {
            this.y = y;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void defX(double x) {
        this.x = x;
    }

    public void defY(double y) {
        this.y = y;
    }

}
