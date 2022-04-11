package org.generation.blogpessoal.repository;

import java.util.List;
import java.util.Optional;

import org.generation.blogpessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// COMUNICAÇÃO DA API COM O BANCO DE DADOS 
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
public Optional<Usuario> findByUsuario(String string);

public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);


}
