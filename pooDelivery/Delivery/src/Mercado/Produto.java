package Mercado;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;

public class Produto {
  private int codproduto;
  private int codcategoria;
  private int estoque;
  private Double preco;
  private String descricao;
  private Scanner scan = new Scanner(System.in);

  public int getCodproduto() {
    return codproduto;
  }

  public void setCodproduto(int codproduto) {
    this.codproduto = codproduto;
  }

  public int getCodcategoria() {
    return codcategoria;
  }

  public void setCodcategoria(int codcategoria) {
    this.codcategoria = codcategoria;
  }

  public int getEstoque() {
    return estoque;
  }

  public void setEstoque(int estoque) {
    this.estoque += estoque;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public void cadastraProduto() {
    scan.useLocale(Locale.ENGLISH);
    // Produto novoProduto = new Produto();
    System.out.println("Qual o codigo do produto?");
    try {
      int c = this.scan.nextInt();
      this.codproduto = c;
    } catch (InputMismatchException e) {
      scan.nextLine();
      System.out.println("Digite apenas valore numéricos!");
      int c = this.scan.nextInt();
      this.codproduto = c;

    }

    System.out.println("Qual o código da categoria do produto?");
    try {
      int p = this.scan.nextInt();
      this.codcategoria = p;
    } catch (InputMismatchException e) {
      scan.nextLine();
      System.out.println("Digite apenas valore numéricos!");
      int p = this.scan.nextInt();
      this.codcategoria = p;
    }

    System.out.println("Descrição do produto: ");
    String d = this.scan.next();
    this.descricao = d;

    System.out.println("Qual o preço do produto?");
    try {
      Double pc = this.scan.nextDouble();
      this.preco = pc;
    } catch (InputMismatchException e) {
      this.scan.nextLine();
      System.out.println("Separe as casas decimais por ponto!");
      Double pc = this.scan.nextDouble();
      this.preco = pc;
    }

    System.out.println("Quantidade disponível");
    try {
      int qtd = this.scan.nextInt();
      this.estoque = qtd;
    } catch (InputMismatchException e) {
      scan.nextLine();
      System.out.println("Digite apenas valore numéricos!");
      int qtd = this.scan.nextInt();
      this.estoque = qtd;
    }
  }

  public void listarProdutos() {

    System.out.println("Codigo do produto:     " + this.codproduto);
    System.out.println("Descrição:             " + this.descricao);
    System.out.printf("Preço:                 %.2f R$%n", this.preco);
    System.out.println("Quantidade disponível: " + this.estoque + "\n");

  }

}
