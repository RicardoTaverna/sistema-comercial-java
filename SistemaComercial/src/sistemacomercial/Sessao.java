/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacomercial;

import java.util.Scanner;
import static sistemacomercial.SistemaComercial.vendedor;


/**
 *
 * @author taver
 */
public class Sessao{
    String inpLogin, inpSenha, validaPapel;
    
    public void login(){
        Scanner scan = new Scanner(System.in);
        System.out.print( "Login: " );
        inpLogin = scan.nextLine();
        System.out.print( "Senha: " );
        inpSenha = scan.nextLine();
        
        //leitura de todos os vendedores para validação do login
        boolean validador = false;
        boolean negativo = false;
        Vendedor tempVendedor;
        
        while (validador == false){
            int i = 0;
            for(i = 0; i < vendedor.size(); i = i + 1){
                tempVendedor = vendedor.get(i);
                if (tempVendedor.getLogin().equals(inpLogin) && tempVendedor.getSenha().equals(inpSenha)){
                    System.out.println("Login efetuado com sucesso!");
                    validaPapel = tempVendedor.getPapel();
                    i = vendedor.size() + 1;
                    negativo = true;
                }
            }
            if (negativo == false){
                System.out.println("se fodeu!!! tente de novo");
                login();
            }
            validador = true;            
        }
       
    }
    
    public void newSessao(){
        System.out.println("|---- Menu Vendedor ----|");
        System.out.println("|---- 1) Cadastrar Vendedor ---|");
        System.out.println("|---- 2) Cadastrar Cliente ---|");
        System.out.println("|---- 3) Cadastrar Fornecedor ----|");
        System.out.println("|---- 4) Cadastrar Produto ----|");
        System.out.println("|---- 5) Listar Vendedor ----|");
        System.out.println("|---- 6) Listar Cliente ----|");
        System.out.println("|---- 7) Listar Fornecedor ----|");
        System.out.println("|---- 8) Listar Produtos ----|");
        System.out.println("|---- 9) Registrar Venda ----|");
        System.out.println("|---- 10) Listar Vendas ----|");
        System.out.println("|---- 11) Fechamento do Dia ----|");
    
    public void sessaoVendedor(){
        if(validaPapel.equals("vendedor")){
            
        }
        
    }
}
