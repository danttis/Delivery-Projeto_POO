package Mercado;
import java.util.ArrayList;
import java.util.List;


public class Carrinho {
    private int ip;
    private int codusuario;
    private ArrayList <Integer> codigoprodutos = new ArrayList<Integer>();
    private List<String> descricao = new ArrayList<String>();
    private int qtd;
    private Double subtotal  = (double) 0;
    private boolean finalizar = false;
    
   
    public int getIp() {
        return ip;
    }



    public void setIp(int ip) {
        this.ip = ip;
    }



    public int getCodusuario() {
        return codusuario;
    }



    public void setCodusuario(int codusuario) {
        this.codusuario = codusuario;
    }



    public void setCodigoprodutos(int codigoprodutos) {
        this.codigoprodutos.add(codigoprodutos);
    }



    public List<String> getDescricao() {
        return descricao;
    }



    public void setDescricao(String descricao) {
        this.descricao.add(descricao);
    }



    public int getQtd() {
        return qtd;
    }



    public void setQtd(int qtd) {
        this.qtd += qtd;
    }



    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal += subtotal;
    }

  


    public boolean isFinalizar() {
        return finalizar;
    }



    public ArrayList<Integer> getCodigoprodutos() {
        return codigoprodutos;
    }  
    
    

    public void setFinalizar(boolean finalizar) {
        this.finalizar = finalizar;
    }

    public void removerProduto(int x){
          for(int i = 0; i < this.codigoprodutos.size(); i++){
             if(this.codigoprodutos.get(i).intValue() == x ){
                this.codigoprodutos.remove(i);
                this.descricao.remove(i);
                this.qtd-=1;
             }
          }
    }

    public void listacarrinho(){
        System.out.println("Carrinho:\n");
        for(int i = 0; i < codigoprodutos.size(); i++){
            System.out.printf("Nome: %s | Codigo: %d%n",this.descricao.get(i),this.codigoprodutos.get(i));
        }
        System.out.printf("Codigo do Usuario: %d%nQuantidade de itens: %d%nSubtotal: %f%n",this.codusuario,this.qtd,this.subtotal);
    }
      


}
    


