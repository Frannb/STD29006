package engtelecom.std.projeto2.entities;

public class Som extends Dispositivo{
    private int volume = 10;
    private int modo = 0;

    public Som() {

    }

    //status -> DESLIGADO: false | LIGADO: true
    //Modo -> Radio: 0 | USB: 1 | CD: 2 | Bluetooth: 3
    public Som(long id, boolean status) {
        super(id, status);
    }

    public Som(long id, boolean status, int volume, int modo) {
        super(id, status);
        if (0 <= volume && volume <= 100) {
            this.volume = volume;
        }
        if (0 <= volume && volume <= 3) {
            this.modo = modo;
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (0 <= volume && volume <= 100) {
            this.volume = volume;
        }
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        if (0 <= volume && volume <= 3) {
            this.modo = modo;
        }
    }

    @Override
    public String toString() {
        return "Som{" +
                "id=" + id +
                ", status=" + status +
                ", volume=" + volume +
                ", modo=" + modo +
                '}';
    }
}
