package auditor;

public class Jogo {
    private GeraMapa geraMapa;
    private int pointJ1 = 0;
    private int pointJ2 = 0;


    public Jogo() {
        geraMapa = new GeraMapa();
    }

    public int getPointJ1() {
        return pointJ1;
    }

    public void setPointJ1(int pointJ1) {
        this.pointJ1 = pointJ1;
    }

    public int getPointJ2() {
        return pointJ2;
    }

    public void setPointJ2(int pointJ2) {
        this.pointJ2 = pointJ2;
    }

    public GeraMapa getGeraMapa() {
        return geraMapa;
    }

//    public String exibeCoordenadas() {
//        return  "posXjogador1=" + this.geraMapa.getPosXjogador1() + ","+ this.geraMapa.getPosYjogador1() +
//                "; posXjogador2=" + this.geraMapa.getPosXjogador2() + ","+ this.geraMapa.getPosYjogador2() +
//                "; posXbandeira1=" + this.geraMapa.getPosXbandeira1() + "," + this.geraMapa.getPosYbandeira1() +
//                "; posXbandeira2=" + this.geraMapa.getPosXbandeira2() + "," + this.geraMapa.getPosYbandeira2() +
//                "; posXbandeira3=" + this.geraMapa.getPosXbandeira3() + "," + this.geraMapa.getPosYbandeira3();
//    }

    @Override
    public String toString() {
        String r;
        if (pointJ1 > pointJ2){
            r = "*** O Jogador azul venceu!! *** \nPontuações:\n  - Jogador azul capturou " + this.pointJ1 + " bandeiras"+ "\n" +
                    "  - Jogador vermelho capturou " + this.pointJ2 + " bandeiras"+ "\n";
        }else {
            r = "*** O Jogador vermelho venceu!! *** \nPontuações:\n  - Jogador vermelho capturou " + this.pointJ2 + " bandeiras"+ "\n" +
                    "  - Jogador azul capturou " + this.pointJ1 + " bandeiras"+ "\n";
        }
        return r;
    }
}
