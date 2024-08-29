package es.dsrroma.school.springboot.reuniones.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BuscaListener { // Escucha
    // Se le pasa la clase desde la cual se registra el mensaje, para saber desde donde se originó el mensaje al depurar.
    private static final Logger LOG = LoggerFactory.getLogger(BuscaListener.class); 
  


}
