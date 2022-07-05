import Mercado.*;
import Usuarios.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;
import java.io.Console;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);
        List<Administrador> adm = new ArrayList<Administrador>();
        List<Cliente> cliente = new ArrayList<Cliente>();
        List<Produto> novoProduto = new ArrayList<Produto>();
        List<Categoria> categorias = new ArrayList<Categoria>();
        List<Carrinho> carrinho = new ArrayList<Carrinho>();
        List<Compras> compras = new ArrayList<Compras>();
        int i, j, k, cod;
        String opcao;
        boolean loop = true, controleW = true, controleW2 = false, encontrado = false;
        adm.add(new Administrador()); // administrador principal nome: admin, senha: admin
        while (loop) {
            ClearConsole();
            System.out.println("Seja bem vindo!\nIdenifique-se:\nSou funcionário - 1\nSou cliente - 2\nSair - 3");
            String tipo = scan.next();
            if (tipo.equals("1")) { // parte do administrador
                ClearConsole();
                System.out.println("Faça login para continuar");
                System.out.printf("Nome do usuario: ");
                String nome = scan.next();
                System.out.printf("Senha: ");
                Console console = System.console();
                String senha = new String(console.readPassword());
                for (j = 0; j < adm.size(); j++) {
                    if (adm.get(j).Altenticar(nome, senha)) {
                        controleW = true;
                        while (controleW) {
                            ClearConsole();
                            System.out.printf(
                                    "Olá %s o que gostaria de fazer?%nCadastrar novo funcionário - 1%nCadastrar produto - 2%nExcluir Produto - 3%nListar produtos - 4%nExcluir funcionário - 5%nAlterar estoques - 6%nListar usuários - 7%nListar compras- 8%nSair - 9%n",
                                    adm.get(j).getNome());
                            opcao = scan.next();
                            if (opcao.equals("1")) {// cadatrar funcionario
                                ClearConsole();
                                adm.add(new Administrador());
                                int ul = adm.size() - 1;
                                adm.get(ul).cadastrafuncionario();
                                System.out.println("Usario cadastrado, logue novamente");
                                Thread.sleep(1000);
                                ClearConsole();
                            } else if (opcao.equals("2")) {// cadastrar produto
                                ClearConsole();
                                if (categorias.isEmpty()) {
                                    // implementação da criação de categorias
                                    System.out.println("Parece que não tem nenhuma categoria cadastrada, crie uma:");
                                    categorias.add(new Categoria());
                                    System.out.printf("Digite o nome da categoria: ");
                                    opcao = scan.next();
                                    categorias.get(0).setTipo(opcao);
                                    System.out.printf("Digite o codigo da categoria: ");
                                    cod = scan.nextInt();
                                    categorias.get(0).setCodigo(cod);

                                } else {
                                    ClearConsole();
                                    System.out.println("Deseja criar uma nova categoria?\nSim - 1\nNão - 2");
                                    opcao = scan.next();
                                    if (opcao.equals("1")) {
                                        categorias.add(new Categoria());
                                        int q = categorias.size() - 1;
                                        System.out.printf("Digite o nome da categoria: ");
                                        opcao = scan.next();
                                        categorias.get(q).setTipo(opcao);
                                        System.out.printf("Digite o codigo da categoria: ");
                                        cod = scan.nextInt();
                                        categorias.get(q).setCodigo(cod);

                                    } else if (opcao.equals("2")) {
                                        ClearConsole();
                                    }
                                }
                                System.out.println("Quantos produtos deseja cadastrar: ");
                                int qtd = scan.nextInt() + novoProduto.size();
                                for (i = 0; i < qtd; i++) {
                                    novoProduto.add(new Produto());
                                    if (novoProduto.get(i).getCodproduto() == 0) {
                                        System.out.printf("Produto %d%n", i + 1);
                                        novoProduto.get(i).cadastraProduto();
                                    }
                                }

                            } else if (opcao.equals("3")) { // excluir produto
                                ClearConsole();
                                System.out.printf("Digite o codigo do produto que deseja excluir: ");
                                cod = scan.nextInt();
                                for (i = 0; i < novoProduto.size(); i++) {
                                    if (novoProduto.get(i).getCodproduto() == cod) {
                                        System.out.printf("Produto excluído: %s%n", novoProduto.get(i).getDescricao());
                                        novoProduto.remove(i);
                                    }
                                }

                            } else if (opcao.equals("4")) { // listar produto por categoria
                                ClearConsole();
                                System.out.println("Categorias:\n");
                                for (i = 0; i < categorias.size(); i++) {
                                    categorias.get(i).listacategorias();
                                }
                                System.out.println("De qual categoria quer ver os produtos: ");
                                cod = scan.nextInt();
                                encontrado = false;
                                for (i = 0; i < novoProduto.size(); i++) {
                                    if (novoProduto.get(i).getCodcategoria() == cod) {
                                        novoProduto.get(i).listarProdutos();
                                        encontrado = true;
                                    }
                                }
                                if (!encontrado) {
                                    System.out.println("Categoria sem produtos :(\n");
                                }
                                System.out.printf("Digite qualquer coisa para voltar: ");
                                opcao = scan.next();
                            } else if (opcao.equals("5")) { // excluir funcionario
                                ClearConsole();
                                for (i = 0; i < adm.size(); i++) {
                                    System.out.printf("Funcionário %s | Função: %s%n", adm.get(i).getNome(),
                                            adm.get(i).getFuncao());
                                }
                                System.out.printf("Qual o nome do funcionário deseja demitir: ");
                                String func = scan.next();
                                for (i = 1; i < adm.size(); i++) {
                                    if (func.equals(adm.get(0).getNome())) {
                                        System.out.println("Não pode demitir o admin");
                                        System.out.printf("Tente outro Funcionário ");
                                        func = scan.next();
                                    }
                                    if (func.equals(adm.get(i).getNome())) {
                                        System.out.printf("funcionário: %s demitido%n", adm.get(i).getNome());
                                        adm.remove(i);
                                    }
                                }

                                System.out.printf("Digite qualquer coisa para voltar: ");
                                opcao = scan.next();
                            } else if (opcao.equals("6")) { // alterar estoque
                                ClearConsole();
                                for (i = 0; i < novoProduto.size(); i++) {
                                    novoProduto.get(i).listarProdutos();
                                }
                                System.out.printf("Digite o codigo do produto que deseja alterar o estoque: ");
                                cod = scan.nextInt();
                                for (i = 0; i < novoProduto.size(); i++) {
                                    if (cod == novoProduto.get(i).getCodproduto()) {
                                        System.out.printf("Digite o valor, caso queira diminuir digite negativo: ");
                                        int estoque = scan.nextInt();
                                        novoProduto.get(i).setEstoque(estoque);
                                    }
                                }
                                System.out.printf("Digite qualquer coisa para voltar: ");
                                opcao = scan.next();
                            } else if (opcao.equals("7")) {
                                ClearConsole();
                                System.out.println("Funcionários:\n");
                                for (i = 0; i < adm.size(); i++) {
                                    adm.get(i).listarUsuarios();
                                    System.out.println("\n");
                                }
                                System.out.println("Clientes:\n");
                                for (i = 0; i < cliente.size(); i++) {
                                    cliente.get(i).listarUsuarios();
                                    System.out.println("\n");
                                }
                                System.out.printf("Digite qualquer coisa para voltar: ");
                                opcao = scan.next();
                            } else if (opcao.equals("8")) {
                                ClearConsole();
                                for (i = 0; i < compras.size(); i++) {
                                    if (!compras.get(i).getStatus()) {
                                        compras.get(i).listaratrasos();
                                    }
                                }
                                System.out.printf("Digite qualquer coisa para voltar: ");
                                opcao = scan.next();
                            } else if (opcao.equals("9")) { // sair
                                controleW = false;
                                System.out.println("Saíndo........");
                                Thread.sleep(500);
                                ClearConsole();
                            } else {
                                System.out.println("opção não diponivél!");
                            }

                        }

                    }
                }

            }
            // fim da parte do administrador
            else if (tipo.equals("2")) {
                ClearConsole();
                System.out.println("Seja bem vindo!\nLogin - 1\nCadastrar-se - 2\nVer produtos disponivéis - 3");
                opcao = scan.next();
                if (opcao.equals("1")) { // area do cliente
                    ClearConsole();
                    System.out.println("Faça login para continuar");
                    System.out.printf("Nome do usuario: ");
                    String nomeUser = scan.next();
                    System.out.printf("Senha: ");
                    Console console = System.console();
                    String senhaUser = new String(console.readPassword());
                    for (k = 0; k < cliente.size(); k++) { // se o login deu certo o sistema é iniciado
                        if (cliente.get(k).Altenticar(nomeUser, senhaUser)) {
                            controleW2 = true;
                            while (controleW2) {
                                ClearConsole();
                                System.out.printf(
                                        "Olá %s o que gostaria de fazer?%nVer produtos disponivéis - 1%nComprar - 2%nVer carrinho - 3%nReclamar de atraso/não recebido - 4\nSair - 5%n",
                                        cliente.get(k).getNome());
                                opcao = scan.next();

                                if (opcao.equals("1")) { // listar produtos
                                    ClearConsole();
                                    System.out.println("Categorias:\n");
                                    for (i = 0; i < categorias.size(); i++) {
                                        categorias.get(i).listacategorias();
                                    }
                                    System.out.println("De qual categoria quer ver os produtos: ");
                                    cod = scan.nextInt();
                                    encontrado = false;
                                    for (i = 0; i < novoProduto.size(); i++) {
                                        if (novoProduto.get(i).getCodcategoria() == cod) {
                                            novoProduto.get(i).listarProdutos();
                                            encontrado = true;
                                        }
                                    }
                                    if (!encontrado) {
                                        System.out.println("Categoria sem produtos :(\n");
                                    }

                                    System.out.printf("Digite qualquer coisa para voltar: ");
                                    opcao = scan.next();
                                    ClearConsole();
                                } else if (opcao.equals("2")) { // Comprar
                                    ClearConsole();
                                    System.out.println("Categorias:\n");
                                    for (i = 0; i < categorias.size(); i++) {
                                        categorias.get(i).listacategorias();
                                    }
                                    System.out.println("De qual categoria quer ver os produtos: ");
                                    cod = scan.nextInt();
                                    for (i = 0; i < novoProduto.size(); i++) {
                                        if (novoProduto.get(i).getCodcategoria() == cod) {
                                            novoProduto.get(i).listarProdutos();
                                        }
                                    }
                                    System.out.printf("Insira o codigo do produto: ");
                                    cod = scan.nextInt();

                                    for (i = 0; i < novoProduto.size(); i++) {
                                        if (novoProduto.get(i).getCodproduto() == cod) {
                                            if (novoProduto.get(i).getEstoque() > 0) {
                                                for (int pi = 0; pi < carrinho.size(); pi++) {
                                                    if (carrinho.get(pi).getCodusuario() == cliente.get(k).getCpf()) {
                                                        carrinho.get(pi)
                                                                .setCodigoprodutos(novoProduto.get(i).getCodproduto());
                                                        carrinho.get(pi)
                                                                .setDescricao(novoProduto.get(i).getDescricao());
                                                        carrinho.get(pi).setSubtotal(novoProduto.get(i).getPreco());
                                                        carrinho.get(pi).setQtd(1);
                                                        novoProduto.get(i).setEstoque(-1);
                                                    }
                                                }
                                            } else {
                                                System.out.println("Sem estoque desse produto no momento :(");
                                            }

                                        }
                                    }
                                    System.out.printf("Digite qualquer coisa para voltar: ");
                                    opcao = scan.next();
                                    ClearConsole();
                                }

                                else if (opcao.equals("3")) {
                                    ClearConsole();
                                    for (i = 0; i < carrinho.size(); i++) {
                                        if (carrinho.get(i).getCodusuario() == cliente.get(k).getCpf()) {
                                            carrinho.get(i).listacarrinho();
                                        }
                                    }
                                    System.out.println("Remover produto - 1\nFinalizar compra - 2\nSair - 3");
                                    opcao = scan.next();
                                    if (opcao.equals("1")) {
                                        System.out.printf("Qual produto deseja remover: ");
                                        cod = scan.nextInt();
                                        for (i = 0; i < novoProduto.size(); i++) {
                                            if (novoProduto.get(i).getCodproduto() == cod) {
                                                for (int pi = 0; pi < carrinho.size(); pi++) {
                                                    if (carrinho.get(pi).getCodusuario() == cliente.get(k).getCpf()) {
                                                        carrinho.get(pi).removerProduto(cod);
                                                        carrinho.get(pi).setSubtotal(-novoProduto.get(i).getPreco());
                                                        carrinho.get(pi).setQtd(1);
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    else if (opcao.equals("2")) {
                                        for (int pi = 0; pi < carrinho.size(); pi++) {
                                            if (carrinho.get(pi).getCodusuario() == cliente.get(k).getCpf()) {
                                                compras.add(new Compras());
                                                // int d = compras.size()-1;
                                                compras.get(compras.size() - 1).setCodcompra(cliente.get(k).getCpf());
                                                // compras.get(compras.size()-1).getCodcompra();
                                                compras.get(compras.size() - 1)
                                                        .setTotal(carrinho.get(pi).getSubtotal());
                                                compras.get(compras.size() - 1)
                                                        .setEndrecodeentrega("\nNome: " + cliente.get(k).getNome()
                                                                + "\nCidade: " + cliente.get(k).getCidade()
                                                                + "\nEndereço: " + cliente.get(k).getEndereco());
                                                carrinho.get(pi).finalizar();

                                            }
                                        }
                                    } else if (opcao.equals("3")) {

                                    } else {
                                        System.out.println("Opção inavalida!");
                                    }
                                }

                                else if (opcao.equals("4")) {
                                    for (i = 0; i < compras.size(); i++) {
                                        if (compras.get(i).getCodcompra() == cliente.get(i).getCpf()) {
                                            compras.get(i).setStatus(false);
                                        }
                                    }
                                } else if (opcao.equals("5")) {
                                    controleW2 = false;
                                }

                            }
                        }
                    }
                } /// aqui termina a parte de login do cliente

                else if (opcao.equals("2")) {
                    ClearConsole();
                    cliente.add(new Cliente());
                    carrinho.add(new Carrinho());
                    for (i = 0; i < cliente.size(); i++) {
                        if (cliente.get(i).getNome() == null) {
                            cliente.get(i).cadastraUsuario();
                            carrinho.get(i).setCodusuario(cliente.get(i).getCpf());
                        }
                    }
                    System.out.printf("Digite qualquer coisa para voltar: ");
                    opcao = scan.next();
                    ClearConsole();
                } /// aqui termina a parte de cadastro do cliente

                else if (opcao.equals("3")) {
                    ClearConsole();
                    if (novoProduto.isEmpty()) {
                        System.out.println("Não temos nenhum produto disponivél no momento :(");
                    } else {
                        System.out.println("Produtos:\n");
                        for (i = 0; i < novoProduto.size(); i++) {
                            novoProduto.get(i).listarProdutos();
                        }
                    }

                    System.out.printf("Digite qualquer coisa para voltar: ");
                    opcao = scan.next();
                } /// fim da função listar
                else if (opcao.equals("4")) {
                    controleW = false;
                    System.out.println("Saíndo........");
                    Thread.sleep(1000);
                    ClearConsole();
                } // sair
            } else if (tipo.equals("3")) { /// função que fecha o while inicial
                loop = false;
                Thread.sleep(1000);
                ClearConsole();
            } else {
                System.out.println("Entrada invalida");
            }
        }
    }

    public static void ClearConsole() throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
