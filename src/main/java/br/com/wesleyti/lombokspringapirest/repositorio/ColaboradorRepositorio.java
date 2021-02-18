package br.com.wesleyti.lombokspringapirest.repositorio;
import br.com.wesleyti.lombokspringapirest.dominio.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepositorio extends JpaRepository<Colaborador, Long> {}