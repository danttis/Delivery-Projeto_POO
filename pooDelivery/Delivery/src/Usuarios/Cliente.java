package Usuarios;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private List<String> comprasrealizada = new ArrayList<String>();

    public List<String> getComprasrealizada() {
        return comprasrealizada;
    }

    public void setComprasrealizada(String comprasrealizada) {
        this.comprasrealizada.add(comprasrealizada);
    }

    public void listarcompras() {
        for (int i = 0; i < comprasrealizada.size(); i++) {
            System.out.println("Compra: " + comprasrealizada.get(i));
        }
    }

}