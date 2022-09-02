package monitor;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

import java.io.IOException;
import java.awt.*;
import java.util.concurrent.TimeoutException;

/**
 * Pequeno exemplo para ilustrar a captura
 * de evento de clique do mouse
 */
public class Principal implements DrawListener {
    private int dimensao;
    private Robo robo1;
    private Robo robo2;
    private Bandeira b1;
    private Bandeira b2;
    private Bandeira b3;
    private Draw draw;
    public static String mensagemRecebida;

    EnviaRecebeAuditor comunicao;
    public Principal(int dimensao) throws IOException, TimeoutException, InterruptedException {

        comunicao = new EnviaRecebeAuditor();

        //Aguarda receber do Auditor o mapa
        comunicao.recebeAuditor();

        //Criando os dois Robos nas coordenadas aleatórias
        robo1 = new Robo("robo-azul", 1);
        robo2 = new Robo("robo-vermelho", 2);
        //Criando as bandeiras
        b1 = new Bandeira("bandeira", 1);
        b2 = new Bandeira("bandeira", 2);
        b3 = new Bandeira("bandeira", 3);

        //Espera 10s
        Thread.sleep(1000);

        while(true) {
            boolean verifica = false;

            if (mensagemRecebida != null) {
                verifica = true;
            }

            if (verifica) {
                if (separaMensagem(mensagemRecebida)) {

                    // Objeto responsável por fazer a área de desenho (canvas)
                    draw = new Draw();

                    // Adicionando objeto desta classe como o
                    // objeto que ficará ouvindo por eventos do mouse ou teclado
                    draw.addListener(this);

                    // Indicando o número de casas da área de desenho
                    this.dimensao = dimensao;
                    draw.setXscale(0, dimensao);
                    draw.setYscale(0, dimensao);
                    draw.enableDoubleBuffering();

                    // Desenhando os objetos na tela
                    desenharTela();
                    mensagemRecebida = null;
                }
            }
        }
    }

    public String getMensagemRecebida() {
        return mensagemRecebida;
    }

    public void setMensagemRecebida(String mensagemRecebida) {
        this.mensagemRecebida = mensagemRecebida;
    }

    /**
     * Desenha a grade do tabuleiro
     */
    public void desenharTabuleiro(){
        draw.setPenColor(Color.BLACK);
        for (int i = 0; i <= dimensao; i++) draw.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j++) draw.line(0, j, dimensao, j);
    }

    /**
     * Faz o objeto círculo se desenhar na tela
     */
    public void desenharRobo(){
        robo1.desenhar(draw);
        robo2.desenhar(draw);
        b1.desenhar(draw);
        b2.desenhar(draw);
        b3.desenhar(draw);
    }

    /**
     * Limpa a tela, desenha o tabuleiro e os círculos
     */
    public void desenharTela(){
        draw.clear(Color.LIGHT_GRAY);
        this.desenharTabuleiro();
        this.desenharRobo();
        draw.show();
    }

    public boolean verificaBandeira(Robo robo, Bandeira bandeira){
        boolean r = false;
        if ((bandeira.getX() == robo.getX()) && (bandeira.getY() == robo.getY())) {
            bandeira.setCapturado(true);
            bandeira.desenhar(draw);
            r = true;
        }
        return r;
    }

    /**
     * Captura o evento de botão pressionado do mouse
     * @param x coordenada X do cursor do mouse quando o botão foi pressionado
     * @param y coordenada Y do cursor do mouse quando o botão foi pressionado
     */
    public void mousePressed(double x, double y) {
        // Se o usuário clicou dentro da casa do tabuleiro onde está o robo
        if ((Math.floor(x) == robo1.getX()) && (Math.floor(y) == robo1.getY())){
            robo1.marcaDesmarca();
        }else{
            if(robo1.isSelecionado()) {
                if (robo1.getX() != Math.floor(x)){
                    robo1.setX(Math.floor(x));
                }else if (robo1.getY() != Math.floor(y)){
                    robo1.setY(Math.floor(y));
                }
                comunicao.enviaAuditor("Controle - Jogador 1 se movimentou para posição: (" +
                        robo1.getX() + " , " + robo1.getY()+ ")");

                robo1.setSelecionado(false);

                if(verificaBandeira(robo1, b1) || verificaBandeira(robo1, b2) || verificaBandeira(robo1, b3)){
                    comunicao.enviaAuditor("Captura - Jogador 1 capturou uma bandeira");
                }
            }
        }

        if ((Math.floor(x) == robo2.getX()) && (Math.floor(y) == robo2.getY())){
            robo2.marcaDesmarca();
        }else{
            if(robo2.isSelecionado()) {
                if (robo2.getX() != Math.floor(x)){
                    robo2.setX(Math.floor(x));
                }else if (robo2.getY() != Math.floor(y)){
                    robo2.setY(Math.floor(y));
                }
                comunicao.enviaAuditor("Controle - Jogador 2 se movimentou para posição: (" +
                        robo2.getX() + " , " + robo2.getY()+ ")");
                robo2.setSelecionado(false);

                if(verificaBandeira(robo2, b1) || verificaBandeira(robo2, b2) || verificaBandeira(robo2, b3)){
                    comunicao.enviaAuditor("Captura - Jogador 2 capturou uma bandeira");
                }
            }
        }


        // Limpa a tela e desenha tudo novamente (tabuleiro e círculo)
        desenharTela();
    }

    public boolean separaMensagem(String mensagem){
        String[] msgSeparada = mensagem.split(";");
        for (int i = 0; i < 5; i++) {
            msgSeparada[i] = msgSeparada[i].substring((msgSeparada[i].indexOf("="))+1, msgSeparada[i].length());
        }
        String[] coordenadas;
        coordenadas = msgSeparada[0].split(",");
        robo1.defX(Double.parseDouble(coordenadas[0]));
        robo1.defY(Double.parseDouble(coordenadas[1]));

        coordenadas = msgSeparada[1].split(",");
        robo2.defX(Double.parseDouble(coordenadas[0])); robo2.defY(Double.parseDouble(coordenadas[1]));

        coordenadas = msgSeparada[2].split(",");
        b1.defX(Double.parseDouble(coordenadas[0])); b1.defY(Double.parseDouble(coordenadas[1]));

        coordenadas = msgSeparada[3].split(",");
        b2.defX(Double.parseDouble(coordenadas[0])); b2.defY(Double.parseDouble(coordenadas[1]));

        coordenadas = msgSeparada[4].split(",");
        b3.defX(Double.parseDouble(coordenadas[0])); b3.defY(Double.parseDouble(coordenadas[1]));
        return true;
    }

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Principal p = new Principal(8);
    }


    // Métodos da interface DrawListener que não serão usados neste exemplo
    @Override
    public void mouseDragged(double v, double v1) {}
    @Override
    public void mouseReleased(double v, double v1) {}
    @Override
    public void mouseClicked(double v, double v1) {}
    @Override
    public void keyTyped(char c) {}
    @Override
    public void keyPressed(int i) {}
    @Override
    public void keyReleased(int i) {}
}
