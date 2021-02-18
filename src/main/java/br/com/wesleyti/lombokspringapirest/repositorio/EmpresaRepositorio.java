package br.com.wesleyti.lombokspringapirest.repositorio;
import br.com.wesleyti.lombokspringapirest.dominio.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa, Long> {}