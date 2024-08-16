package com.iftm.gerenciadorhospital;

public class GerenciadorHospital {

    public static void main(String[] args) {
        Medico m = new Medico();
        m.setNome("Andreia");
        m.setCpf("123.456");
        m.setEndereco("Lalala");
        m.setDataNascimento("2024-05-06");
        m.setCrm("12355363");
        m.setTelefone("1526267722");
        m.setEmail("andreia@gmail.com");
        
        MedicoDAO mDAO = new MedicoDAO();
        
        mDAO.adicionar(m);
        mDAO.listar();
    }
}
