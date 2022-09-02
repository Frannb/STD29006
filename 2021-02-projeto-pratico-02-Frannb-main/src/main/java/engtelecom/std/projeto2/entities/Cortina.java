package engtelecom.std.projeto2.entities;

public class Cortina extends Dispositivo{
    //status -> FECHADO: false | ABERTO: true
    public Cortina() {
    }

    public Cortina(long id, boolean status) {
        super(id, status);
    }
}
