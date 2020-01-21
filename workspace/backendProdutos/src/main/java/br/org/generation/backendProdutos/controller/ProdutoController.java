package br.org.generation.backendProdutos.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.backendProdutos.model.Produto;
import br.org.generation.backendProdutos.security.Autenticator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin("*")
public class ProdutoController {
	
	@GetMapping("/aluno/todos")
	public ResponseEntity<ArrayList<Produto>> getAllProdutos(@RequestParam String token) {
		if (Autenticator.isValid(token)) {
			/* simulando uma consulta ao banco de dados */
			ArrayList<Produto> lista = new ArrayList<Produto>();
			for (int i=0; i<20;i++) {
				Produto p = new Produto();
				p.setCodigo(i+1);
				p.setTitulo("Titulo: "+(i+1));
				p.setDetalhes("Detalhes do produto ");
				p.setPreco((i+1)*20);
				
				lista.add(p);
			}
			return ResponseEntity.ok(lista);
			
		}
		else {
			return ResponseEntity.status(403).build();
		}
	}
}
