package engtelecom.std.projeto2.entities;

public class Dispositivo {
    protected long id = 0;
    protected boolean status;

    public Dispositivo(long id, boolean status) {
        this.id = id;
        this.status = status;
    }

    public Dispositivo(long id) {
        this.id = id;
    }
    public Dispositivo() {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Dispositivo{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
