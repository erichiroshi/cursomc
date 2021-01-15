package com.erichiroshi.cursomc.dto;

import java.io.Serializable;

import com.erichiroshi.cursomc.domain.Cidade;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	public CidadeDTO (Cidade cidade) {
		this.id = cidade.getId();
		this.nome = cidade.getNome();
	}
}