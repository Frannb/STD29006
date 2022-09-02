package auditor;

import java.util.Random;

public class GeraMapa {
    private final int posXjogador1;
    private final int posYjogador1;
    private final int posXjogador2;
    private final int posYjogador2;
    private final int posXbandeira1;
    private final int posYbandeira1;
    private final int posXbandeira2;
    private final int posYbandeira2;
    private final int posXbandeira3;
    private final int posYbandeira3;

    public GeraMapa (){
        Random random = new Random();
        this.posXjogador1 = random.nextInt(8);
        this.posYjogador1 = random.nextInt(8);
        this.posXjogador2 = random.nextInt(8);
        this.posYjogador2 = random.nextInt(8);
        this.posXbandeira1 = random.nextInt(8);
        this.posYbandeira1 = random.nextInt(8);
        this.posXbandeira2 = random.nextInt(8);
        this.posYbandeira2 = random.nextInt(8);
        this.posXbandeira3 = random.nextInt(8);
        this.posYbandeira3 = random.nextInt(8);
    }

    public int getPosXjogador1() {
        return posXjogador1;
    }

    public int getPosYjogador1() {
        return posYjogador1;
    }

    public int getPosXjogador2() {
        return posXjogador2;
    }

    public int getPosYjogador2() {
        return posYjogador2;
    }

    public int getPosXbandeira1() {
        return posXbandeira1;
    }

    public int getPosYbandeira1() {
        return posYbandeira1;
    }

    public int getPosXbandeira2() {
        return posXbandeira2;
    }

    public int getPosYbandeira2() {
        return posYbandeira2;
    }

    public int getPosXbandeira3() {
        return posXbandeira3;
    }

    public int getPosYbandeira3() {
        return posYbandeira3;
    }

    @Override
    public String toString() {
        return  "pos1Jogador=" + posXjogador1 + ","+ posYjogador1 +
                "; pos2Jogador=" + posXjogador2 + ","+ posYjogador2 +
                "; pos1Bandeira=" + posXbandeira1 + "," + posYbandeira1 +
                "; pos2Bandeira=" + posXbandeira2 + "," + posYbandeira2 +
                "; pos3Bandeira=" + posXbandeira3 + "," + posYbandeira3;
    }
}
