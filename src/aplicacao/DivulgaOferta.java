package aplicacao;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DivulgaOferta {

    /*Beatriz Garcia Roman           573765
     *Enzo Silva Espinoza            559076
     *Ísis D´Avila de Sousa Cará     565614
     *Lorena Silva Espinoza          566448
     *Maria Clara Magalhães Cervenka 562463*/

    public static void main(String[] args) {

        Scanner le = new Scanner(System.in);
        /*
        Instancia ABB cadastro e oferta de clientes.
        Instancia a filaOferta com implementação escolhida pelo grupo
         */

        int opcao, op;
        String nome, whatsapp, cpf;
        double totalGasto;
        boolean aptoLer = true;
        do {
            System.out.println(" 0 - Encerrar o programa");
            System.out.println(" 1 - Inscrição de clientes por leitura de arquivo");
            System.out.println(" 2 - Inscrição de um cliente");
            System.out.println(" 3 - Oferta de novo produto/promocacao");
            System.out.println(" 4 - Entrar no Submenu ");
            System.out.println(" 5 - Remove um cliente do cadastro");
            System.out.print("Opção: ");
            opcao = le.nextInt();
            switch (opcao) {
                case 0 -> {
                    System.out.println("\n\nClientes que nao aceitaram ou nao estavam adequados para a oferta");
                    /*
                     * Apresenta todos os clientes que nao aceitaram nenhuma oferta
                     * Para isso na classe AbbClientes deve haver um metodo para essa tarefa
                     */

                }
                case 1 -> {
                    if (aptoLer) {
                        //cadastrarBackupDeClientes(cadastro);
                        aptoLer = false;

                    } else {
                        System.out.println("Arquivo já cadastrado!");
                    }
                }
                case 2 -> {
                    System.out.print("Digite nome: ");
                    le.nextLine();
                    nome = le.nextLine();
                    System.out.print("Digite CPF: ");
                    cpf = le.next();
                    System.out.print("Whatsapp: ");
                    whatsapp = le.next();
                    System.out.print("Informe total gasto do cliente R$: ");
                    totalGasto = le.nextDouble();

                    /*
                     * Intancia um objeto da classe Cliente e insere na ABB de cadastro
                     */
                }
                case 3 -> {
                    System.out.print("Qual o valor de saldo mínimo exigido: R$ ");
                    totalGasto = le.nextDouble();

                    /*
                     * Percorrendo a ABB de cadastro gera ABB oferta usando como criterio de organizacao
                     * o total de gasto do cliente.
                     *
                     * Usando um metodo de percurso gerar uma fila de clientes para contactar via whatsapp,
                     * em ordem decrescentes de gastos (o primeiro cliente deve ser o com maior valor de gasto.
                     *
                     * Esvazia ABB oferta.
                     */



                    /*
                     * Nesse trecho de programa que eh simulada a tentativa de fazer o contato com cada um dos clientes
                     * presentes na fila. Ate nao ter mais clientes para contactar.
                     *
                     * Cada cliente que aceita a oferta tem o atributo apto para oferta alterado para false no seu cadastro
                     */

                }
                case 4 -> {
                    do {
                        System.out.println("\t 1) Consulta cliente buscando pelo CPF ");
                        System.out.println("\t 2) Apresenta o total de gasto de todos os clientes");
                        System.out.println("\t 3) Apresenta a quantidade de clientes com saldo acima de um valor a ser consultado");
                        System.out.println("\t 4) Volta menu principal");
                        op = le.nextInt();
                        switch (op) {
                            case 1:
                                System.out.print("Informe CPF para consulta");
                                cpf = le.next();

                                /*
                                Utilizando metodo de consulta definido na classe ABB procurar cliente por cpf
                                 */
                                break;
                            case 2:
                                /*
                                Utilizando metodo especifico da classe ABB calcula o total de gastos de todos os clientes
                                 */
                                break;
                            case 3:
                                /*
                                Utilizando metodo especifico da classe ABB obtém quantidade de clientes com gastos acima de
                                 */
                                break;
                            case 4:
                                System.out.println("Retornando Menu Principal");
                                break;
                            default:
                                System.out.println("Opção invalida");
                        }
                    } while (op != 4);
                }
                case 5 -> {
                    System.out.print("Informe CPF do cliente que deseja ser retirado do cadastro");
                    cpf = le.next();
                    /*
                    Remove da ABB de cadastro o cliente escolhido pelo CPF
                     */
                }
                default -> System.out.println("Opção inválida");
            }

        } while (opcao != 0);

        le.close();

    }

    public static void cadastrarBackupDeClientes(/*AbbCliente cadastro*/) {
        String caminhoDoArquivo = "src/arquivos/backupClientes.txt";

        try {
            // Criar um objeto File com o caminho do arquivo
            File arquivo = new File(caminhoDoArquivo);

            // Criar um Scanner para ler o arquivo
            Scanner leArq = new Scanner(arquivo);

            // Loop para ler linha por linha até o final do arquivo
            while (leArq.hasNextLine()) {
                // Ler a próxima linha
                String linha = leArq.nextLine();
                System.out.println("\n" + linha);
                String[] partes = linha.split(",");

                double totalGasto = Double.parseDouble(partes[3]);
                //Cliente cliente = new Cliente(partes[0], partes[1], partes[2], totalGasto);
                /*
                insere na Abb cadastro o cliente lido do arquivo
                 */
            }
            // Fechar o objeto da classe Scanner leArq
            leArq.close();
        } catch (FileNotFoundException e) {
            // Caso o arquivo não seja encontrado
            System.out.println("Arquivo nao encontrado: " + e.getMessage());
        }

    }

}
