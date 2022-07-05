package Mercado;

import java.util.Date;

public class Compras {
    private int codcompra;
    private String endrecodeentrega;
    private double total = (double) 0;
    private Date data = new Date();
    private boolean status;

    public int getCodcompra() {
        return codcompra;
    }

    public void setCodcompra(int codcompra) {
        this.codcompra = codcompra;
    }

    public String getEndrecodeentrega() {
        return endrecodeentrega;
    }

    public void setEndrecodeentrega(String endrecodeentrega) {
        this.endrecodeentrega = endrecodeentrega;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void listaratrasos() {
        System.out.printf("%nCPF da nota: %d%nDados de entrega: %s%nTotal da compra: %.2f%nEntregue: %s%n",
                this.codcompra, this.endrecodeentrega, this.total, this.status ? "Sim" : "Não");
    }

}
