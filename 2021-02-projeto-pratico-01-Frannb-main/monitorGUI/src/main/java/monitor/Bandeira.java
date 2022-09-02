package monitor;
import edu.princeton.cs.algs4.Draw;

public class Bandeira {
    private int id;
    private double x;
    private double y;
    private String imagem;

    private boolean capturado;

    public Bandeira(double x, double y, String imagemNome, int idBandeira) {
        this.x = Math.floor(x);
        this.y = Math.floor(y);
        this.id = idBandeira;
        this.imagem = imagemNome;
        this.capturado = false;
    }

    public Bandeira(String imagemNome, int idBandeira) {
        this.x = Math.floor(this.x);
        this.y = Math.floor(this.y);
        this.id = idBandeira;
        this.imagem = imagemNome;
        this.capturado = false;
    }


    public void desenhar(Draw desenho){
        if (capturado){
            desenho.picture(x + 0.5, y + 0.5,  "sem-" + this.imagem + ".png", .375);
        }else {
            desenho.picture(x + 0.5, y + 0.5, this.imagem + ".png", .375);
        }
    }

    public boolean isCapturado() {
        return capturado;
    }

    public void setCapturado(boolean capturado) {
        this.capturado = capturado;
    }

    public double getX() {
        return x;
    }

    public void defX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void defY(double y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
