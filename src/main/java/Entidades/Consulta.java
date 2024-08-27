package Entidades;

import DAOs.ConsultaDAO;
import java.util.List;
import java.util.Scanner;

public class Consulta {
    private int idConsulta;
    private Paciente paciente;
    private Medico medico;
    private String dataEhora;
    private String diagnostico;

    public Consulta(Paciente paciente, Medico medico, String dataEhora) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataEhora = dataEhora;
    }
    
    public Consulta(){
        this.paciente = new Paciente();
        this.medico = new Medico();
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
    
    public static Consulta buscarConsulta(ConsultaDAO c1Dao, Scanner scan) { 
        boolean ver = false;
        Consulta consultaEncontrada = new Consulta();
       
        while(ver == false){
            System.out.println("Consultas cadastradas:");
            c1Dao.listar();
            System.out.println("Digite o ID da consulta:");
            int id = scan.nextInt();
            scan.nextLine();

            List<Consulta> consultas = c1Dao.getLista();


            for (Consulta c : consultas) {
                if (c.getIdConsulta() == id) {
                    consultaEncontrada = c;
                    ver = true;
                    break;
                }
            }
            if (ver == false) {
                System.out.println("Escolha um ID válido.");
            }
        }            
        return consultaEncontrada;
    }
}
