package Entidades;

public class Prontuario {
    private int idProntuario;
    private Paciente paciente;
    private String tipoSanguineo;
    private char sexo;
    private String profissao;
    private String alergias;
    private String doencas;
    private String medContinuo;
    private String cirPrevia;

    public Prontuario(Paciente paciente, String tipoSanguineo, char sexo, String profissao, String alergias, String doencas, String medContinuo, String cirPrevia) {
        this.paciente = paciente;
        this.tipoSanguineo = tipoSanguineo;
        this.sexo = sexo;
        this.profissao = profissao;
        this.alergias = alergias;
        this.doencas = doencas;
        this.medContinuo = medContinuo;
        this.cirPrevia = cirPrevia;
    }

    public Prontuario(){
        this.paciente = new Paciente();
    }
    
    public int getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(int idProntuario) {
        this.idProntuario = idProntuario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }

    public String getMedContinuo() {
        return medContinuo;
    }

    public void setMedContinuo(String medContinuo) {
        this.medContinuo = medContinuo;
    }

    public String getCirPrevia() {
        return cirPrevia;
    }

    public void setCirPrevia(String cirPrevia) {
        this.cirPrevia = cirPrevia;
    }
        
}
