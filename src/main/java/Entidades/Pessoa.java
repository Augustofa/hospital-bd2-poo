package Entidades;

import DAOs.MedicoDAO;
import DAOs.PacienteDAO;
import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String endereco;
    private String dataNascimento;
    private String email;
    private String telefone;

    public Pessoa(String nome, String cpf, String endereco, String dataNascimento, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
    }
    
    public Pessoa(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void imprimirDados(){
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Data de nascimento: " + this.dataNascimento);
        System.out.println("Email: " + this.email);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("");
    }
    
    public static List<Pessoa> getListaPessoas(){
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        
        MedicoDAO mDao = new MedicoDAO();
        List<Medico> medicos = mDao.getLista();
        for(Medico m : medicos){
            pessoas.add(m);
        }
        
        PacienteDAO pDao = new PacienteDAO();
        List<Paciente> pacientes = pDao.getLista();
        for(Paciente p : pacientes){
            pessoas.add(p);
        }
                
        return pessoas;
    }
    
    public static void imprimePessoas(){
        List<Pessoa> pessoas = getListaPessoas();
        for(Pessoa p : pessoas){
            p.imprimirDados();
        }
    }
}
