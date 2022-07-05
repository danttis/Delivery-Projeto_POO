package Usuarios;

import java.util.InputMismatchException;
import Mercado.Produto;
import java.util.Locale;

public class Administrador extends Usuario {
  // private Usuario novo;
  private String funcao;

  public String getFuncao() {
    return funcao;
  }

  public Administrador() {
    this.setNome("admin");
    this.setSenha("admin");
    this.funcao = "admin";
  }

  public void cadastrafuncionario() {
    super.cadastraUsuario();
    System.out.println("Qual a função do funcionário?");
    this.funcao = super.scan.next();
  }

  public void cadastraProduto(Produto novoProduto) {
    scan.useLocale(Locale.ENGLISH);
    // Produto novoProduto = new Produto();
    System.out.println("Qual o código do produto?");
    try {
      int c = super.scan.nextInt();
      novoProduto.setCodproduto(c);
    } catch (InputMismatchException e) {
      scan.nextLine();
      System.out.println("Digite apenas valore numéricos!");
      int c = super.scan.nextInt();
      novoProduto.setCodproduto(c);

    }

    System.out.println("Qual o código da categoria do produto?");
    try {
      int p = super.scan.nextInt();
      novoProduto.setCodcategoria(p);
    } catch (InputMismatchException e) {
      scan.nextLine();
      System.out.println("Digite apenas valore numéricos!");
      int p = super.scan.nextInt();
      novoProduto.setCodcategoria(p);
    }

    System.out.println("Descrição do produto: ");
    String d = super.scan.next();
    novoProduto.setDescricao(d);
    System.out.println("Qual o preço do produto?");
    try {
      Double pc = super.scan.nextDouble();
      novoProduto.setPreco(pc);
    } catch (InputMismatchException e) {
      super.scan.nextLine();
      System.out.println("Separe as casas decimais por ponto!");
      Double pc = super.scan.nextDouble();
      novoProduto.setPreco(pc);
    }

    System.out.println("Quantidade disponível");
    try {
      int qtd = super.scan.nextInt();
      novoProduto.setEstoque(qtd);
    } catch (InputMismatchException e) {
      scan.nextLine();
      System.out.println("Digite apenas valore numéricos!");
      int qtd = super.scan.nextInt();
      novoProduto.setEstoque(qtd);
    }

  }

  public void listarUsuarios() {
    super.listarUsuarios();
    System.out.printf("Função: %s%n", this.funcao);
  }
}