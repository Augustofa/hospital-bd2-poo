package com.iftm.gerenciadorhospital;

import Entidades.Paciente;
import Entidades.Medico;
import Entidades.Consulta;
import DAOs.PacienteDAO;
import DAOs.MedicoDAO;
import DAOs.ConsultaDAO;

public class GerenciadorHospital {

    public static void main(String[] args) {
      
        
        // Monta objeto para ser gravado no banco de dados
        Paciente p1 = new Paciente();
        p1.setIdPaciente(8);
        p1.setNome("Lua de Cristal");
        p1.setCpf("111.222.333.44");
        p1.setEndereco("Rua 1, 515");
        p1.setDataNascimento("2024-08-15");
        p1.setEmail("luadecristal@gmail.com");
        p1.setTelefone("3831-3831");
        
        Medico m1 = new Medico();
        m1.setIdMedico(4);
        m1.setCpf("150.160.170-80");
        m1.setNome("Joao Paulo Bernardes");
        m1.setCrm("441566/MG");
        m1.setEndereco("Av. Sete de Setembro, 415");
        m1.setDataNascimento("1980-11-11");
        m1.setEmail("drjoao.bernardes@gmail.com");
        m1.setTelefone("3831-4515");
        m1.setEspecialidades("Psiquiatria");
        
        
        Consulta c1 = new Consulta();
        c1.setPaciente(p1);
        c1.setMedico(m1);
        c1.setDataEhora("2024-10-08 16:00:00");
        c1.setDiagnostico("Paciente relata escutar vozes quando sozinho.");
        
        //Modelo de Contato para ações no DB
        PacienteDAO pdao = new PacienteDAO();
        MedicoDAO mdao = new MedicoDAO();
        
        // Chama o método adicionar e passa o objeto como atributo
        pdao.adicionar(p1);
        mdao.adicionar(m1);
        ConsultaDAO consDao = new ConsultaDAO();
        
        consDao.adicionar(c1);
        
        consDao.listar();
       /* // Lista dos dados do banco DB
        pdao.listar();
        
        // Editar registro (Informar o ID do objeto que será editado)
        Contato c2 = new Contato((long)2, "Dênis", "denis@live.com", "Rua 5, 645");
        
        // Chama o método alterar e passa o objeto como atributo
        dao.alterar(c2);
        
        // Lista dos dados do banco DB
        dao.listar();
        
        // Editar registro (Informar o ID do objeto que será editado)
        Contato c3 = new Contato((long)3);
        
        // Chama o método alterar e passa o objeto como atributo
        dao.remover(c3);
        
        // Lista dos dados do banco DB
        dao.listar();
        
    }*/
    }
}
