/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacomercial;

import java.util.ArrayList;

/**
 *
 * @author taver
 */
public class Cadastro {
    ArrayList<Vendedor> vendedor;
    
    public Cadastro(){
        this.vendedor = new ArrayList<Vendedor>();
    }
    
    public void addVendedor(Vendedor vendedor){
        this.vendedor.add(vendedor);
        System.out.println("Vendedor " + vendedor.nome + " adicionado");
    }
    
}
