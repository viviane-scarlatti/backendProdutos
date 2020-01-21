package br.org.generation.backendProdutos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.backendProdutos.model.Usuario;
import br.org.generation.backendProdutos.security.Autenticator;
import br.org.generation.backendProdutos.security.Token;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	
	@PostMapping("/login")
	public ResponseEntity<Token> autentica(@RequestBody Usuario usuario) {
		if (usuario.getEmail().equals("vivi@vivi.com") && usuario.getSenha().equals("12345")) {
			// simulando que recuperi usuário do banco de dados
			usuario.setId(2);
			usuario.setNome("Viviane");
			
			// construindo o Token
			String tk  = Autenticator.generateToken(usuario);
			System.out.println("TOKEN gerado = "+tk);
			Token token = new Token();
			token.setStrToken(tk);
			return ResponseEntity.ok(token);
			}
		else {
			return ResponseEntity.status(403).build();
			}		
		
	}
}
