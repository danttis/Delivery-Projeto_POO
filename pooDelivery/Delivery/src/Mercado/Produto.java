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

    /* private List<Integer> codproduto = new ArrayList<Integer>();
    private List<Integer> codcategoria = new ArrayList<Integer>();
    private List<String> descricao = new ArrayList<String>();
    private List<Double> preco = new ArrayList<Double>();
    private List<Integer> estoque = new ArrayList<Integer>();

    public void setCodproduto(int i) {
        this.codproduto.add(i);
    }

    public void setCodcategoria(int i) {
        this.codcategoria.add(i);
    }

    public void setDescricao(String string) {
        this.descricao.add(string);
    }
    
    public void setPreco(Double preco) {
        this.preco.add(preco);
    }

    public void setEstoque(int i) {
        this.estoque.add(i);
    }

    public int totaldeprodutos(){
        return codproduto.size();
    }  
    
     
    public int buscarCodProduto(int cod){
      int x = -1;
      for(int i = 0; i < totaldeprodutos(); i++){
          if(cod == this.codproduto.get(i)){
            x = i;
          }
      }
      return(x);
    } */  
    public void cadastraProduto(){
      scan.useLocale(Locale.ENGLISH);
        //Produto novoProduto = new Produto();
        System.out.println("Qual o codigo do produto?");
        try {
          int c = this.scan.nextInt();
          this.codproduto = c;
        } catch (InputMismatchException e) {
          scan.nextLine();
          System.out.println("Digite apenas valore numericos!");
          int c = this.scan.nextInt();
          this.codproduto = c;
          
        }     
       
        System.out.println("Qual o codigo da categoria do produto?");
        try {
          int p = this.scan.nextInt();
          this.codcategoria = p;
        } catch (InputMismatchException e) {
          scan.nextLine();
          System.out.println("Digite apenas valore numericos!");
          int p = this.scan.nextInt();
          this.codcategoria = p;
        }
      
        System.out.println("Descrição do produto: ");
        String d = this.scan.next();
        this.descricao = d;

        System.out.println("Qual o preço do produto?");
        try{
          Double pc = this.scan.nextDouble();
          this.preco = pc;
        }catch(InputMismatchException e){
          this.scan.nextLine();
          System.out.println("Separe as casas decimais por virgula!");
          Double pc = this.scan.nextDouble();
          this.preco = pc;
        }   
        
        System.out.println("Quantidade disponivél");
        try {
          int qtd = this.scan.nextInt();
          this.estoque = qtd;
        } catch (InputMismatchException e) {
          scan.nextLine();
          System.out.println("Digite apenas valore numericos!");
          int qtd = this.scan.nextInt();
          this.estoque = qtd;
        }
    }
    public void listarProdutos(){
            
            System.out.println("Codigo do produto:     "+ this.codproduto);
            System.out.println("Descrição:             " + this.descricao);
            System.out.println("Preço:                 "+this.preco+" R$");
            System.out.println("Quantidade disponivél: " + this.estoque+"\n");
        
        
    }
    
}
