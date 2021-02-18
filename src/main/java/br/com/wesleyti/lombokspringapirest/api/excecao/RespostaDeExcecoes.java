package br.com.wesleyti.lombokspringapirest.api.excecao;
import java.io.Serializable;
import java.util.Date;

public class RespostaDeExcecoes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private String mensagem;
	private String detalhes;

	public RespostaDeExcecoes(Date timestamp, String mensagem, String detalhes) {
		this.timestamp = timestamp;
		this.mensagem = mensagem;
		this.detalhes = detalhes;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getDetalhes() {
		return detalhes;
	}
}
