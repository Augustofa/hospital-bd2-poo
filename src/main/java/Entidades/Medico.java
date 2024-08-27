package Entidades;

import DAOs.MedicoDAO;
import java.util.List;
import java.util.Scanner;

public class Medico extends Pessoa {
    private int idMedico;
    private String crm;
    private String especialidades;

    public Medico(String nome, String cpf, String endereco, String dataNascimento, String email, String telefone, String crm, String especialidades) {
        super(nome, cpf, endereco, dataNascimento, email, telefone);
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
    
    //Funções para realizar buscas
    public static Medico buscarMedico(MedicoDAO m1Dao, Scanner scan) {
        boolean ver = false;
        Medico medicoEncontrado = new Medico();
        while (ver == false) {
            System.out.println("Médicos cadastrados:");
            m1Dao.listar();
            System.out.println("Digite o ID do médico:");
            int id = scan.nextInt();
            scan.nextLine();

            List<Medico> medicos = m1Dao.getLista();

            for (Medico m : medicos) {
                if (m.getIdMedico() == id) {
                    medicoEncontrado = m;
                    ver = true;
                    break;
                }
            }
            if (ver == false) {
                System.out.println("Escolha um ID válido.");
            }
        }
        return medicoEncontrado;
    }
}
