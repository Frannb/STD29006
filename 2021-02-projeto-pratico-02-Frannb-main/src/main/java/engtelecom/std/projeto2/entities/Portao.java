package engtelecom.std.projeto2.entities;

public class Portao extends Dispositivo{

    //status -> FECHADO: false | ABERTO: true
    public Portao() {
    }

    public Portao(long id, boolean status) {
        super(id, status);
    }
}
