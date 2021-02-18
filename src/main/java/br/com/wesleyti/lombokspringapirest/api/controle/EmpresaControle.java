package br.com.wesleyti.lombokspringapirest.api.controle;
import br.com.wesleyti.lombokspringapirest.dominio.Empresa;
import br.com.wesleyti.lombokspringapirest.service.EmpresaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresa")
public class EmpresaControle {

	@Autowired
	private EmpresaServico empresaServico;

	@GetMapping
	public List<Empresa> listar() {
		return empresaServico.listar();
	}
	
	@GetMapping("/{empresaId}")
	public ResponseEntity<Empresa> buscar(@PathVariable Long empresaId) {

		Optional<Empresa> empresa = empresaServico.buscarPor(empresaId);
		
		if (empresa.isPresent()) {
			return ResponseEntity.ok(empresa.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Empresa adicionar(@RequestBody Empresa empresa) {
		return empresaServico.salvar(empresa);
	}
	
	@PutMapping("/{empresaId}")
	public ResponseEntity<Empresa> atualizar(@PathVariable Long empresaId,
                                          @RequestBody Empresa empresa) {
		
		if (!empresaServico.idEmpresaJaExiste(empresaId)) {
			return ResponseEntity.notFound().build();
		}
		
		empresa.setId(empresaId);
		empresa = empresaServico.salvar(empresa);
		
		return ResponseEntity.ok(empresa);
	}
	
	@DeleteMapping("/{empresaId}")
	public ResponseEntity<Void> remover(@PathVariable Long empresaId) {

		if (!empresaServico.idEmpresaJaExiste(empresaId)) {
			return ResponseEntity.notFound().build();
		}
		
		empresaServico.excluir(empresaId);
		
		return ResponseEntity.noContent().build();
	}
}
