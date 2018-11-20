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
    static ArrayList<Cliente> cliente = new ArrayList<>();
    static ArrayList<Fornecedor> fornecedor = new ArrayList<>();
    static ArrayList<Produto> produto = new ArrayList<>();
    static ArrayList<Venda> venda = new ArrayList<>();
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // TODO code application logic here        
        
        
        Vendedor Vend1 = new Vendedor("Ricardo", "Taverna", "23/11/1992", "(41)999911111", "08544666906", "Curitiba", "PR", "Brasil", "Rua qualquer coisa numero 159", "01/11/2018", "ricardo.taverna", "rt@1992", "vendedor", vendedor);
        Vendedor Vend2 = new Vendedor("Ygor", "Alves", "20/07/98", "(41)999992222", "67215343987", "Curitiba", "PR", "Brasil", "Rua qualquer  69", "14/11/2018", "ygor.alves", "ya@1998", "vendedorAdm", vendedor);
        Cliente Clien1 = new Cliente("Lukas", "Martins", "20/07/1997","(41)999995423","45512167987","Curitiba","PR", "Brasil", "Rua qualquer  ", "14/08/2018","70", cliente);
        Cliente Clien2 = new Cliente("Maria", "Almeida", "10/08/1997","(41)98995486","72053304910","Curitiba","PR", "Brasil", "Rua qualquer 77  ", "01/10/2018","70", cliente);
        Fornecedor Forne1 = new Fornecedor("Lavanderia Star ", "Gael e Hadassa Lavanderia Ltda", "69864189000167","gael@hotmail.com","(41)986691100","Curitiba","PR", "Brasil", "Rua qualquer 55  ", "70","01/05/2018", fornecedor);
        Fornecedor fornecedor2 = new Fornecedor("Fábio e Isabel Transportes ME", "Fábio e Isabel", "04.039.351/0001-67", "faleconosco@fabioeisabeltelasme.com.br", "(43) 2668-0036", "Londrina", "PR", "Brasil", "Rua Antônio Carlos de Oliveira Leme", "358", "10/11/20118", fornecedor);
        Produto prod = new Produto("Caneta","Produto Grande",1,1200.00,Forne1,produto);
        Produto prod2 = new Produto("Caneta2","Produto Grande",2,1200.00,Forne1,produto);
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
