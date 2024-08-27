package Geral;

import Entidades.Paciente;
import Entidades.Medico;
import Entidades.Consulta;
import Entidades.Prescricao;
import Entidades.Prontuario;
import DAOs.PacienteDAO;
import DAOs.MedicoDAO;
import DAOs.ConsultaDAO;
import DAOs.PrescricaoDAO;
import DAOs.ProntuarioDAO;
import Entidades.Pessoa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorHospital {

    public static void imprimirMenu() {
        System.out.println("Digite a opção desejada:");
        System.out.println("1 - Inserir");
        System.out.println("2 - Atualizar");
        System.out.println("3 - Deletar");
        System.out.println("4 - Listar");
        System.out.println("5 - Voltar ");
    }
    
    //Função para gerar pausa no programa
    public static void pausar(Scanner scan){
        System.out.println("Digite enter para continuar...");
        scan.nextLine();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int op, op2;
        do {
            System.out.println("-----MENU PRINCIPAL-----");
            System.out.println("1 - Médico");
            System.out.println("2 - Paciente");
            System.out.println("3 - Consulta");
            System.out.println("4 - Prescrição");
            System.out.println("5 - Prontuário");
            System.out.println("6 - Ver pessoas cadastradas");
            System.out.println("7 - Sair");
            System.out.println("Digite a opção desejada:");
            op = scan.nextInt();
            scan.nextLine();

            MedicoDAO m1Dao = new MedicoDAO();
            PacienteDAO p1Dao = new PacienteDAO();
            ConsultaDAO c1Dao = new ConsultaDAO();
            PrescricaoDAO presc1Dao = new PrescricaoDAO();
            ProntuarioDAO pront1Dao = new ProntuarioDAO();

            switch (op) {
                case 1: //Operações referentes ao Médico
                    imprimirMenu();
                    op2 = scan.nextInt();
                    scan.nextLine();
                    if (op2 == 1) {
                        System.out.println("Nome: ");
                        String nome = scan.nextLine();
                        System.out.println("CPF: ");
                        String cpf = scan.nextLine();
                        System.out.println("Endereço: ");
                        String endereco = scan.nextLine();
                        System.out.println("Data de nascimento: ");
                        String dataNasc = scan.nextLine();
                        System.out.println("Email: ");
                        String email = scan.nextLine();
                        System.out.println("Telefone:");
                        String telefone = scan.nextLine();
                        System.out.println("CRM: ");
                        String crm = scan.nextLine();
                        System.out.println("Especialidades:");
                        String especialidades = scan.nextLine();

                        Medico m1 = new Medico(nome, cpf, endereco, dataNasc, email, telefone, crm, especialidades);

                        m1Dao.adicionar(m1);
                        pausar(scan);

                    } else if (op2 == 2) {
                        int op3 = 1;
                        Medico medicoEncontrado = Medico.buscarMedico(m1Dao, scan);
                        while (op3 != 9) {
                            System.out.println("Digite o campo que você quer atualizar:");
                            System.out.println("1 - Nome");
                            System.out.println("2 - CPF");
                            System.out.println("3 - Endereço");
                            System.out.println("4 - Data de nascimento");
                            System.out.println("5 - Email");
                            System.out.println("6 - Telefone");
                            System.out.println("7 - CRM");
                            System.out.println("8 - Especialidades");
                            System.out.println("9 - Nenhum");
                            op3 = scan.nextInt();
                            scan.nextLine();

                            if (op3 != 9) {
                                System.out.println("Novo valor:");
                                switch (op3) {
                                    case 1:
                                        String nome = scan.nextLine();
                                        medicoEncontrado.setNome(nome);
                                        break;
                                    case 2:
                                        String cpf = scan.nextLine();
                                        medicoEncontrado.setCpf(cpf);
                                        break;
                                    case 3:
                                        String endereco = scan.nextLine();
                                        medicoEncontrado.setEndereco(endereco);
                                        break;
                                    case 4:
                                        String dataNasc = scan.nextLine();
                                        medicoEncontrado.setDataNascimento(dataNasc);
                                        break;
                                    case 5:
                                        String email = scan.nextLine();
                                        medicoEncontrado.setEmail(email);
                                        break;
                                    case 6:
                                        String telefone = scan.nextLine();
                                        medicoEncontrado.setTelefone(telefone);
                                        break;
                                    case 7:
                                        String crm = scan.nextLine();
                                        medicoEncontrado.setCrm(crm);
                                        break;
                                    case 8:
                                        String esp = scan.nextLine();
                                        medicoEncontrado.setEspecialidades(esp);
                                        break;

                                }
                                m1Dao.alterar(medicoEncontrado);
                                System.out.println("Campo atualizado com sucesso!");
                                pausar(scan);
                            }
                        }
                    } else if (op2 == 3) {
                        Medico medicoEncontrado = Medico.buscarMedico(m1Dao, scan);
                        m1Dao.remover(medicoEncontrado);
                        System.out.println("Médico removido com sucesso!");
                        pausar(scan);
                        
                    } else if (op2 == 4) {
                        m1Dao.listar();
                        pausar(scan);
                    }
                    break;
                case 2: //Operações referentes ao Paciente
                    imprimirMenu();
                    op2 = scan.nextInt();
                    scan.nextLine();

                    if (op2 == 1) {
                        System.out.println("Nome: ");
                        String nome = scan.nextLine();
                        System.out.println("CPF: ");
                        String cpf = scan.nextLine();
                        System.out.println("Endereço: ");
                        String endereco = scan.nextLine();
                        System.out.println("Data de nascimento: ");
                        String dataNasc = scan.nextLine();
                        System.out.println("Email: ");
                        String email = scan.nextLine();
                        System.out.println("Telefone:");
                        String telefone = scan.nextLine();

                        Paciente p1 = new Paciente(nome, cpf, endereco, dataNasc, email, telefone);

                        p1Dao.adicionar(p1);
                        pausar(scan);

                    } else if (op2 == 2) {
                        int op3 = 1;
                        Paciente pacienteEncontrado = Paciente.buscarPaciente(p1Dao, scan);
                        while (op3 != 7) {

                            System.out.println("Digite o campo que você quer atualizar:");
                            System.out.println("1 - Nome");
                            System.out.println("2 - CPF");
                            System.out.println("3 - Endereço");
                            System.out.println("4 - Data de nascimento");
                            System.out.println("5 - Email");
                            System.out.println("6 - Telefone");
                            System.out.println("7 - Nenhum");
                            op3 = scan.nextInt();
                            scan.nextLine();
                            if (op3 != 7) {
                                System.out.println("Novo valor:");
                                switch (op3) {
                                    case 1:
                                        String nome = scan.nextLine();
                                        pacienteEncontrado.setNome(nome);
                                        break;
                                    case 2:
                                        String cpf = scan.nextLine();
                                        pacienteEncontrado.setCpf(cpf);
                                        break;
                                    case 3:
                                        String endereco = scan.nextLine();
                                        pacienteEncontrado.setEndereco(endereco);
                                        break;
                                    case 4:
                                        String dataNasc = scan.nextLine();
                                        pacienteEncontrado.setDataNascimento(dataNasc);
                                        break;
                                    case 5:
                                        String email = scan.nextLine();
                                        pacienteEncontrado.setEmail(email);
                                        break;
                                    case 6:
                                        String telefone = scan.nextLine();
                                        pacienteEncontrado.setTelefone(telefone);
                                        break;
                                }
                                p1Dao.alterar(pacienteEncontrado);
                                System.out.println("Campo atualizado com sucesso!");
                                pausar(scan);
                            }
                        }

                    } else if (op2 == 3) {
                        Paciente pacienteEncontrado = Paciente.buscarPaciente(p1Dao, scan);
                        p1Dao.remover(pacienteEncontrado);
                        System.out.println("Paciente removido com sucesso!");
                        pausar(scan);

                    } else if (op2 == 4) {
                        p1Dao.listar();
                        pausar(scan);
                    }
                    break;
                case 3: //Operações referentes a Consulta
                    imprimirMenu();
                    op2 = scan.nextInt();
                    scan.nextLine();

                    if (op2 == 1) {
                        System.out.println("Escolha o paciente:");
                        Paciente pacienteEscolhido = Paciente.buscarPaciente(p1Dao, scan);

                        System.out.println("Escolha o médico:");
                        Medico medicoEscolhido = Medico.buscarMedico(m1Dao, scan);

                        System.out.println("Data e Hora: ");
                        String dataHora = scan.nextLine();

                        Consulta c1 = new Consulta(pacienteEscolhido, medicoEscolhido, dataHora);

                        c1Dao.adicionar(c1);
                        pausar(scan);

                    } else if (op2 == 2) {
                        int op3 = 1;
                        Consulta consultaEncontrada = Consulta.buscarConsulta(c1Dao, scan);
                            
                        while (op3 != 3) {
                            System.out.println("Digite o campo que você quer atualizar:");
                            System.out.println("1 - Data e Hora");
                            System.out.println("2 - Diagnóstico");
                            System.out.println("3 - Nenhum");
                            op3 = scan.nextInt();
                            scan.nextLine();

                            if (op3 != 3) {
                                System.out.println("Novo valor:");
                                switch (op3) {
                                    case 1:
                                        String dataHora = scan.nextLine();
                                        consultaEncontrada.setDataEhora(dataHora);
                                        break;
                                    case 2:
                                        String diag = scan.nextLine();
                                        consultaEncontrada.setDiagnostico(diag);
                                        break;
                                }
                                c1Dao.alterar(consultaEncontrada);
                                System.out.println("Campo atualizado com sucesso!");
                                pausar(scan);
                            }
                        }

                    } else if (op2 == 3) {
                        Consulta consultaEncontrada = Consulta.buscarConsulta(c1Dao, scan);
                        c1Dao.remover(consultaEncontrada);
                        System.out.println("Consulta removida com sucesso!");
                        pausar(scan);
                        
                    } else if (op2 == 4) {
                        c1Dao.listar();
                        pausar(scan);
                    }
                    break;
                case 4: //Operações referentes a Prescrição
                    imprimirMenu();
                    op2 = scan.nextInt();
                    scan.nextLine();

                    if (op2 == 1) {
                        System.out.println("Escolha o ID da consulta:");
                        Consulta consultaEscolhida = Consulta.buscarConsulta(c1Dao, scan);

                        System.out.println("Digite a data de validade da prescrição: ");
                        String dataDeValidade = scan.nextLine();

                        System.out.println("Digite a categoria da prescrição: ");
                        int categoria = scan.nextInt();
                        scan.nextLine();

                        System.out.println("Medicamentos sugeridos: ");
                        String medicamentos = scan.nextLine();

                        System.out.println("Recomendações: ");
                        String recomendacoes = scan.nextLine();

                        Prescricao presc1 = new Prescricao(consultaEscolhida, dataDeValidade, categoria, medicamentos, recomendacoes);

                        presc1Dao.adicionar(presc1);
                        pausar(scan);

                    } else if (op2 == 2) {
                        int op3 = 1;
                        Prescricao prescricaoEncontrada = Prescricao.buscarPrescricao(presc1Dao, scan);
                        while (op3 != 5) {

                            System.out.println("Digite o campo que você quer atualizar:");
                            System.out.println("1 - Data de validade");
                            System.out.println("2 - Categoria");
                            System.out.println("3 - Medicamentos");
                            System.out.println("4 - Recomendacoes");
                            System.out.println("5 - Nenhum");
                            op3 = scan.nextInt();
                            scan.nextLine();

                            if (op != 5) {
                                System.out.println("Novo valor:");
                                switch (op3) {
                                    case 1:
                                        String dataDeValidade = scan.nextLine();
                                        prescricaoEncontrada.setDataDeValidade(dataDeValidade);
                                        break;
                                    case 2:
                                        int categoria = scan.nextInt();
                                        prescricaoEncontrada.setCategoria(categoria);
                                        break;
                                    case 3:
                                        String medicamento = scan.nextLine();
                                        prescricaoEncontrada.setMedicamentos(medicamento);
                                        break;
                                    case 4:
                                        String recomendacoes = scan.nextLine();
                                        prescricaoEncontrada.setRecomendacoes(recomendacoes);
                                        break;
                                }
                                presc1Dao.alterar(prescricaoEncontrada);
                                System.out.println("Campo atualizado com sucesso!");
                                pausar(scan);
                            }
                        }

                    } else if (op2 == 3) {
                        Prescricao prescricaoEncontrada = Prescricao.buscarPrescricao(presc1Dao, scan);
                        presc1Dao.remover(prescricaoEncontrada);
                        System.out.println("Prescrição removida com sucesso!");
                        pausar(scan);
                        
                    } else if (op2 == 4) {
                        presc1Dao.listar();
                        pausar(scan);
                    }
                    break;
                case 5: //Operações referentes ao Prontuário
                    imprimirMenu();
                    op2 = scan.nextInt();
                    scan.nextLine();

                    if (op2 == 1) {
                        System.out.println("Escolha o paciente:");
                        Paciente pacienteEscolhido = Paciente.buscarPaciente(p1Dao, scan);

                        System.out.println("Tipo Sanguíneo: ");
                        String tipoSanguineo = scan.nextLine();

                        System.out.println("Sexo:  ");
                        char sexo = scan.next().charAt(0);
                        scan.nextLine();

                        System.out.println("Profissão:  ");
                        String profissao = scan.nextLine();

                        System.out.println("Alergias:  ");
                        String alergias = scan.nextLine();

                        System.out.println("Doenças:  ");
                        String doencas = scan.nextLine();

                        System.out.println("Medicamentos de uso contínuo:  ");
                        String medContinuo = scan.nextLine();

                        System.out.println("Crirurgias prévias:  ");
                        String cirurgias = scan.nextLine();

                        Prontuario pront1 = new Prontuario(pacienteEscolhido, tipoSanguineo, sexo, profissao, alergias, doencas, medContinuo, cirurgias);

                        pront1Dao.adicionar(pront1);
                        pausar(scan);

                    } else if (op2 == 2) {
                        int op3 = 1;
                        Prontuario prontuarioEncontrado = Prontuario.buscarProntuario(pront1Dao, scan);
                        while (op3 != 8) {
                            
                            System.out.println("Digite o campo que você quer atualizar:");
                            System.out.println("1 - Tipo Sanguíneo");
                            System.out.println("2 - Sexo");
                            System.out.println("3 - Profissão");
                            System.out.println("4 - Alergias");
                            System.out.println("5 - Doenças");
                            System.out.println("6 - Medicamentos de uso contínuo");
                            System.out.println("7 - Cirurgias prévias");
                            System.out.println("8 - Nenhum");
                            op3 = scan.nextInt();
                            scan.nextLine();

                            if (op3 != 8) {
                                System.out.println("Novo valor:");
                                switch (op3) {
                                    case 1:
                                        String tipoSanguineo = scan.nextLine();
                                        prontuarioEncontrado.setTipoSanguineo(tipoSanguineo);
                                        break;
                                    case 2:
                                        char sexo = scan.next().charAt(0);
                                        scan.nextLine();
                                        prontuarioEncontrado.setSexo(sexo);
                                        break;
                                    case 3:
                                        String profissao = scan.nextLine();
                                        prontuarioEncontrado.setProfissao(profissao);
                                        break;
                                    case 4:
                                        String alergias = scan.nextLine();
                                        prontuarioEncontrado.setAlergias(alergias);
                                        break;
                                    case 5:
                                        String doencas = scan.nextLine();
                                        prontuarioEncontrado.setDoencas(doencas);
                                        break;
                                    case 6:
                                        String medicamentos = scan.nextLine();
                                        prontuarioEncontrado.setMedContinuo(medicamentos);
                                        break;
                                    case 7:
                                        String cirurgias = scan.nextLine();
                                        prontuarioEncontrado.setCirPrevia(cirurgias);
                                        break;
                                }
                                pront1Dao.alterar(prontuarioEncontrado);
                                System.out.println("Campo atualizado com sucesso!");
                                pausar(scan);
                            }
                        }
                    } else if (op2 == 3) {
                        Prontuario prontuarioEncontrado = Prontuario.buscarProntuario(pront1Dao, scan);
                        pront1Dao.remover(prontuarioEncontrado);
                        System.out.println("Prontuário removido com sucesso!");
                        pausar(scan);
                        
                    } else if (op2 == 4) {
                        pront1Dao.listar();
                        pausar(scan);
                    }
                    break;
                case 6:
                    System.out.println("---CADASTROS---");
                    Pessoa.imprimePessoas();
                    pausar(scan);
                    break;
                case 7:
                    System.out.println("Programa Encerrado");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } while (op != 7);
    }
}
