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
    String nome;
    
    public Cadastro(String nome){
        this.setNome(nome);
        this.vendedor = new ArrayList<Vendedor>();
    }
    
    public void addVendedor(Vendedor vendedor){
        this.vendedor.add(vendedor);
        System.out.println("Vendedor " + vendedor + " adicionado");
    }
    
    //Criado automático pelo NetBeans ao criar this.setNome(nome) dentro de Cadastro(String nome)
    private void setNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
