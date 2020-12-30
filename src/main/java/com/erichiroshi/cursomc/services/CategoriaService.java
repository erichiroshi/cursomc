package com.erichiroshi.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erichiroshi.cursomc.domain.Categoria;
import com.erichiroshi.cursomc.repositories.CategoriaRepository;
import com.erichiroshi.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, Categoria obj) {
			Categoria entity = findById(id);
			updateData(entity, obj);
			return repository.save(entity);
	}

	private void updateData(Categoria entity, Categoria obj) {
		entity.setNome(obj.getNome());
	}
}
