package com.springboot_esencial_mensajes.busca;

import org.springframework.stereotype.Component;

@Component
public class InfoBusca {

    private long idAsistente;
    private long idReunion;

    public long getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(long idAsistente) {
        this.idAsistente = idAsistente;
    }

    public long getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(long idReunion) {
        this.idReunion = idReunion;
    }

}
