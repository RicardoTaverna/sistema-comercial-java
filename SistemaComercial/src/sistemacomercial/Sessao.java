/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacomercial;


import java.util.Scanner;
import javax.swing.JOptionPane;
import static sistemacomercial.SistemaComercial.vendedor;


/**
 *
 * @author taverna, yago, milico
 */
public class Sessao{
    String inpLogin, inpSenha, validaPapel;
    boolean validador = false;
    int inpMenuVendedor, inpDigito;
    
    public void login(){
        Scanner scan = new Scanner(System.in);
        System.out.print( "Login: " );
        inpLogin = scan.nextLine();
        System.out.print( "Senha: " );
        inpSenha = scan.nextLine();
        
        //leitura de todos os vendedores para validação do login
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
 public static void alterar() {
        String nome = JOptionPane.showInputDialog("Digite o Nome do Aluno que deseja Alterar");
        String novo = JOptionPane.showInputDialog("Digite o Novo Nome");
        for (int i = 0; i < vendedor.size(); i++) {
            if (vendedor.get(i).getNome().equals(nome)) {
                vendedor.get(i).setNome(novo);
            }
        }
    }
    public void newSessao(){
        if (validador == true) {
            for (int i = 0; i < 50; ++i) System.out.println();
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
            
            System.out.println("Escolha o número do MENU");
            Scanner scan = new Scanner(System.in);
            inpMenuVendedor = scan.nextInt();
            
            
            switch(inpMenuVendedor){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    listarVendedor();
                    break;
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    
                    
                default:
                    System.out.println("Numero inexistente");
                    newSessao();
            }    
        }
    }
    
    public void listarVendedor() {
        Scanner scan = new Scanner(System.in);
        
        if ("vendedorAdm".equals(validaPapel)){
            for(int i = 0; i < vendedor.size(); i = i + 1){          
                System.out.println( i + "- " +vendedor.get(i).getNome() + " " +  vendedor.get(i).getSobrenome());   

            }
            System.out.println("Digite o Numero do Vendedor ");
            inpDigito = scan.nextInt();
            if(inpDigito == 1){
                //switch
                
            }
        }else{
            int dadosPessoais = 0;
            for(int i = 0; i<vendedor.size(); i ++){
                if (vendedor.get(i).getLogin().equals(inpLogin)){
                    dadosPessoais = i;
                    i = vendedor.size() +1;                              
                }                      
            }
            System.out.println(vendedor.get(dadosPessoais).getNome() + " " +  vendedor.get(dadosPessoais).getSobrenome());
            System.out.println("Digite 1 para editar seus dados \n Ou digite 2 para sair");
            inpDigito = scan.nextInt();
            while(inpDigito != 2 && inpDigito != 1){
                System.out.println("Digite 1 para editar seus dados \n Ou digite 2 para sair");
                inpDigito = scan.nextInt();
            }
            if(inpDigito == 1){
                System.out.println("1 - " +vendedor.get(dadosPessoais).getNome());
                System.out.println("2 - " +vendedor.get(dadosPessoais).getSobrenome());
                System.out.println("3 - " +vendedor.get(dadosPessoais).getDatanascimento());
                System.out.println("4 - " +vendedor.get(dadosPessoais).getTelefone());
                System.out.println("5 - " +vendedor.get(dadosPessoais).getCPF());
                System.out.println("6 - " +vendedor.get(dadosPessoais).getCidade());
                System.out.println("7 - " +vendedor.get(dadosPessoais).getEstado());
                System.out.println("8 - " +vendedor.get(dadosPessoais).getPais());
                System.out.println("9 - " +vendedor.get(dadosPessoais).getEndereco());
                System.out.println("10 - " +vendedor.get(dadosPessoais).getDataCadastro());
                System.out.println("11 - " +vendedor.get(dadosPessoais).getLogin());
                System.out.println("12 - " +vendedor.get(dadosPessoais).getSenha());
               
                
                
               //criar um switch para cada um
                System.out.println("Digite seu novo nome ");
                String novo = scan.next();
                vendedor.get(dadosPessoais).setNome(novo);
                    
                System.out.println("1 - " +vendedor.get(dadosPessoais).getNome());
                
            }

        
        }
    }

    
     
}
