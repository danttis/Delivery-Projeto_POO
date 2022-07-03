package Mercado;


public class Categoria {
    private int codigo;
    private String tipo;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

  


    public void listacategorias() {
           System.out.printf("Tipo: %s | Codigo: %d%n",this.tipo,this.codigo);
    }
}
