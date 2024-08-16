package com.iftm.gerenciadorhospital;

public class Medico extends Pessoa {
    private int idMedico;
    private String crm;
    private String especialidades;

    public Medico(String nome, String cpf, String endereco, String dataNascimento, String email, String telefone, int idMedico, String crm, String especialidades) {
        super(nome, cpf, endereco, dataNascimento, email, telefone);
        this.idMedico = idMedico;
        this.crm = crm;
        this.especialidades = especialidades;
    }
    
    public Medico(){}

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }
    
    
}
