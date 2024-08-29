package es.dsrroma.school.springboot.reuniones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dsrroma.school.springboot.reuniones.data.ReunionRepository;
import es.dsrroma.school.springboot.reuniones.models.Reunion;

@Service
public class ReunionService {

	@Autowired
	private final ReunionRepository reunionRepository;

	public ReunionService(ReunionRepository reunionRepository) {
		this.reunionRepository = reunionRepository;
	}

	public List<Reunion> getAllReuniones() {
		return reunionRepository.findAll();
	}

	public Reunion crearReunion(Reunion reunion) {
		return reunionRepository.save(reunion);
	}


}
