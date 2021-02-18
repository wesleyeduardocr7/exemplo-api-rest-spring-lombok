package br.com.wesleyti.lombokspringapirest.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class EmpregadoDTO implements Serializable {

    private Long idEmpresa;
    private String nomeEmpresa;
    private Long idColaborador;
    private String nomeColaborador;
    private BigDecimal salarioColaborador;
}
