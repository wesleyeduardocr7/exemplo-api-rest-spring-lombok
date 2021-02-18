package br.com.wesleyti.lombokspringapirest.dominio;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="empresa")
@Data
@NoArgsConstructor
public class Empresa implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_empresa")
	private Long id;

	@Column(name = "nome_fantasia", length=100, nullable = false)
	private String nomeFantasia;

	@Column(name = "cnpj", length=30, nullable = false)
	private String cnpj;

	@Column(name = "endereco", length=100)
	private String endereco;
}