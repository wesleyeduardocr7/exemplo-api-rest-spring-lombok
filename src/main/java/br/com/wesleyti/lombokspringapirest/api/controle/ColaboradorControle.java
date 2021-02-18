package br.com.wesleyti.lombokspringapirest.api.controle;
import br.com.wesleyti.lombokspringapirest.dominio.Colaborador;
import br.com.wesleyti.lombokspringapirest.service.ColaboradorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorControle {

	@Autowired
	private ColaboradorServico colaboradorServico;

	@GetMapping
	public List<Colaborador> listar() {
		return colaboradorServico.listar();
	}
	
	@GetMapping("/{colaboradorId}")
	public ResponseEntity<Colaborador> buscar(@PathVariable Long colaboradorId) {

		Optional<Colaborador> colaborador = colaboradorServico.buscarPor(colaboradorId);
		
		if (colaborador.isPresent()) {
			return ResponseEntity.ok(colaborador.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Colaborador adicionar(@RequestBody Colaborador colaborador) {
		return colaboradorServico.salvar(colaborador);
	}
	
	@PutMapping("/{colaboradorId}")
	public ResponseEntity<Colaborador> atualizar(@PathVariable Long colaboradorId,
                                          @RequestBody Colaborador colaborador) {
		
		if (!colaboradorServico.idColaboradorJaExiste(colaboradorId)) {
			return ResponseEntity.notFound().build();
		}
		
		colaborador.setId(colaboradorId);
		colaborador = colaboradorServico.salvar(colaborador);
		
		return ResponseEntity.ok(colaborador);
	}
	
	@DeleteMapping("/{colaboradorId}")
	public ResponseEntity<Void> remover(@PathVariable Long colaboradorId) {

		if (!colaboradorServico.idColaboradorJaExiste(colaboradorId)) {
			return ResponseEntity.notFound().build();
		}
		
		colaboradorServico.excluir(colaboradorId);
		
		return ResponseEntity.noContent().build();
	}
}
