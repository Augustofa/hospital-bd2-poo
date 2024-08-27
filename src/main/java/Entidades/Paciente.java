package Entidades;

public class Paciente extends Pessoa {
    private int idPaciente;

    public Paciente(String nome, String cpf, String endereco, String dataNascimento, String email, String telefone) {
        super(nome, cpf, endereco, dataNascimento, email, telefone);
        this.idPaciente = idPaciente;
    }
    
    public Paciente(){}
    
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    
}
