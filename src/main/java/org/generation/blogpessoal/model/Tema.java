package org.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "tb_tema")
public class Tema {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
   private long id;
   @NotNull
   private String descricao;
   //tipo de relacionqmento ds tabelas chave estrangeira
   @OneToMany(mappedBy = "tema", cascade = CascadeType.ALL) // colocar o jason quando tem um relcionamento de tabelas
   @JsonIgnoreProperties("tema") // para o spring para nao ficar buscando direto , nao pesquisa mais de uma vez
   private List<Postagem> postagem;

   public long getId() {
	return id;
	
}
public void setId(long id) {
	this.id = id;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public List<Postagem> getPostagem() {
	return postagem;
}
public void setPostagem(List<Postagem> postagem) {
	this.postagem = postagem;
}
}
