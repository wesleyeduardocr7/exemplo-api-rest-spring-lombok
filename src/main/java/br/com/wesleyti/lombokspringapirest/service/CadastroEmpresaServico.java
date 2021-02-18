package br.com.wesleyti.lombokspringapirest.service;
import br.com.wesleyti.lombokspringapirest.dominio.Empresa;
import br.com.wesleyti.lombokspringapirest.repositorio.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroEmpresaServico {

	@Autowired
	private EmpresaRepositorio empresaRepositorio;
	
	public Empresa salvar(Empresa empresa) {
		return empresaRepositorio.save(empresa);
	}
	
	public void excluir(Long empresaId) {
		empresaRepositorio.deleteById(empresaId);
	}
}
