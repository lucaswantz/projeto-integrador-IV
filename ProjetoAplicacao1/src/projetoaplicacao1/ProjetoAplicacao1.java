/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetoaplicacao1;

/**
 *
 * @author Monica Bohrer
 */
public class ProjetoAplicacao1 {

    // Isso é uma constante
    static final int LINHAS = 5;

    static String[][] clientes = new String[LINHAS][3]; // matriz de clientes linha e coluna
    static String[] tipoObjeto = new String[LINHAS];
    static String[][] objetos = new String[LINHAS][2];
    static String[] manutencoes = new String[LINHAS];

    public static void main(String[] args) {
        inicializaVetores();
        menu();
    }

    static void inicializaVetores() {
        inicializarVetor(tipoObjeto);
        inicializarVetor(manutencoes);
        inicializarMatriz(clientes);
        inicializarMatriz(objetos);
    }

    static void inicializarVetor(String vetor[]) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = "";
        }
    }

    static void inicializarMatriz(String matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = "";
            }
        }
    }

    static int verificaPosicaoLivreNoVetor(String vetor[]) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equals("")) {
                return i;
            }
        }

        return -1;
    }

    static int verificaPosicaoLivreNaMatriz(String matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0].equals("")) {
                return i;
            }
        }

        return -1;
    }

    static void menu() {
        int opcao;

        do {
            opcao = receberOpcaoMenuPrincipal();

            switch (opcao) {
                case 0:
                    System.out.println("\nSair\n");
                    break;

                case 1:
                    cadastroClientes();
                    break;

                case 2:
                    cadastroTipoObjeto();
                    break;

                case 3:
                    cadastroObjetos();
                    break;

                case 4:
                    cadastroManutencoes();
                    break;

                default:
                    System.out.println("\nOpção Inválida");
                    break;
            }

        } while (opcao != 0);
    }

    static int receberOpcaoMenuPrincipal() {
        System.out.println("\n\n###-------SISTEMA DE EMPRÉSTIMOS DE OBJETOS------###\n");
        System.out.println("                  ============================================");
        System.out.println("                  |     1 - Cadastro de Clientes             |");
        System.out.println("                  |     2 - Cadastro de Tipos de Objetos     |");
        System.out.println("                  |     3 - Cadastro de Objetos              |");
        System.out.println("                  |     4 - Cadastro de Manutenções          |");
        System.out.println("                  |     0 - Sair                             |");
        System.out.println("                  ============================================\n");

        int opcaoSelecionada = Entrada.leiaInt("Opção -> ");
        System.out.print("\n");

        return opcaoSelecionada;
    }

    static int receberOpcaoMenuSecundario(String tituloMenu) {
        System.out.println("\n" + tituloMenu);
        System.out.println("\n");
        System.out.println(" 1 - Cadastrar");
        System.out.println(" 2 - Alterar");
        System.out.println(" 3 - Excluir");
        System.out.println(" 4 - Listar");
        System.out.println(" 0 - Sair");
        System.out.println("\n");

        int opcaoSelecionada = Entrada.leiaInt("Operação -> ");
        System.out.print("\n");

        imprimirOpcaoSelecionada(opcaoSelecionada);

        return opcaoSelecionada;
    }

    static void imprimirOpcaoSelecionada(int opcaoSelecionada) {
        switch (opcaoSelecionada) {
            case 0:
                System.out.println("\nSair\n");
                break;

            case 1:
                System.out.println("\nCadastro");
                System.out.println("******************");
                break;

            case 2:
                System.out.println("\nAlterar");
                System.out.println("******************");
                break;

            case 3:
                System.out.println("\nExcluir");
                System.out.println("******************");
                break;

            case 4:
                System.out.println("\nSair\n");
                break;

            default:
                System.out.println("\nOpção Inválida!\n");
                break;
        }
    }

    static void cadastroObjetos() {
        int opcaoSelecionada;
        int linha;

        do {
            opcaoSelecionada = receberOpcaoMenuSecundario("Cadastro de Objetos");

            switch (opcaoSelecionada) {
                case 1:
                    linha = verificaPosicaoLivreNaMatriz(objetos);
                    if (linha == -1) {
                        System.out.println("** Não há posições livres na matriz de objetos **");
                        break;
                    }

                    objetos[linha][0] = Entrada.leiaString("Nome do objeto -> ");
                    objetos[linha][1] = Entrada.leiaString("Cod. Objeto -> ");
                    System.out.println("=> Objeto cadastrado com sucesso! <=");
                    break;

                case 2:
                    listarObjetos();
                    linha = Entrada.leiaInt("Informe o código para ser alterado -> ");

                    objetos[linha][0] = Entrada.leiaString("Informe o novo nome para " + objetos[linha][0] + ": ");
                    objetos[linha][1] = Entrada.leiaString("Informe o novo código para " + objetos[linha][0] + ": ");
                    System.out.println("=> Objeto alterado com sucesso! <=");
                    break;

                case 3:
                    listarObjetos();
                    linha = Entrada.leiaInt("Informe o código para ser excluido -> ");
                    objetos[linha][0] = "";
                    objetos[linha][1] = "";
                    objetos[linha][2] = "";
                    System.out.println("=> Exclusão efetuada com sucesso! <=");
                    break;

                case 4:
                    listarObjetos();
            }
        } while (opcaoSelecionada != 0);

    }

    static void listarObjetos() {
        System.out.println("Existem estes Objetos cadastrados:");
        System.out.println("Cod. - Objeto");

        for (int i = 0; i < objetos.length; i++) {
            if (objetos[i][1].equals("")) {
                continue;
            }

            System.out.print(i);

            for (String objeto : objetos[i]) {
                System.out.print(" - " + objeto);
            }

            System.out.println("");
        }
    }

    static void cadastroClientes() {
        int opcaoSelecionada;
        int linha;
        do {
            opcaoSelecionada = receberOpcaoMenuSecundario("Cadastro de Clientes");

            switch (opcaoSelecionada) {
                case 1:
                    linha = verificaPosicaoLivreNaMatriz(clientes);

                    if (linha == -1) {
                        System.out.println("** Não há posições livres na matriz de clientes **");
                        break;
                    }

                    clientes[linha][0] = Entrada.leiaString("Nome -> ");
                    clientes[linha][1] = Entrada.leiaString("E-mail -> ");
                    clientes[linha][2] = Entrada.leiaString("Cidade -> ");
                    System.out.println("=> Tipo cadastrado com sucesso! <=");
                    break;

                case 2:
                    listarClientes();
                    linha = Entrada.leiaInt("Informe o código para ser alterado -> ");

                    clientes[linha][0] = Entrada.leiaString("Informe o novo nome para " + clientes[linha][0] + ": ");
                    clientes[linha][1] = Entrada.leiaString("Informe o novo e-mail para " + clientes[linha][0] + ": ");
                    clientes[linha][2] = Entrada.leiaString("Informe a nova cidade para " + clientes[linha][0] + ": ");
                    System.out.println("=> Cliente alterado com sucesso! <=");
                    break;

                case 3:
                    listarClientes();

                    linha = Entrada.leiaInt("Informe o código para ser excluido -> ");
                    clientes[linha][0] = "";
                    clientes[linha][1] = "";
                    clientes[linha][2] = "";
                    System.out.println("=> Exclusão efetuada com sucesso! <=");
                    break;

                case 4:
                    listarClientes();
            }
        } while (opcaoSelecionada != 0);
    }

    static void listarClientes() {
        System.out.println("Existem estes clientes cadastrados:");
        System.out.println("Cad. - Nome - Email - Cidade");

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i][1].equals("")) {
                continue;
            }

            System.out.print(i);

            for (String cliente : clientes[i]) {
                System.out.print(" - " + cliente);
            }

            System.out.println("");
        }
    }

    static void cadastroTipoObjeto() {
        int opcaoSelecionada;
        int pos;

        do {
            opcaoSelecionada = receberOpcaoMenuSecundario("Cadastro de Tipos de Objetos");

            switch (opcaoSelecionada) {
                case 1:
                    pos = verificaPosicaoLivreNoVetor(tipoObjeto);

                    if (pos == -1) {
                        System.out.println("** Não há posições livres no vetor de tipos **");
                        break;
                    }

                    tipoObjeto[pos] = Entrada.leiaString("Informe o tipo de Objeto -> ");
                    System.out.println("=> Tipo cadastrado com sucesso! <=");
                    break;

                case 2:
                    listarTipoObjeto();
                    pos = Entrada.leiaInt("Informe o código para ser alterado -> ");
                    tipoObjeto[pos] = Entrada.leiaString("Informe o novo nome para " + tipoObjeto[pos] + ": ");
                    System.out.println("=> Alteração efetuada com sucesso! <=");
                    break;

                case 3:
                    listarTipoObjeto();
                    pos = Entrada.leiaInt("Informe o código para ser excluido -> ");
                    tipoObjeto[pos] = "";
                    System.out.println("=> Exclusão efetuada com sucesso! <=");
                    break;

                case 4:
                    listarTipoObjeto();
                    break;
            }
        } while (opcaoSelecionada != 0);
    }

    static void listarTipoObjeto() {
        System.out.println("Existem estes tipos de ferramentas cadastradas:");
        System.out.println("Cód. - Tipo");

        for (int i = 0; i < tipoObjeto.length; i++) {
            if (tipoObjeto[i].equals("")) {
                continue;
            }

            System.out.println(i + " - " + tipoObjeto[i]);
        }
    }

    static void cadastroManutencoes() {

        int opcaoSelecionada;
        int pos;
        do {
            opcaoSelecionada = receberOpcaoMenuSecundario("Cadastro de Manutenções");

            switch (opcaoSelecionada) {
                case 1:
                    pos = verificaPosicaoLivreNoVetor(manutencoes);

                    if (pos == -1) {
                        System.out.println("** Não há posições livres no vetor de manutenções **");
                        break;
                    }

                    manutencoes[pos] = Entrada.leiaString("Informe a manutenção -> ");
                    System.out.println("=> Manutenção cadastrada com sucesso! <=");
                    break;

                case 2:
                    listarManutencoes();
                    pos = Entrada.leiaInt("Informe o código para ser alterado -> ");
                    manutencoes[pos] = Entrada.leiaString("Informe a nova " + manutencoes[pos] + ": ");
                    System.out.println("=> Alteração efetuada com sucesso! <=");
                    break;

                case 3:
                    listarManutencoes();
                    pos = Entrada.leiaInt("Informe a Manutenção a ser excluida -> ");
                    manutencoes[pos] = "";
                    System.out.println("=> Exclusão efetuada com sucesso! <=");
                    break;

                case 4:
                    listarManutencoes();
                    break;
            }
        } while (opcaoSelecionada != 0);
    }

    static void listarManutencoes() {
        System.out.println("Existem estas Manutenções cadastradas:");
        System.out.println("Cód. - Tipo");

        for (int i = 0; i < manutencoes.length; i++) {
            if (manutencoes[i].equals("")) {
                continue;
            }

            System.out.println(i + "   -    " + manutencoes[i]);
        }
    }

}
