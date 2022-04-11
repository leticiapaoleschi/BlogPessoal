package org.generation.blogpessoal.model;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity // tranforma em tabela 
@Table(name="tb_postagens") // cria tabela
public class Postagem {
   @Id // informa que é um id
   @GeneratedValue(strategy= GenerationType.IDENTITY)  // auto_increment
   private long id;
   
   @NonNull 
   private String titulo;
   
   @Size(min=4, max=50) // define a quantidade de caracteres do texto
   private String texto;
   
   @ManyToOne
   @JsonIgnoreProperties("postagem")
   private Usuario usuario; 
   
   @UpdateTimestamp // formata de acordo com a data do seu computador
   private LocalDateTime data;
   @ManyToOne
   @JsonIgnoreProperties("postagem")
    private Tema tema;
    public Tema getTema() {
	return tema;
}

public void setTema(Tema tema) {
	this.tema = tema;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getTexto() {
	return texto;
}

public void setTexto(String texto) {
	this.texto = texto;
}

public LocalDateTime getData() {
	return data;
}

public void setData(LocalDateTime data) {
	this.data = data;
}
   
   
}


