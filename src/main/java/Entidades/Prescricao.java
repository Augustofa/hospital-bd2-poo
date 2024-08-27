
package Entidades;

import Entidades.Consulta;

public class Prescricao {
    private int idPrescricao;
    private Consulta consulta;
    private String dataDeValidade;
    private int categoria;
    private String medicamentos;
    private String recomendacoes;

    public Prescricao(Consulta consulta, String dataDeValidade, int categoria, String medicamentos, String recomendacoes) {
        this.idPrescricao = idPrescricao;
        this.consulta = consulta;
        this.dataDeValidade = dataDeValidade;
        this.categoria = categoria;
        this.medicamentos = medicamentos;
        this.recomendacoes = recomendacoes;
    }

    public Prescricao(){}
    
    public int getIdPrescricao() {
        return idPrescricao;
    }

    public void setIdPrescricao(int idPrescricao) {
        this.idPrescricao = idPrescricao;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(String dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getRecomendacoes() {
        return recomendacoes;
    }

    public void setRecomendacoes(String recomendacoes) {
        this.recomendacoes = recomendacoes;
    }
    
    
}
