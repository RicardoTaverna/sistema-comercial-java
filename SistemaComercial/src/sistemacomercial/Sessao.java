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
    int inpMenuVendedor, inpDigito, inpNumeroVendedor;
    char inpOpcao;
    
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
                System.out.println("Você preencheu algum dado incorretamente, tente de novo");
                login();
            }
            validador = true;            
        }
       
    }
    /*public static void alterar() {
        String nome = JOptionPane.showInputDialog("Digite o Nome do Aluno que deseja Alterar");
        String novo = JOptionPane.showInputDialog("Digite o Novo Nome");
        for (int i = 0; i < vendedor.size(); i++) {
            if (vendedor.get(i).getNome().equals(nome)) {
                vendedor.get(i).setNome(novo);
            }
        }
    }*/
    public void newSessao(){
        if (validador == true) {
            //fake limpa tela
            for (int i = 0; i < 50; ++i) System.out.println();
            //
            System.out.println("|---- Menu Vendedor ----|");
            System.out.println("|---- 1) Cadastrar Vendedor");
            System.out.println("|---- 2) Cadastrar Cliente");
            System.out.println("|---- 3) Cadastrar Fornecedor");
            System.out.println("|---- 4) Cadastrar Produto");
            System.out.println("|---- 5) Listar Vendedor");
            System.out.println("|---- 6) Listar Cliente");
            System.out.println("|---- 7) Listar Fornecedor");
            System.out.println("|---- 8) Listar Produtos");
            System.out.println("|---- 9) Registrar Venda");
            System.out.println("|---- 10) Listar Vendas");
            System.out.println("|---- 11) Fechamento do Dia");
            System.out.print("Escolha o número do MENU: ");
            Scanner scan = new Scanner(System.in);
            inpMenuVendedor = scan.nextInt();
            switch(inpMenuVendedor){
                case 1:
                    cadastraVendedor();
                    break;
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
            System.out.println("|---- Menu Vendedor ----|");
            System.out.println("|---- Escolha uma opcao ----|");
            for(int i = 0; i < vendedor.size(); i = i + 1){          
                System.out.println("|---- " + i + ") " + vendedor.get(i).getNome() + " " +  vendedor.get(i).getSobrenome() + " - " +  vendedor.get(i).getCPF());
            }
            System.out.println("|---- Escolha o numero do vendedor ----|");
            inpNumeroVendedor = scan.nextInt();
            System.out.println("|---- D para DELETAR, ou E para EDITAR ----|");
            inpOpcao = (char) scan.nextInt();
            if("D".equals(inpOpcao)){
                deletarVendedor(inpNumeroVendedor);  
                if("E".equals(inpOpcao)){
                    editarVendedor(inpNumeroVendedor);
                }else{
                    System.out.println("Digite uma opção valida");
                    listarVendedor();
                }
            }
                
        }else{
            int dadosPessoais = 0;
            for(int i = 0; i<vendedor.size(); i ++){
                if (vendedor.get(i).getLogin().equals(inpLogin)){
                    dadosPessoais = i;
                }  
                System.out.println("|---- " + i + ") " + vendedor.get(i).getNome() + " " +  vendedor.get(i).getSobrenome() + " - " +  vendedor.get(i).getCPF());
            }
            System.out.println("|---- Digite 1 para editar seus dados \n |---- Ou digite 2 para sair");
            inpDigito = scan.nextInt();
            while(inpDigito != 2 && inpDigito != 1){
                System.out.println("|---- Digite 1 para editar seus dados \n |---- Ou digite 2 para sair");
                inpDigito = scan.nextInt();
            }
            if(inpDigito == 1){
                editarVendedor(dadosPessoais);
            }
        }
    }
    
    public void cadastraVendedor() {
        
    }
    
    public void deletarVendedor(int i) {
        vendedor.remove(i);
    }
    
    public void editarVendedor(int i) {
        Scanner scan = new Scanner(System.in);
        int inpOpcaoEdicao;
        String novo;
        //passar como parametro a posição do vendedor a ser editado
        //fake limpa tela
        for (int count = 0; count < 50; ++count) System.out.println();
        //
        System.out.println("|---- Menu Editar Vendedor ----|");
        System.out.println("|---- Escolha o numero da opção a ser editada ----|");
        System.out.println("|---- 1 - " +vendedor.get(i).getNome());
        System.out.println("|---- 2 - " +vendedor.get(i).getSobrenome());
        System.out.println("|---- 3 - " +vendedor.get(i).getDatanascimento());
        System.out.println("|---- 4 - " +vendedor.get(i).getTelefone());
        System.out.println("|---- 5 - " +vendedor.get(i).getCPF());
        System.out.println("|---- 6 - " +vendedor.get(i).getCidade());
        System.out.println("|---- 7 - " +vendedor.get(i).getEstado());
        System.out.println("|---- 8 - " +vendedor.get(i).getPais());
        System.out.println("|---- 9 - " +vendedor.get(i).getEndereco());
        System.out.println("|---- 10 - " +vendedor.get(i).getDataCadastro());
        System.out.println("|---- 11 - " +vendedor.get(i).getLogin());
        System.out.println("|---- 12 - " +vendedor.get(i).getSenha());
        inpOpcaoEdicao = scan.nextInt();
        switch(inpOpcaoEdicao){
            case 1:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite o novo NOME ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setNome(novo);
                System.out.println("NOME alteradado para: " +vendedor.get(i).getNome());
                break;
            case 2:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite o novo SOBRENOME ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setSobrenome(novo);
                System.out.println("SOBRENOME alteradado para: " +vendedor.get(i).getNome());
                break;
            case 3:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite a nova DATA DE NASCIMENTO ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setDatanascimento(novo);
                System.out.println("DATA DE NASCIMENTO alteradado para: " +vendedor.get(i).getNome());
                break;
            case 4:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite o novo TELEFONE ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setTelefone(novo);
                System.out.println("TELEFONE alteradado para: " +vendedor.get(i).getNome());
                break;
            case 5:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite o novo CPF ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setCPF(novo);
                System.out.println("CPF alteradado para: " +vendedor.get(i).getNome());
                break;
            case 6:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite a nova CIDADE ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setCidade(novo);
                System.out.println("CIDADE alteradado para: " +vendedor.get(i).getNome());
                break;
            case 7:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite o novo ESTADO ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setEstado(novo);
                System.out.println("ESTADO alteradado para: " +vendedor.get(i).getNome());
                break;
            case 8:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite o novo PAIS ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setPais(novo);
                System.out.println("PAIS alteradado para: " +vendedor.get(i).getNome());
                break;
            case 9:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite o novo ENDEREÇO ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setEndereco(novo);
                System.out.println("ENDEREÇO alteradado para: " +vendedor.get(i).getNome());
                break;
            case 10:
                System.out.println("A data de cadastro não pode ser alterada, contate o Administador");
                editarVendedor(i);
                break;
            case 11:
                System.out.println("O login não pode ser alterado, contate o Administrador");
                editarVendedor(i);
                break;
            case 12:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite a nova SENHA ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setSenha(novo);
                System.out.println("SENHA alteradado para: " +vendedor.get(i).getNome());
                break;
            default:
                System.out.println("Numero inexistente");
                editarVendedor(i);
        }
    } 
     
}
