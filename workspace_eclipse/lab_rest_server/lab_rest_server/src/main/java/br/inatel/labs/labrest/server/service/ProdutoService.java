package br.inatel.labs.labrest.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import br.inatel.labs.labrest.server.model.Produto;
import jakarta.annotation.PostConstruct;

@Service
public class ProdutoService {

	private List<Produto> produtos = new ArrayList<>();
	
	@PostConstruct
	private void setup() {
		Produto p1 = new Produto(1L, "Furadeira", new BigDecimal(230.00));
		Produto p2 = new Produto(2L, "Serra Circular", new BigDecimal(230.00));
		Produto p3 = new Produto(3L, "Parafusadeira", new BigDecimal(230.00));
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);
	}
	
	public List<Produto> findAll() {
		return this.produtos;
	}
	
	public Optional<Produto> findById(Long id) {
		return produtos.stream()
				.filter(p -> p.getId() == id)
				.findFirst();	
	}
	
	public Produto create(Produto p){
		long idRandom = new Random().nextLong();
		p.setId(idRandom);
		produtos.add(p);
		return p;
	}
	
	public void update(Produto p) {
		produtos.remove(p);
		produtos.add(p);
	}
	
	public void remove(Produto p) {
		produtos.remove(p);
	}
}
