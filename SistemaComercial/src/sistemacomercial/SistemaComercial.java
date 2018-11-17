/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacomercial;

import java.io.*;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author taver
 */
public class SistemaComercial {
    
    /**
     * @param args the command line arguments
     */
    static ArrayList<Vendedor> vendedor = new ArrayList<>();
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // TODO code application logic here        
        
        
        Vendedor Vend1 = new Vendedor("Ricardo", "Taverna", "23/11/1992", "(41)999911111", "08544666906", "Curitiba", "PR", "Brasil", "Rua qualquer coisa numero 159", "01/11/2018", "ricardo.taverna", "rt@1992", "vendedor", vendedor);
        Vendedor Vend2 = new Vendedor("Ygor", "Alves", "20/07/98", "(41)999992222", "67215343987", "Curitiba", "PR", "Brasil", "Rua qualquer se foe ae 69", "14/11/2018", "ygor.alves", "ya@1998", "vendedorAdm", vendedor);
 
         
        //Carregar aruivo com os dados das classes
//        FileInputStream inputFile = new FileInputStream("vendedor.ser");
//        ObjectInputStream in = new ObjectInputStream(inputFile);
//        Cadastro cadastroVend1 = (Cadastro) in.readObject();
//        in.close();
//        inputFile.close();
        
        Sessao sessao = new Sessao();
        System.out.println("|---- Sistema Comercial TYL ----|");
        System.out.println("|---- Preencha os campos login e senha para começar a utilizar");
        sessao.login();
        sessao.newSessao();
        
        
        //Arquivo de gravação final
//        FileOutputStream savefile = new FileOutputStream("vendedor.ser");
//        ObjectOutputStream objectStrem = new ObjectOutputStream(savefile);
//        objectStrem.writeObject(cadastroVend1);
//        objectStrem.close();
//        savefile.close();
        
    }
    
}
