package Entidades;

import DAOs.PacienteDAO;
import java.util.List;
import java.util.Scanner;

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
    
    public static Paciente buscarPaciente(PacienteDAO p1Dao, Scanner scan) {
        boolean ver = false;
        Paciente pacienteEncontrado = new Paciente();
        while(ver == false){
            System.out.println("Pacientes cadastrados:");
            p1Dao.listar();
            System.out.println("Digite o ID do paciente:");
            int id = scan.nextInt();
            scan.nextLine();

            List<Paciente> pacientes = p1Dao.getLista();

            for (Paciente p : pacientes) {
                if (p.getIdPaciente() == id) {
                    pacienteEncontrado = p;
                    ver = true;
                    break;
                }
            }
            if (ver == false) {
                System.out.println("Escolha um ID válido.");
            }
        }
        return pacienteEncontrado;
    }
    
}
