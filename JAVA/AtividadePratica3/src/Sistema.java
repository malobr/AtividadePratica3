//import do scanner...
import java.util.Scanner;


//import do pacote individuos que abriga a classe funcionario e suas subclasses...
import Individuos.Funcionario;
import Individuos.Gerente;
import Individuos.Desenvolvedor;
import Individuos.Estagiario;

//import do pacote trabalhavel que abriga a interface de mesmo nome...
import Trabalhavel.Trabalhavel;

public class Sistema {
    private static Scanner scanner = new Scanner(System.in);

    private static void exibirMenu() {
        
        menu();

        System.out.println("\n");
        System.out.println("[1] Cadastrar Funcionario");
        System.out.println("[2] Remover Funcionario");
        System.out.println("[3] Exibir Funcionario");
        System.out.println("|0| Sair...");
        System.out.print("\nInforme uma opção: ");
    }
    
    private static void verificarOpcao(int op) {
        switch (op) {
            case 1: // Cadastrar Funcionario
            cadastrarNovoFuncionario();
                break;
            case 2: // Remover Funcionario
                removerFuncionario();
                break;
            case 3: // Exibir Funcionario
                exibirFuncionario();
                break;
            case 0: // Sair
                mensagemDeSaida();
                break;
            default:
                System.out.println("\nOpção inválida.... Digite novamente...");
                break;
        }
    }

    /*--------------CASE 1------------- */
    private static void cadastrarNovoFuncionario() {
        System.out.println("Qual tipo de funcionário deseja cadastrar?");
        System.out.println("[1] Gerente");
        System.out.println("[2] Desenvolvedor");
        System.out.println("[3] Estagiario");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner
    
        switch (tipo) {
            case 1:
                System.out.println("Informe o nome do gerente:");
                String nomeGerente = scanner.nextLine();
    
                System.out.println("Informe a matrícula do gerente:");
                String matriculaGerente = scanner.nextLine();
    
                System.out.println("Informe a equipe sob gerência do gerente:");
                String equipeGerencia = scanner.nextLine();
    
                System.out.println("Informe o bônus do gerente:");
                float bonusGerente = scanner.nextFloat();
                scanner.nextLine(); // Limpa o buffer do scanner

                System.out.println("Informe o salário do gerente:");
                float salarioGerente = scanner.nextFloat();
                scanner.nextLine(); // Limpa o buffer do scanner
                
                // Criando o objeto gerente
                Gerente gerente = new Gerente(nomeGerente, matriculaGerente, salarioGerente, equipeGerencia, bonusGerente);
                Cadastro.cadastrar(gerente);
                break;
            case 2:
                System.out.println("Informe o nome do desenvolvedor:");
                String nomeDesenvolvedor = scanner.nextLine();
    
                System.out.println("Informe a matrícula do desenvolvedor:");
                String matriculaDesenvolvedor = scanner.nextLine();
    
                System.out.println("Informe as linguagens do desenvolvedor:");
                String linguagensDesenvolvedor = scanner.nextLine();

                System.out.println("Informe o numero de projetos em andamento:");
                int projetosDesenvolvedor = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Informe o salário do desenvolvedor:");
                float salarioDesenvolvedor = scanner.nextFloat();
                scanner.nextLine(); // Limpa o buffer do scanner
                    
                // Criando o objeto desenvolvedor
                Desenvolvedor desenvolvedor = new Desenvolvedor(nomeDesenvolvedor, matriculaDesenvolvedor, salarioDesenvolvedor, linguagensDesenvolvedor, projetosDesenvolvedor);
                Cadastro.cadastrar(desenvolvedor);
                break;
            case 3:
                System.out.println("Informe o nome do estagiário:");
                String nomeEstagiario = scanner.nextLine();
    
                System.out.println("Informe a matrícula do estagiário:");
                String matriculaEstagiario = scanner.nextLine();
    
                System.out.println("Informe as horas de trabalho do estagiário:");
                float horasTrabalhoEstagiario = scanner.nextFloat();
                scanner.nextLine(); // Limpa o buffer do scanner
                
                System.out.println("Informe o nome do supervisor do estagiário:");
                String nomeSupervisorEstagiario = scanner.nextLine();

                System.out.println("Informe o salário do estagiário:");
                float salarioEstagiario = scanner.nextFloat();
                scanner.nextLine(); // Limpa o buffer do scanner
    
                    
                // Criando o objeto estagiário
                Estagiario estagiario = new Estagiario(nomeEstagiario, matriculaEstagiario, salarioEstagiario, horasTrabalhoEstagiario, nomeSupervisorEstagiario);
                Cadastro.cadastrar(estagiario);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    
        System.out.println("\nFuncionário cadastrado com sucesso!");
        enterParaSeguir();
    }
    

        /*--------------CASE 2------------- */
    private static void removerFuncionario(){
        System.out.println("Informe a Matricula do funcionario a ser excluído:");
        String matricula = scanner.nextLine();
        for (Funcionario funcionario : Cadastro.getListaFuncionarios()) {
            if (funcionario.getMatricula().equals(matricula)) {
                Cadastro.getListaFuncionarios().remove(funcionario);
                System.out.println("Funcionario excluído com sucesso!");
                enterParaSeguir();
                return;
            }
        }
        System.out.println("Funcionario não encontrado.");
    }


    /*--------------CASE 3------------- */
    private static void exibirFuncionario() {
        System.out.println("Informe a matrícula do funcionário:");
        String matricula = scanner.nextLine();
        
        for (Funcionario funcionario : Cadastro.getListaFuncionarios()) {
            if (funcionario.getMatricula().equals(matricula)) {
                System.out.println("Funcionário encontrado:");
                System.out.println(funcionario.toString());
    
                //imprime os metodos da interface Trabalhavel...
                if (funcionario instanceof Trabalhavel) {
                    Trabalhavel trabalhavel = (Trabalhavel) funcionario;

                    System.out.println("\nTrabalhando: " + trabalhavel.trabalhar());
                    System.out.println("Progresso: " + trabalhavel.relatarProgresso());

                    //imprime o salario de cada funcionario respectivamente..
                    float salario = funcionario.calcularSalario();
                    System.out.println("Salário: " + salario);               
                } 
                enterParaSeguir();
                return;
            }
        }
        
        System.out.println("Funcionário não encontrado.");
    }
    
    
    
    public static void enterParaSeguir() {
        System.out.println("\nClique em qualquer tecla para continuar");
        scanner.nextLine();
    }
    


    /*-----DESENHOS-----*/
    private static void mensagemDeSaida(){
        System.out.println("\nO programa foi finalizado...");
        System.out.println("\n");
        System.out.println("─▄▀─▄▀         JJJJJJJ     AAAAA     V       V      AAAAA       ─▄▀─▄▀    ");
        System.out.println("──▀──▀             J      A     A     V     V      A     A      ──▀──▀    ");
        System.out.println("█▀▀▀▀▀█▄           J      AAAAAAA      V   V       AAAAAAA      █▀▀▀▀▀█▄  ");
        System.out.println("█░░░░░█─█    J     J      A     A       V V        A     A      █░░░░░█─█ ");
        System.out.println("▀▄▄▄▄▄▀▀      JJJJJ       A     A        V         A     A      ▀▄▄▄▄▄▀▀  ");
        System.out.println("");
        System.out.println("──────▄▀▄─────▄▀▄");
        System.out.println("─────▄█░░▀▀▀▀▀░░█▄");
        System.out.println("─▄▄──█░░░░░░░░░░░█──▄▄");
        System.out.println("█▄▄█─█░░▀░░┬░░▀░░█─█▄▄█");
        System.out.println("-------------------------");
        
        }



private static void menu(){

    System.out.println("░░░░░░░░░░░░░░░░░░░░░▄▀░░▌");
    System.out.println("░░░░░░░░░░░░░░░░░░░▄▀▐░░░▌");
    System.out.println("░░░░░░░░░░░░░░░░▄▀▀▒▐▒░░░▌");
    System.out.println("░░░░░▄▀▀▄░░░▄▄▀▀▒▒▒▒▌▒▒░░▌");
    System.out.println("░░░░▐▒░░░▀▄▀▒▒▒▒▒▒▒▒▒▒▒▒▒█");
    System.out.println("░░░░▌▒░░░░▒▀▄▒▒▒▒▒▒▒▒▒▒▒▒▒▀▄");
    System.out.println("░░░░▐▒░░░░░▒▒▒▒▒▒▒▒▒▌▒▐▒▒▒▒▒▀▄");
    System.out.println("░░░░▌▀▄░░▒▒▒▒▒▒▒▒▐▒▒▒▌▒▌▒▄▄▒▒▐");
    System.out.println("░░░▌▌▒▒▀▒▒▒▒▒▒▒▒▒▒▐▒▒▒▒▒█▄█▌▒▒▌");
    System.out.println("░▄▀▒▐▒▒▒▒▒▒▒▒▒▒▒▄▀█▌▒▒▒▒▒▀▀▒▒▐░░░▄");
    System.out.println("▀▒▒▒▒▌▒▒▒▒▒▒▒▄▒▐███▌▄▒▒▒▒▒▒▒▄▀▀▀▀");
    System.out.println("▒▒▒▒▒▐▒▒▒▒▒▄▀▒▒▒▀▀▀▒▒▒▒▄█▀░░▒▌▀▀▄▄");
    System.out.println("▒▒▒▒▒▒█▒▄▄▀▒▒▒▒▒▒▒▒▒▒▒░░▐▒▀▄▀▄░░░░▀");
    System.out.println("▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▄▒▒▒▒▄▀▒▒▒▌░░▀▄");
    System.out.println("▒▒▒▒▒▒▒▒▀▄▒▒▒▒▒▒▒▒▀▀▀▀▒▒▒▄▀");
    System.out.println("--CADASTRO DE FUNCIONARIOS--");

}    










    //Metodo que e chamado na main para executar o programa...
    public static void executar() {
        int op;
        do {
            exibirMenu();
            op = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner
            verificarOpcao(op);
        } while (op != 0);
    }
}



