package engtelecom.std.projeto2.entities;

public class ArCondicionado extends Dispositivo{
    private int temperatura = 16;
    private int modo = 0; //AUTO: 0 | DRY: 1 | FAN: 2 | COOL: 3 | HEAT: 4

    public ArCondicionado() {

    }

    public ArCondicionado(long id, boolean status) {
        super(id, status);
    }
    public ArCondicionado(long id, boolean status, int temperatura, int modo) {
        super(id, status);
        if (16 <= temperatura && temperatura <= 30) {
            this.temperatura = temperatura;
        }
        if (0 <= modo && modo <= 4) {
            this.modo = modo;
        }
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        if (16 <= temperatura && temperatura <= 30) {
            this.temperatura = temperatura;
        }
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        if (0 <= modo && modo <= 4) {
            this.modo = modo;
        }
    }

    @Override
    public String toString() {
        return "ArCondicionado{" +
                "temperatura=" + temperatura +
                ", modo=" + modo +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
