package br.com.wesleyti.lombokspringapirest.dominio;

public enum TipoColaborador {

    CLT(0, "CLT"),
    PJ(1, "PJ");

    private int codigo;
    private String descricao;

    private TipoColaborador(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String toString(){
        return descricao;
    }

    public static TipoColaborador valueOfCodigo(Integer codigo) {
        if (codigo == null) {
            return null;
        }
        for (TipoColaborador tipoColaborador : TipoColaborador.values()) {
            if (tipoColaborador.getCodigo() == codigo) {
                return tipoColaborador;
            }
        }
        return null;
    }
}
