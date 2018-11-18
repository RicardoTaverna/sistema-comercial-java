/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacomercial;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static sistemacomercial.SistemaComercial.vendedor;
import static sistemacomercial.SistemaComercial.cliente;
import static sistemacomercial.SistemaComercial.fornecedor;



/**
 *
 * @author taverna, yago, milico
 */
public class Sessao{
    String inpLogin, inpSenha, validaPapel;
    boolean validador = false;
    int inpMenuVendedor, inpDigito, inpNumeroVendedor,inpNumeroCliente,inpNumeroFornecedor;
    String inpOpcao;
    
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
                    listarCliente();
                    break;
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
            inpOpcao =  scan.next();
            if("D".equals(inpOpcao)|| "d".equals(inpOpcao)){
                if (vendedor.get(inpNumeroVendedor).getLogin().equals(inpLogin)){
                    System.out.println("Impossivel deletar o proprio usuario");                   
                    listarVendedor();
                    
                }
            }
            if("D".equals(inpOpcao)|| "d".equals(inpOpcao)){
                deletarVendedor(inpNumeroVendedor);  
                System.out.println("1 - Retornar para o Menu");
                System.out.println("2 - Olhar novamente a lista de vendedores");
                System.out.println("3 - Finalizar");
                inpDigito = scan.nextInt();
                switch (inpDigito){
                
                    case 1:
                        newSessao();
                        break;
                    case 2:
                        listarVendedor();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opcao invalida finalizando Programa");
                        break;                             
                }
                }else if("E".equals(inpOpcao) || "e".equals(inpOpcao)){                  
                    editarVendedor(inpNumeroVendedor);
                    System.out.println("1 - Retornar para o Menu");
                    System.out.println("2 - Olhar novamente a lista de vendedores");
                    System.out.println("3 - Finalizar");
                    inpDigito = scan.nextInt();
                    switch (inpDigito){

                        case 1:
                            newSessao();
                            break;
                        case 2:
                            listarVendedor();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Opcao invalida finalizando Programa");
                            break;                             
                    }
                }else{
                    System.out.println("Digite uma opção valida");
                    listarVendedor();
                }
            
                
        }else{
            int dadosPessoais = 0;
            for(int i = 0; i<vendedor.size(); i ++){
                if (vendedor.get(i).getLogin().equals(inpLogin)){
                    dadosPessoais = i;
                }  
                System.out.println("|---- " + i + ") " + vendedor.get(i).getNome() + " " +  vendedor.get(i).getSobrenome() + " - " +  vendedor.get(i).getCPF());
            }
            System.out.println("|---- Digite 1 para editar seus dados \n|---- Ou digite 2 para sair");
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
    public void listarCliente() {
        Scanner scan = new Scanner(System.in);
        
        if ("vendedorAdm".equals(validaPapel)){
            System.out.println("|---- Menu Vendedor ----|");
            System.out.println("|---- Escolha uma opcao ----|");
            for(int i = 0; i < cliente.size(); i = i + 1){          
                System.out.println("|---- " + i + ") " + cliente.get(i).getNome() + " " +  cliente.get(i).getSobrenome() + " - " +  cliente.get(i).getCPF());
            }
            System.out.println("|---- Escolha o numero do Cliente ----|");
            inpNumeroCliente = scan.nextInt();
            System.out.println("|---- D para DELETAR, ou E para EDITAR ----|");
            inpOpcao =  scan.next();

            if("D".equals(inpOpcao)|| "d".equals(inpOpcao)){
                deletarCliente(inpNumeroCliente);  
                System.out.println("1 - Retornar para o Menu");
                System.out.println("2 - Olhar novamente a lista de Clientes");
                System.out.println("3 - Finalizar");
                inpDigito = scan.nextInt();
                switch (inpDigito){
                
                    case 1:
                        newSessao();
                        break;
                    case 2:
                        listarCliente();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opcao invalida finalizando Programa");
                        break;                             
                }
                }else if("E".equals(inpOpcao) || "e".equals(inpOpcao)){                  
                    editarCliente(inpNumeroCliente);
                    System.out.println("1 - Retornar para o Menu");
                    System.out.println("2 - Olhar novamente a lista de Clientes");
                    System.out.println("3 - Finalizar");
                    inpDigito = scan.nextInt();
                    switch (inpDigito){

                        case 1:
                            newSessao();
                            break;
                        case 2:
                            listarCliente();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Opcao invalida finalizando Programa");
                            break;                             
                    }
                }else{
                    System.out.println("Digite uma opção valida");
                    listarCliente();
                }
            
                
        }else{
            int auxiliar = 0;
            for(int i = 0; i < cliente.size(); i = i + 1){          
                System.out.println("|---- " + i + ") " + cliente.get(i).getNome() + " " +  cliente.get(i).getSobrenome() + " - " +  cliente.get(i).getCPF());
                auxiliar = i;
            }
            System.out.println("|---- Digite 1 para editar seus dados \n|---- Ou digite 2 para sair");
            inpDigito = scan.nextInt();
            while(inpDigito != 2 && inpDigito != 1){
                System.out.println("|---- Digite 1 para editar seus dados \n |---- Ou digite 2 para sair");
                inpDigito = scan.nextInt();
            }
            if(inpDigito == 1){
                editarCliente(auxiliar);
            }
        }
    }
    public void listarFornecedor() {
        Scanner scan = new Scanner(System.in);
        
        if ("vendedorAdm".equals(validaPapel)){
            System.out.println("|---- Menu Vendedor ----|");
            System.out.println("|---- Escolha uma opcao ----|");
            for(int i = 0; i < fornecedor.size(); i = i + 1){          
                System.out.println("|---- " + i + ") " + fornecedor.get(i).getNomeFantasia() + " " +  fornecedor.get(i).getRazaoSocial() + " - " +  fornecedor.get(i).getCNPJ());
            }
            System.out.println("|---- Escolha o numero do Fornecedor ----|");
            inpNumeroFornecedor = scan.nextInt();
            System.out.println("|---- D para DELETAR, ou E para EDITAR ----|");
            inpOpcao =  scan.next();

            if("D".equals(inpOpcao)|| "d".equals(inpOpcao)){
                deletarCliente(inpNumeroFornecedor);  
                System.out.println("1 - Retornar para o Menu");
                System.out.println("2 - Olhar novamente a lista de Fornecedor");
                System.out.println("3 - Finalizar");
                inpDigito = scan.nextInt();
                switch (inpDigito){
                
                    case 1:
                        newSessao();
                        break;
                    case 2:
                        listarFornecedor();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opcao invalida finalizando Programa");
                        break;                             
                }
                }else if("E".equals(inpOpcao) || "e".equals(inpOpcao)){                  
                    editarCliente(inpNumeroFornecedor);
                    System.out.println("1 - Retornar para o Menu");
                    System.out.println("2 - Olhar novamente a lista de Fornecedor");
                    System.out.println("3 - Finalizar");
                    inpDigito = scan.nextInt();
                    switch (inpDigito){

                        case 1:
                            newSessao();
                            break;
                        case 2:
                            listarFornecedor();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Opcao invalida finalizando Programa");
                            break;                             
                    }
                }else{
                    System.out.println("Digite uma opção valida");
                    listarFornecedor();
                }
            
                
        }else{
            int auxiliar = 0;
            for(int i = 0; i < fornecedor.size(); i = i + 1){          
                System.out.println("|---- " + i + ") " + fornecedor.get(i).getNomeFantasia() + " " +  fornecedor.get(i).getRazaoSocial() + " - " +  fornecedor.get(i).getCNPJ());
                auxiliar = i;
            }
            System.out.println("|---- Digite 1 para editar seus dados \n|---- Ou digite 2 para sair");
            inpDigito = scan.nextInt();
            while(inpDigito != 2 && inpDigito != 1){
                System.out.println("|---- Digite 1 para editar seus dados \n |---- Ou digite 2 para sair");
                inpDigito = scan.nextInt();
            }
            if(inpDigito == 1){
                editarFornecedor(auxiliar);
            }
        }
    }
    public void cadastraVendedor() {
 
        
    }
    public void deletarCliente(int i) {
        cliente.remove(i);
    }
    public void deletarVendedor(int i) {
        vendedor.remove(i);
    }
    public void editarCliente(int i) {
        Scanner scan = new Scanner(System.in);
        int inpOpcaoEdicao;
        String novo;
        int numero;
        //passar como parametro a posição do cliente a ser editado
        //fake limpa tela
        for (int count = 0; count < 50; ++count) System.out.println();
        //
        System.out.println("|---- Menu Editar Cliente ----|");
        System.out.println("|---- Escolha o numero da opção a ser editada ----|");
        System.out.println("|---- 1 - " +cliente.get(i).getNome());
        System.out.println("|---- 2 - " +cliente.get(i).getSobrenome());
        System.out.println("|---- 3 - " +cliente.get(i).getDatanascimento());
        System.out.println("|---- 4 - " +cliente.get(i).getTelefone());
        System.out.println("|---- 5 - " +cliente.get(i).getCPF());
        System.out.println("|---- 6 - " +cliente.get(i).getCidade());
        System.out.println("|---- 7 - " +cliente.get(i).getEstado());
        System.out.println("|---- 8 - " +cliente.get(i).getPais());
        System.out.println("|---- 9 - " +cliente.get(i).getEndereco());
        System.out.println("|---- 10 - " +cliente.get(i).getDataCadastro());
        System.out.println("|---- 11 - " +cliente.get(i).getNumero());

        inpOpcaoEdicao = scan.nextInt();
        switch(inpOpcaoEdicao){
            case 1:
                System.out.println("|---- Menu Cliente ----|");
                System.out.println("|---- Digite o novo NOME ----|");
                System.out.print("|---- ");
                novo = scan.next();
                cliente.get(i).setNome(novo);
                System.out.println("NOME alteradado para: " +cliente.get(i).getNome());
                break;
            case 2:
                System.out.println("|---- Menu cliente ----|");
                System.out.println("|---- Digite o novo SOBRENOME ----|");
                System.out.print("|---- ");
                novo = scan.next();
                cliente.get(i).setSobrenome(novo);
                System.out.println("SOBRENOME alteradado para: " +cliente.get(i).getSobrenome());
                break;
            case 3:
                System.out.println("|---- Menu cliente ----|");
                System.out.println("|---- Digite a nova DATA DE NASCIMENTO ----|");
                System.out.print("|---- ");
                novo = scan.next();
                cliente.get(i).setDatanascimento(novo);
                System.out.println("DATA DE NASCIMENTO alteradado para: " +cliente.get(i).getDatanascimento());
                break;
            case 4:
                System.out.println("|---- Menu cliente ----|");
                System.out.println("|---- Digite o novo TELEFONE ----|");
                System.out.print("|---- ");
                novo = scan.next();
                cliente.get(i).setTelefone(novo);
                System.out.println("TELEFONE alteradado para: " +cliente.get(i).getTelefone());
                break;
            case 5:
                System.out.println("|---- Menu cliente ----|");
                System.out.println("|---- Digite o novo CPF ----|");
                System.out.print("|---- ");
                novo = scan.next();
                cliente.get(i).setCPF(novo);
                System.out.println("CPF alteradado para: " +cliente.get(i).getCPF());
                break;
            case 6:
                System.out.println("|---- Menu cliente ----|");
                System.out.println("|---- Digite a nova CIDADE ----|");
                System.out.print("|---- ");
                novo = scan.next();
                cliente.get(i).setCidade(novo);
                System.out.println("CIDADE alteradado para: " +cliente.get(i).getCidade());
                break;
            case 7:
                System.out.println("|---- Menu cliente ----|");
                System.out.println("|---- Digite o novo ESTADO ----|");
                System.out.print("|---- ");
                novo = scan.next();
                cliente.get(i).setEstado(novo);
                System.out.println("ESTADO alteradado para: " +cliente.get(i).getEstado());
                break;
            case 8:
                System.out.println("|---- Menu cliente ----|");
                System.out.println("|---- Digite o novo PAIS ----|");
                System.out.print("|---- ");
                novo = scan.next();
                cliente.get(i).setPais(novo);
                System.out.println("PAIS alteradado para: " +cliente.get(i).getPais());
                break;
            case 9:
                System.out.println("|---- Menu cliente ----|");
                System.out.println("|---- Digite o novo ENDEREÇO ----|");
                System.out.print("|---- ");
                novo = scan.next();
                cliente.get(i).setEndereco(novo);
                System.out.println("ENDEREÇO alteradado para: " +cliente.get(i).getEndereco());
                break;
            case 10:
                System.out.println("A data de cadastro não pode ser alterada, contate o Administador");
                editarCliente(i);
                break;
            case 11:
                System.out.println("|---- Menu cliente ----|");
                System.out.println("|---- Digite o novo numero ----|");
                System.out.print("|---- ");
                numero = scan.nextInt();
                cliente.get(i).setNumero(numero);
                System.out.println("Numero alteradado para: " +cliente.get(i).getNumero());
                break;

            default:
                System.out.println("Numero inexistente");
                editarCliente(i);
        }
    } 
    public void editarFornecedor(int i) {
        Scanner scan = new Scanner(System.in);
        int inpOpcaoEdicao;
        String novo;
        int numero;
        //passar como parametro a posição do cliente a ser editado
        //fake limpa tela
        for (int count = 0; count < 50; ++count) System.out.println();
        //
        System.out.println("|---- Menu Editar Fornecedor ----|");
        System.out.println("|---- Escolha o numero da opção a ser editada ----|");
        System.out.println("|---- 1 - " +fornecedor.get(i).getNomeFantasia());
        System.out.println("|---- 2 - " +fornecedor.get(i).getNomeFantasia());
        System.out.println("|---- 3 - " +fornecedor.get(i).getCNPJ());
        System.out.println("|---- 4 - " +fornecedor.get(i).getEmail());
        System.out.println("|---- 5 - " +fornecedor.get(i).getTelefone());
        System.out.println("|---- 6 - " +fornecedor.get(i).getCidade());
        System.out.println("|---- 7 - " +fornecedor.get(i).getEstado());
        System.out.println("|---- 8 - " +fornecedor.get(i).getPais());
        System.out.println("|---- 9 - " +fornecedor.get(i).getNumero());
        System.out.println("|---- 10 - "+fornecedor.get(i).getDataCadastro());
        

        inpOpcaoEdicao = scan.nextInt();
        switch(inpOpcaoEdicao){
            case 1:
                System.out.println("|---- Menu Fornecedor ----|");
                System.out.println("|---- Digite o novo NOME Fantasia ----|");
                System.out.print("|---- ");
                novo = scan.next();
                fornecedor.get(i).setNomeFantasia(novo);
                System.out.println("NOME Fantasia alteradado para: " +fornecedor.get(i).getNomeFantasia());
                break;
            case 2:
                System.out.println("|---- Menu Fornecedor ----|");
                System.out.println("|---- Digite o novo Razao Social ----|");
                System.out.print("|---- ");
                novo = scan.next();
                fornecedor.get(i).setRazaoSocial(novo);
                System.out.println("Razao Social  alteradado para: " +fornecedor.get(i).getRazaoSocial());
                break;
            case 3:
                System.out.println("|---- Menu Fornecedor ----|");
                System.out.println("|---- Digite o novo CNPJ ----|");
                System.out.print("|---- ");
                novo = scan.next();
                fornecedor.get(i).setCNPJ(novo);
                System.out.println("CNPJ alteradado para: " +fornecedor.get(i).getCNPJ());
                break;
            case 4:
                System.out.println("|---- Menu cliente ----|");
                System.out.println("|---- Digite o novo TELEFONE ----|");
                System.out.print("|---- ");
                novo = scan.next();
                cliente.get(i).setTelefone(novo);
                System.out.println("TELEFONE alteradado para: " +cliente.get(i).getTelefone());
                break;
            case 5:
                System.out.println("|---- Menu cliente ----|");
                System.out.println("|---- Digite o novo CPF ----|");
                System.out.print("|---- ");
                novo = scan.next();
                cliente.get(i).setCPF(novo);
                System.out.println("CPF alteradado para: " +cliente.get(i).getCPF());
                break;
            case 6:
                System.out.println("|---- Menu cliente ----|");
                System.out.println("|---- Digite a nova CIDADE ----|");
                System.out.print("|---- ");
                novo = scan.next();
                cliente.get(i).setCidade(novo);
                System.out.println("CIDADE alteradado para: " +cliente.get(i).getCidade());
                break;
            case 7:
                System.out.println("|---- Menu cliente ----|");
                System.out.println("|---- Digite o novo ESTADO ----|");
                System.out.print("|---- ");
                novo = scan.next();
                cliente.get(i).setEstado(novo);
                System.out.println("ESTADO alteradado para: " +cliente.get(i).getEstado());
                break;
            case 8:
                System.out.println("|---- Menu cliente ----|");
                System.out.println("|---- Digite o novo PAIS ----|");
                System.out.print("|---- ");
                novo = scan.next();
                cliente.get(i).setPais(novo);
                System.out.println("PAIS alteradado para: " +cliente.get(i).getPais());
                break;
            case 9:
                System.out.println("|---- Menu cliente ----|");
                System.out.println("|---- Digite o novo ENDEREÇO ----|");
                System.out.print("|---- ");
                novo = scan.next();
                cliente.get(i).setEndereco(novo);
                System.out.println("ENDEREÇO alteradado para: " +cliente.get(i).getEndereco());
                break;
            case 10:
                System.out.println("A data de cadastro não pode ser alterada, contate o Administador");
                editarCliente(i);
                break;
            case 11:
                System.out.println("|---- Menu cliente ----|");
                System.out.println("|---- Digite o novo numero ----|");
                System.out.print("|---- ");
                numero = scan.nextInt();
                cliente.get(i).setNumero(numero);
                System.out.println("Numero alteradado para: " +cliente.get(i).getNumero());
                break;

            default:
                System.out.println("Numero inexistente");
                editarCliente(i);
        }
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
                System.out.println("SOBRENOME alteradado para: " +vendedor.get(i).getSobrenome());
                break;
            case 3:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite a nova DATA DE NASCIMENTO ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setDatanascimento(novo);
                System.out.println("DATA DE NASCIMENTO alteradado para: " +vendedor.get(i).getDatanascimento());
                break;
            case 4:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite o novo TELEFONE ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setTelefone(novo);
                System.out.println("TELEFONE alteradado para: " +vendedor.get(i).getTelefone());
                break;
            case 5:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite o novo CPF ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setCPF(novo);
                System.out.println("CPF alteradado para: " +vendedor.get(i).getCPF());
                break;
            case 6:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite a nova CIDADE ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setCidade(novo);
                System.out.println("CIDADE alteradado para: " +vendedor.get(i).getCidade());
                break;
            case 7:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite o novo ESTADO ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setEstado(novo);
                System.out.println("ESTADO alteradado para: " +vendedor.get(i).getEstado());
                break;
            case 8:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite o novo PAIS ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setPais(novo);
                System.out.println("PAIS alteradado para: " +vendedor.get(i).getPais());
                break;
            case 9:
                System.out.println("|---- Menu Vendedor ----|");
                System.out.println("|---- Digite o novo ENDEREÇO ----|");
                System.out.print("|---- ");
                novo = scan.next();
                vendedor.get(i).setEndereco(novo);
                System.out.println("ENDEREÇO alteradado para: " +vendedor.get(i).getEndereco());
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
                System.out.println("SENHA alteradado para: " +vendedor.get(i).getSenha());
                break;
            default:
                System.out.println("Numero inexistente");
                editarVendedor(i);
        }
    } 
     
}
