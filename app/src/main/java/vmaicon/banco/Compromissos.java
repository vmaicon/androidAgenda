package vmaicon.banco;

import java.io.Serializable;

/**
 * Created by maicon on 19/04/2017.
 */

public class Compromissos implements Serializable{

    private long id;
    private String evento, dataevento;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getDataevento() {
        return dataevento;
    }

    public void setDataevento(String dataevento) {
        this.dataevento = dataevento;
    }

    @Override
    public String toString() {
        return getDataevento() +" - "+getEvento();
    }
}
