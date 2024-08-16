
package com.iftm.gerenciadorhospital;

public class Consulta {
    private int idConsulta;
    private Paciente paciente;
    private Medico medico;
    private String dataEhora;
    private String diagnostico;

    public Consulta(int idConsulta, Paciente paciente, Medico medico, String dataEhora, String diagnostico) {
        this.idConsulta = idConsulta;
        this.paciente = paciente;
        this.medico = medico;
        this.dataEhora = dataEhora;
        this.diagnostico = diagnostico;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getDataEhora() {
        return dataEhora;
    }

    public void setDataEhora(String dataEhora) {
        this.dataEhora = dataEhora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    
    
    
}
