package br.com.wesleyti.lombokspringapirest.dominio;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="colaborador")
@Data
@NoArgsConstructor
public class Colaborador implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", length=100, nullable = false)
	private String nome;

	@Column(name = "matricula", length=30, nullable = false)
	private String matricula;

	@Column(name = "salario", scale = 6)
	private BigDecimal salario;

	@Column(name = "tipo_colaborador")
	private TipoColaborador tipoColaborador;

	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;
}