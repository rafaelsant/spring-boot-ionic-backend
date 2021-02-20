package com.rafaelsantiago.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rafaelsantiago.cursomc.domain.Categoria;
import com.rafaelsantiago.cursomc.domain.Produto;
import com.rafaelsantiago.cursomc.exceptions.ObjectNotFoundException;
import com.rafaelsantiago.cursomc.repositories.CategoriaRepository;
import com.rafaelsantiago.cursomc.repositories.ProdutoRepository;

@Service
public class ProdutosService {
	
	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository catRepo;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
		}
	public Page<Produto> search(String nome, List<Integer> ids,Integer page, Integer linesPerPage,String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = catRepo.findAllById(ids);
		return repo.search(nome,categorias,pageRequest);
	}
}
