package br.com.wesleyti.lombokspringapirest.service;
import br.com.wesleyti.lombokspringapirest.dominio.Empresa;
import br.com.wesleyti.lombokspringapirest.repositorio.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServico {

	@Autowired
	private EmpresaRepositorio empresaRepositorio;
	
	public Empresa salvar(Empresa empresa) {
		return empresaRepositorio.save(empresa);
	}

	public List<Empresa> listar() {
		return empresaRepositorio.findAll();
	}

	public Optional<Empresa> buscarPor(Long empresaId) {
		Optional<Empresa> empresa = empresaRepositorio.findById(empresaId);
		return empresa;
	}

	public boolean idEmpresaJaExiste(Long empresaId){
		if (empresaRepositorio.existsById(empresaId)) {
			return true;
		}
		return false;
	}
	
	public void excluir(Long empresaId) {
		empresaRepositorio.deleteById(empresaId);
	}
}
