
package Entidades;

import DAOs.PrescricaoDAO;
import Entidades.Consulta;
import java.util.List;
import java.util.Scanner;

public class Prescricao {
    private int idPrescricao;
    private Consulta consulta;
    private String dataDeValidade;
    private int categoria;
    private String medicamentos;
    private String recomendacoes;

    public Prescricao(Consulta consulta, String dataDeValidade, int categoria, String medicamentos, String recomendacoes) {
        this.consulta = consulta;
        this.dataDeValidade = dataDeValidade;
        this.categoria = categoria;
        this.medicamentos = medicamentos;
        this.recomendacoes = recomendacoes;
    }

    public Prescricao(){
        this.consulta = new Consulta();
    }
    
    public int getIdPrescricao() {
        return idPrescricao;
    }

    public void setIdPrescricao(int idPrescricao) {
        this.idPrescricao = idPrescricao;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(String dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getRecomendacoes() {
        return recomendacoes;
    }

    public void setRecomendacoes(String recomendacoes) {
        this.recomendacoes = recomendacoes;
    }
    
    public static Prescricao buscarPrescricao(PrescricaoDAO presc1Dao, Scanner scan) {
        boolean ver = false;
        Prescricao prescricaoEncontrada = new Prescricao();
        
        while(ver == false){
            System.out.println("Prescrições cadastradas:");
            presc1Dao.listar();
            System.out.println("Digite o ID da prescrição:");
            int id = scan.nextInt();
            scan.nextLine();

            List<Prescricao> prescricoes = presc1Dao.getLista();


            for (Prescricao p : prescricoes) {
                if (p.getIdPrescricao() == id) {
                    prescricaoEncontrada = p;
                    ver = true;
                    break;
                }
            }
            if (ver == false) {
                System.out.println("Escolha um ID válido.");
            }
        }    
        return prescricaoEncontrada;
    }
}
