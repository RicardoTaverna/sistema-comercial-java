/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacomercial;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author taver
 */
public final class Cadastro implements Serializable {
    public static ArrayList<Vendedor> vendedor;
    public static ArrayList<Fornecedor> fornecedor;
    
    public Cadastro(){
        this.vendedor = new ArrayList<Vendedor>();
    }
    
    
    public void addVendedor(Vendedor vendedor){
        this.vendedor.add(vendedor);
        System.out.println("Vendedor " + vendedor.nome + " adicionado");
    }
    
}
