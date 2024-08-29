package es.dsrroma.school.springboot.reuniones.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.dsrroma.school.springboot.reuniones.services.PersonaService;
import es.dsrroma.school.springboot.reuniones.services.ReunionService;

@Component
public class BuscaListener { // Escucha
    // Se le pasa la clase desde la cual se registra el mensaje
    private static final Logger LOG = LoggerFactory.getLogger(BuscaListener.class);

    private final ObjectMapper mapper; // Convertir objeto Java en representación JSON
    private final PersonaService personaService;
    private final ReunionService reunionService;

    public BuscaListener(ObjectMapper mapper, PersonaService personaService, ReunionService reunionService) {
        this.mapper = mapper;
        this.personaService = personaService;
        this.reunionService = reunionService;
    }

    public void recibirMensaje(String mensaje) {
        InfoBusca info = mapper.readValue(mensaje, InfoBusca.class);
    }

}
