package org.generation.blogpessoal.controller;


import java.util.List;

import org.generation.blogpessoal.model.Postagem;
import org.generation.blogpessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Informa que a classe é um controller
@RequestMapping("/postagens") // Define qual RI da classe que será acessada
@CrossOrigin("*") // Aceita requisições de qualquer origem 
public class PostagensController {
     
	@Autowired // garante que todos os serviços sejam acessados pelo controller
	private PostagemRepository repository;
	
	@GetMapping //pega o repository 
    public ResponseEntity<List<org.generation.blogpessoal.model.Postagem>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }
    
		@GetMapping("/{id}") // assim que colocarmos o id vai acessar o esse metodo 
		public ResponseEntity<Postagem> GetById(@PathVariable long id){
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
			// devolve um objeto postagem ou não acha caso a resposta venha nula
  }
// get por titulo 
		@GetMapping("/titulo/{titulo}")
		public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
			return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
		}
		
		@PostMapping // o corpo da requisição vai voltar um objeto postagem
		public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
		}
		// METODO PUT
		@PutMapping // o metodo put vai atualizar dados da tabela 
		public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
		}
		//metodo delete
		@DeleteMapping("/{id}") 
		public void delete(@PathVariable long id) {
			repository.deleteById(id);
		}
}
