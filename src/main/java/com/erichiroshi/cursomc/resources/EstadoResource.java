package com.erichiroshi.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erichiroshi.cursomc.domain.Cidade;
import com.erichiroshi.cursomc.domain.Estado;
import com.erichiroshi.cursomc.dto.CidadeDTO;
import com.erichiroshi.cursomc.dto.EstadoDTO;
import com.erichiroshi.cursomc.services.CidadeService;
import com.erichiroshi.cursomc.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

	@Autowired
	private EstadoService service;
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> list = service.findAll();
		List<EstadoDTO> listDto = list.stream().map(x -> new EstadoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{estados_id}/cidades")
	public ResponseEntity<List<CidadeDTO>> listCidade(@PathVariable Integer estados_id) {
		List<Cidade> list = cidadeService.findByEstado(estados_id);
		List<CidadeDTO> listDto = list.stream().map(x -> new CidadeDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
