package backend;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;  // Variável de controle do loop

        // Inicializar o cadastro sem o tipo de instituição
        CadastroDeInstituicao<Instituicao> cadastro = new CadastroDeInstituicao<>();

        while (continuar) {
            // Exibir opções de menu
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar instituição");
            System.out.println("2. Listar todas as instituições");
            System.out.println("3. Buscar instituição por CNPJ");
            System.out.println("4. Atualizar instituição");
            System.out.println("5. Remover instituição");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    // Adicionar instituição
                    try {
                        System.out.print("Digite o nome da instituição: ");
                        String nome = scanner.nextLine();

                        System.out.print("Digite o CNPJ da instituição (somente números): ");
                        String cnpj = scanner.nextLine();

                        System.out.print("Digite o tempo do projeto da instituição: ");
                        String tempoDoProjeto = scanner.nextLine();

                        System.out.print("Digite o telefone da instituição: ");
                        int telefone = Integer.parseInt(scanner.nextLine());

                        System.out.print("Digite o celular da instituição: ");
                        int celular = Integer.parseInt(scanner.nextLine());

                        System.out.print("Digite o CEP da instituição: ");
                        int cep = Integer.parseInt(scanner.nextLine());

                        System.out.print("Digite o número da casa da instituição: ");
                        int numeroCasa = Integer.parseInt(scanner.nextLine());

                        System.out.print("Digite o estado da instituição: ");
                        String estado = scanner.nextLine();

                        System.out.print("Digite a rua da instituição: ");
                        String rua = scanner.nextLine();

                        System.out.print("Digite o bairro da instituição: ");
                        String bairro = scanner.nextLine();

                        System.out.print("Digite a cidade da instituição: ");
                        String cidade = scanner.nextLine();

                        System.out.print("Digite a descrição da instituição: ");
                        String descricao = scanner.nextLine();

                        System.out.print("Digite o complemento do endereço da instituição: ");
                        String complementoEndereco = scanner.nextLine();

                        System.out.print("Digite as necessidades da instituição: ");
                        String precisoDe = scanner.nextLine();

                        Instituicao instituicao = new Instituicao(nome, cnpj, tempoDoProjeto, telefone, celular, cep, numeroCasa,
                                                                  estado, bairro, rua, cidade, descricao, complementoEndereco, precisoDe);
                        cadastro.adicionarInstituicao(instituicao); // Corrigido para usar a instância `cadastro`
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: Entrada inválida. Certifique-se de que telefone, celular, CEP e número da casa são números inteiros.");
                    }
                    break;

                case 2:
                    // Listar todas as instituições
                    System.out.println("Lista de instituições cadastradas:");
                    for (Instituicao inst : cadastro.listaInstituicoes()) {
                        System.out.println("Nome: " + inst.getNome() + ", CNPJ: " + inst.getCNPJ());
                    }
                    break;

                case 3:
                    // Buscar instituição por CNPJ
                    System.out.print("Digite o CNPJ da instituição que deseja buscar: ");
                    String cnpjBusca = scanner.nextLine();
                    Instituicao encontrada = cadastro.buscarInstituicaoPorCNPJ(cnpjBusca);
                    if (encontrada != null) {
                        System.out.println("Instituição encontrada: " + encontrada.getNome());
                    } else {
                        System.out.println("Instituição não encontrada.");
                    }
                    break;

                case 4:
                    // Atualizar instituição
                    System.out.print("Digite o CNPJ da instituição que deseja atualizar: ");
                    String cnpjAtualizar = scanner.nextLine();

                    System.out.print("Digite o novo nome da instituição: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Digite o novo tempo do projeto da instituição: ");
                    String novoTempoDoProjeto = scanner.nextLine();

                    System.out.print("Digite o novo telefone da instituição: ");
                    int novoTelefone = Integer.parseInt(scanner.nextLine());

                    System.out.print("Digite o novo celular da instituição: ");
                    int novoCelular = Integer.parseInt(scanner.nextLine());

                    System.out.print("Digite o novo CEP da instituição: ");
                    int novoCep = Integer.parseInt(scanner.nextLine());

                    System.out.print("Digite o novo número da casa da instituição: ");
                    int novoNumeroCasa = Integer.parseInt(scanner.nextLine());

                    System.out.print("Digite o novo estado da instituição: ");
                    String novoEstado = scanner.nextLine();

                    System.out.print("Digite a nova rua da instituição: ");
                    String novaRua = scanner.nextLine();

                    System.out.print("Digite o novo bairro da instituição: ");
                    String novoBairro = scanner.nextLine();

                    System.out.print("Digite a nova cidade da instituição: ");
                    String novaCidade = scanner.nextLine();

                    System.out.print("Digite a nova descrição da instituição: ");
                    String novaDescricao = scanner.nextLine();

                    System.out.print("Digite o novo complemento do endereço da instituição: ");
                    String novoComplementoEndereco = scanner.nextLine();

                    System.out.print("Digite as novas necessidades da instituição: ");
                    String novoPrecisoDe = scanner.nextLine();

                    Instituicao novaInstituicao = new Instituicao(novoNome, cnpjAtualizar, novoTempoDoProjeto, novoTelefone,
                            novoCelular, novoCep, novoNumeroCasa, novoEstado, novoBairro, novaRua, novaCidade,
                            novaDescricao, novoComplementoEndereco, novoPrecisoDe);

                    if (cadastro.atualizarInstituicao(cnpjAtualizar, novaInstituicao)) {
                        System.out.println("Instituição atualizada com sucesso.");
                    } else {
                        System.out.println("Falha ao atualizar a instituição.");
                    }
                    break;

                case 5:
                    // Remover instituição
                    System.out.print("Digite o CNPJ da instituição que deseja remover: ");
                    String cnpjRemover = scanner.nextLine();
                    if (cadastro.removerInstituicao(cnpjRemover)) {
                        System.out.println("Instituição removida com sucesso.");
                    } else {
                        System.out.println("Instituição não encontrada.");
                    }
                    break;

                case 6:
                    // Sair
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }
}
