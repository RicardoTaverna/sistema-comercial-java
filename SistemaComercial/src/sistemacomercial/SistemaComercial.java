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
public class SistemaComercial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Cadastro cadastroVend1 = new Cadastro();
        
        cadastroVend1.addVendedor(new Vendedor("Ricardo", "Taverna", "23/11/1992", "(41)999911111", "08544666906", "Curitiba", "PR", "Brasil", "Rua qualquer coisa numero 159", "01/11/2018", "ricardo.taverna", "rt@1992", "comum"));
        
        //System.out.println(vendedor1);
    }
    
}
