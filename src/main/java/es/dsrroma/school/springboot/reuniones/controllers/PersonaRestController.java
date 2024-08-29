package es.dsrroma.school.springboot.reuniones.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.dsrroma.school.springboot.reuniones.models.Persona;
import es.dsrroma.school.springboot.reuniones.services.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaRestController {

	private PersonaService personaService;

	public PersonaRestController(PersonaService personaService) {
		this.personaService = personaService;
	}

	@GetMapping
	public List<Persona> getAllPersonas() {
		return personaService.getAllPersonas();
	}

	@PostMapping("/crear")
	public ResponseEntity<Persona> savePersona(@RequestBody Persona persona) {
		Persona nuevaPersona = personaService.savePersona(persona);

		return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);

	}

}
