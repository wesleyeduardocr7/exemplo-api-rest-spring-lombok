package br.com.wesleyti.lombokspringapirest.service;
import br.com.wesleyti.lombokspringapirest.dominio.Colaborador;
import br.com.wesleyti.lombokspringapirest.repositorio.ColaboradorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorServico {

	@Autowired
	private ColaboradorRepositorio colaboradorRepositorio;
	
	public Colaborador salvar(Colaborador colaborador) {
		return colaboradorRepositorio.save(colaborador);
	}

	public List<Colaborador> listar() {
		return colaboradorRepositorio.findAll();
	}

	public Optional<Colaborador> buscarPor(Long colaboradorId) {
		Optional<Colaborador> colaborador = colaboradorRepositorio.findById(colaboradorId);
		return colaborador;
	}

	public boolean idColaboradorJaExiste(Long colaboradorId){
		if (colaboradorRepositorio.existsById(colaboradorId)) {
			return true;
		}
		return false;
	}
	
	public void excluir(Long colaboradorId) {
		colaboradorRepositorio.deleteById(colaboradorId);
	}
}
