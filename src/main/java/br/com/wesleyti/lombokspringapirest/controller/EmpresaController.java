package br.com.wesleyti.lombokspringapirest.controller;
import br.com.wesleyti.lombokspringapirest.dominio.Empresa;
import br.com.wesleyti.lombokspringapirest.repositorio.EmpresaRepositorio;
import br.com.wesleyti.lombokspringapirest.service.CadastroEmpresaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaRepositorio empresaRepositorio;

	@Autowired
	private CadastroEmpresaServico cadastroEmpresaServico;

	@GetMapping
	public List<Empresa> listar() {
		return empresaRepositorio.findAll();
	}
	
	@GetMapping("/{empresaId}")
	public ResponseEntity<Empresa> buscar(@PathVariable Long empresaId) {

		Optional<Empresa> empresa = empresaRepositorio.findById(empresaId);
		
		if (empresa.isPresent()) {
			return ResponseEntity.ok(empresa.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Empresa adicionar(@RequestBody Empresa empresa) {
		return cadastroEmpresaServico.salvar(empresa);
	}
	
	@PutMapping("/{lojaId}")
	public ResponseEntity<Empresa> atualizar(@PathVariable Long empresaId,
                                          @RequestBody Empresa empresa) {
		
		if (!empresaRepositorio.existsById(empresaId)) {
			return ResponseEntity.notFound().build();
		}
		
		empresa.setId(empresaId);
		empresa = cadastroEmpresaServico.salvar(empresa);
		
		return ResponseEntity.ok(empresa);
	}
	
	@DeleteMapping("/{lojaId}")
	public ResponseEntity<Void> remover(@PathVariable Long empresaId) {

		if (!empresaRepositorio.existsById(empresaId)) {
			return ResponseEntity.notFound().build();
		}
		
		cadastroEmpresaServico.excluir(empresaId);
		
		return ResponseEntity.noContent().build();
	}
}
