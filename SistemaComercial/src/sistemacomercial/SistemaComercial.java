/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacomercial;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 *
 * @author taver
 */
public class SistemaComercial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        Cadastro cadastroVend1 = new Cadastro();
        
        cadastroVend1.addVendedor(new Vendedor("Ricardo", "Taverna", "23/11/1992", "(41)999911111", "08544666906", "Curitiba", "PR", "Brasil", "Rua qualquer coisa numero 159", "01/11/2018", "ricardo.taverna", "rt@1992", "comum"));
        
        FileOutputStream file = new FileOutputStream("vendedor.ser");
        ObjectOutputStream objectStrem = new ObjectOutputStream(file);
        objectStrem.writeObject(cadastroVend1);
        objectStrem.close();
        file.close();
        //System.out.println(vendedor1);
    }
    
}
