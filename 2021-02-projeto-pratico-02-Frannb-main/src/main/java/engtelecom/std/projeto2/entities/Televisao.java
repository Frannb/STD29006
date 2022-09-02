package engtelecom.std.projeto2.entities;

public class Televisao extends Dispositivo{
    private int volume = 10;
    private int canal = 45;

    public Televisao() {

    }
    public Televisao(long id, boolean status) {
        super(id, status);
    }

    public Televisao(long id, boolean status, int volume, int canal) {
        super(id, status);
        if (0 <= volume && volume <= 99) {
            this.volume = volume;
        }
        if (1 <= canal && canal <= 999) {
            this.canal = canal;
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (0 <= volume && volume <= 99) {
            this.volume = volume;
        }
    }

    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        if (1 <= canal && canal <= 999) {
            this.canal = canal;
        }
    }

    @Override
    public String toString() {
        return "Televisao{" +
                "id=" + id +
                ", status=" + status +
                ", volume=" + volume +
                ", canal=" + canal +
                '}';
    }
}
