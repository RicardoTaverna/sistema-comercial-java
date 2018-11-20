/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacomercial;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static sistemacomercial.SistemaComercial.vendedor;
import static sistemacomercial.SistemaComercial.cliente;
import static sistemacomercial.SistemaComercial.fornecedor;
import static sistemacomercial.SistemaComercial.produto;



/**
 *
 * @author taverna, yago, milico
 */
public class Sessao{
   private String inpLogin, inpSenha, validaPapel;
   private boolean validador = false;
   private int inpMenuVendedor, inpDigito, inpNumeroVendedor,inpNumeroCliente,inpNumeroFornecedor,inpNumeroProduto;
   private String inpOpcao;
    
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
                    cadastraCliente();
                    break;
                case 3:
                    cadastraFornecedor();
                    break;
                case 4:
                    cadastraProduto();
                    break;
                case 5:
                    listarVendedor();
                    break;
                case 6:
                    listarCliente();
                    break;
                case 7:
                    listarFornecedor();
                    break;
                case 8:
                    listarProduto();
                    break;
                case 9:
                    registrarVenda();
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
                deletarFornecedor(inpNumeroFornecedor);  
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
                    editarFornecedor(inpNumeroFornecedor);
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
    public void listarProduto() {
        Scanner scan = new Scanner(System.in);
        
        if ("vendedorAdm".equals(validaPapel)){
            System.out.println("|---- Menu Produto ----|");
            System.out.println("|---- Escolha uma opcao ----|");
            for(int i = 0; i < produto.size(); i = i + 1){          
                System.out.println("|---- " + i + ") " + produto.get(i).getNome() + " " +  produto.get(i).getDescricao());
            }
            System.out.println("|---- Escolha o numero do Produto ----|");
            inpNumeroProduto = scan.nextInt();
            System.out.println("|---- D para DELETAR, ou E para EDITAR ----|");
            inpOpcao =  scan.next();

            if("D".equals(inpOpcao)|| "d".equals(inpOpcao)){
                deletarProduto(inpNumeroProduto);  
                System.out.println("1 - Retornar para o Menu");
                System.out.println("2 - Olhar novamente a lista de Produtos");
                System.out.println("3 - Finalizar");
                inpDigito = scan.nextInt();
                switch (inpDigito){
                
                    case 1:
                        newSessao();
                        break;
                    case 2:
                        listarProduto();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opcao invalida Voltar para o menu");
                        newSessao();
                                                     
                }
                }else if("E".equals(inpOpcao) || "e".equals(inpOpcao)){                  
                    editarProduto(inpNumeroProduto);
                    System.out.println("1 - Retornar para o Menu");
                    System.out.println("2 - Olhar novamente a lista de Produto");
                    System.out.println("3 - Finalizar");
                    inpDigito = scan.nextInt();
                    switch (inpDigito){

                        case 1:
                            newSessao();
                            break;
                        case 2:
                            listarProduto();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Opcao invalida retornando ao Menu");
                            newSessao();                            
                    }
                }else{
                    System.out.println("Digite uma opção valida");
                    listarProduto();
                }
            
                
        }else{
            System.out.println("|---- Menu Produto ----|");
            System.out.println("|---- Escolha uma opcao ----|");
            for(int i = 0; i < produto.size(); i = i + 1){          
                System.out.println("|---- " + i + ") " + produto.get(i).getNome() + " " +  produto.get(i).getDescricao());
            }
            System.out.println("|---- Escolha o numero do Produto ----|");
            inpNumeroProduto = scan.nextInt();
            System.out.println("|---- E para EDITAR ou S para sair ----|");
            inpOpcao =  scan.next();
            if("E".equals(inpOpcao) || "e".equals(inpOpcao)){                  
                    editarProduto(inpNumeroProduto);
                    System.out.println("1 - Retornar para o Menu");
                    System.out.println("2 - Olhar novamente a lista de Produto");
                    System.out.println("3 - Finalizar");
                    inpDigito = scan.nextInt();
                    switch (inpDigito){

                        case 1:
                            newSessao();
                            break;
                        case 2:
                            listarProduto();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Opcao invalida retornando ao Menu");
                            newSessao();                            
                    }
                }else{
                    newSessao();
                }
        }
    }
    public void cadastraVendedor() {
        Scanner scan = new Scanner(System.in);
        String tempnome, tempsobrenome, tempdatanascimento, temptelefone, tempCPF, tempcidade, tempestado, temppais, tempendereco, tempdataCadastro, templogin, tempsenha, temppapel;
        int inptOpcao;
        System.out.println("|---- Menu Cadastrar Vendedor ----|");
        System.out.print("Digite o NOME: ");
        tempnome = scan.next();
        System.out.print("Digite o SOBRENOME: ");
        tempsobrenome = scan.next();
        System.out.print("Digite a DATA DE NASCIMENTO(dd/mm/aaaa): ");
        tempdatanascimento = scan.next();
        System.out.print("Digite o TELEFONE: ");
        temptelefone = scan.next();
        System.out.print("Digite o CPF: ");
        tempCPF = scan.next();
        System.out.print("Digite a CIDADE: ");
        tempcidade = scan.next();
        System.out.print("Digite o ESTADO: ");
        tempestado = scan.next();
        System.out.print("Digite o PAIS: ");
        temppais = scan.next();
        System.out.print("Digite o ENDEREÇO: ");
        tempendereco = scan.next();        
        if ("vendedorAdm".equals(validaPapel)){
            System.out.print("Digite o PAPEL(vendedor-administrador): ");
            temppapel = scan.next();
        }else{
            temppapel ="vendedor";
        }
        
        //pegar a data de cadastro automatico do sistema através da biblioteca java.utils.Date
        Date data = new Date();
        tempdataCadastro = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(data);
        
        //login criado automatico utilizando 1 nome . sobrenome
        templogin = (tempnome + "." + tempsobrenome);
        
        //senha criada automaticamente atravez da 1 letra do nome 1 letra do sobrenome @ ano de nascimento
        tempsenha = (tempnome.substring(0, 1) + tempsobrenome.substring(0, 1) + "@" + tempdatanascimento.substring(6, 10));
                
        Vendedor tempVendedor = new Vendedor(tempnome, tempsobrenome, tempdatanascimento, temptelefone, tempCPF, tempcidade, tempestado, temppais, tempendereco, tempdataCadastro, templogin, tempsenha, temppapel, vendedor);
        
        System.out.println("|---- Cadastrado o vendedor " + tempVendedor.getNome());
        System.out.println("|---- Seu login: " + tempVendedor.getLogin());
        System.out.println("|---- Sua senha: " + tempVendedor.getSenha());
        System.out.println("|---- Data de Cadastro: " + tempVendedor.getDataCadastro());
        System.out.println("|---- Escolha uma opção abaixo ---|");
        System.out.println("|---- 1) Concluir");
        System.out.println("|---- 2) Adicionar outro vendedor");
        System.out.print("|---- Opcao: ");
        inptOpcao = scan.nextInt();
        switch(inptOpcao){
            case 1:
                
                break;
            case 2:
                cadastraVendedor();
                break;
            default:
                System.out.println("Opção invalida, retornando ao menu principal");
                newSessao();
        }
        
    }
    public void cadastraCliente() {
        Scanner scan = new Scanner(System.in);
        String tempnome, tempsobrenome, tempdatanascimento, temptelefone, tempCPF, tempcidade, tempestado, temppais, tempendereco,tempnumero, tempdataCadastro;
        int inptOpcao;
        System.out.println("|---- Menu Cadastrar Cliente ----|");
        System.out.print("Digite o NOME: ");
        tempnome = scan.next();
        System.out.print("Digite o SOBRENOME: ");
        tempsobrenome = scan.next();
        System.out.print("Digite a DATA DE NASCIMENTO(dd/mm/aaaa): ");
        tempdatanascimento = scan.next();
        System.out.print("Digite o TELEFONE: ");
        temptelefone = scan.next();
        System.out.print("Digite o CPF: ");
        tempCPF = scan.next();
        System.out.print("Digite a CIDADE: ");
        tempcidade = scan.next();
        System.out.print("Digite o ESTADO: ");
        tempestado = scan.next();
        System.out.print("Digite o PAIS: ");
        temppais = scan.next();
        System.out.print("Digite o ENDEREÇO: ");
        tempendereco = scan.next();    
        System.out.print("Digite o Numero: ");
        tempnumero = scan.next();  
 
        
        //pegar a data de cadastro automatico do sistema através da biblioteca java.utils.Date
        Date data = new Date();
        tempdataCadastro = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(data);
               
                
        Cliente tempCliente = new Cliente(tempnome, tempsobrenome, tempdatanascimento, temptelefone, tempCPF, tempcidade, tempestado, temppais, tempendereco,tempnumero, tempdataCadastro, cliente);
        
        System.out.println("|---- Cadastrado o Cliente " + tempCliente.getNome());
        System.out.println("|---- Data de Cadastro: " + tempCliente.getDataCadastro());
        System.out.println("|---- Escolha uma opção abaixo ---|");
        System.out.println("|---- 1) Concluir");
        System.out.println("|---- 2) Adicionar outro vendedor");
        System.out.print("|---- Opcao: ");
        inptOpcao = scan.nextInt();
        switch(inptOpcao){
            case 1:
                
                break;
            case 2:
                cadastraCliente();
                break;
            default:
                System.out.println("Opção invalida, retornando ao menu principal");
                newSessao();
        }
        
    }  
    public void cadastraProduto() {
        Fornecedor tempFornecedor;
        
        Scanner scan = new Scanner(System.in);
        String tempnome, tempdescricao;
        int inptOpcao,tempquantidade;
        double temppreco;
        System.out.println("|---- Menu Cadastrar Produto ----|");
        System.out.print("Digite o NOME: ");
        tempnome = scan.nextLine();
        System.out.print("Digite a Descricao: ");
        tempdescricao = scan.nextLine();
        System.out.print("Digite a Quantidade: ");
        tempquantidade = scan.nextInt();
        System.out.print("Digite o Preco: ");
        temppreco = scan.nextDouble();             
        int posicaoFornecedor;
       
        for(int i = 0; i < fornecedor.size(); i = i + 1){          
            System.out.println("|---- " + i + ") " + fornecedor.get(i).getNomeFantasia() + " " +  fornecedor.get(i).getRazaoSocial() + " - " +  fornecedor.get(i).getCNPJ());
        }
        System.out.print("Digite o FORNECEDOR: ");
        System.out.println("|---- Selecione a posição do forncedor ----|");        
        posicaoFornecedor = scan.nextInt();
        tempFornecedor = fornecedor.get(posicaoFornecedor);
                                    
        Produto tempProduto = new Produto(tempnome, tempdescricao, tempquantidade, temppreco, tempFornecedor, produto);
        
        System.out.println("|---- Cadastrado o Produto " + tempProduto.getNome());
        System.out.println("|---- Escolha uma opção abaixo ---|");
        System.out.println("|---- 1) Concluir");
        System.out.println("|---- 2) Adicionar outro Produto");
        System.out.print("|---- Opcao: ");
        inptOpcao = scan.nextInt();
        switch(inptOpcao){
            case 1:
                
                break;
            case 2:
                cadastraProduto();
                break;
            default:
                System.out.println("Opção invalida, retornando ao menu principal");
                newSessao();
        }
        
    }
    public void cadastraFornecedor() {
        Scanner scan = new Scanner(System.in);
        String tempnome, temprazaosocial, tempemail, temptelefone, tempCNPJ, tempcidade, tempestado, temppais, tempendereco,tempnumero, tempdataCadastro;
        int inptOpcao;
        System.out.println("|---- Menu Cadastrar Fornecedor ----|");
        System.out.print("Digite o NOME Fantasia: ");
        tempnome = scan.next();
        System.out.print("Digite a Razao Social: ");
        temprazaosocial = scan.next();
        System.out.print("Digite o E-mail): ");
        tempemail = scan.next();
        System.out.print("Digite o TELEFONE: ");
        temptelefone = scan.next();
        System.out.print("Digite o CNPJ: ");
        tempCNPJ = scan.next();
        System.out.print("Digite a CIDADE: ");
        tempcidade = scan.next();
        System.out.print("Digite o ESTADO: ");
        tempestado = scan.next();
        System.out.print("Digite o PAIS: ");
        temppais = scan.next();
        System.out.print("Digite o ENDEREÇO: ");
        tempendereco = scan.next();    
        System.out.print("Digite o Numero: ");
        tempnumero = scan.next();  
 
        
        //pegar a data de cadastro automatico do sistema através da biblioteca java.utils.Date
        Date data = new Date();
        tempdataCadastro = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(data);
               
                
        Fornecedor tempFornecedor = new Fornecedor(tempnome, temprazaosocial, tempemail, temptelefone, tempCNPJ, tempcidade, tempestado, temppais, tempendereco,tempnumero, tempdataCadastro, fornecedor);
        
        System.out.println("|---- Cadastrado o Fornecedor" + tempFornecedor.getNomeFantasia());
        System.out.println("|---- Data de Cadastro: " + tempFornecedor.getDataCadastro());
        System.out.println("|---- Escolha uma opção abaixo ---|");
        System.out.println("|---- 1) Concluir");
        System.out.println("|---- 2) Adicionar outro vendedor");
        System.out.print("|---- Opcao: ");
        inptOpcao = scan.nextInt();
        switch(inptOpcao){
            case 1:
                
                break;
            case 2:
                cadastraFornecedor();
                break;
            default:
                System.out.println("Opção invalida, retornando ao menu principal");
                newSessao();
        }
        
    }
    
    public void deletarCliente(int i) {
        cliente.remove(i);
    }
    public void deletarVendedor(int i) {
        vendedor.remove(i);
    }
    public void deletarFornecedor(int i) {
        fornecedor.remove(i);
    }
    public void deletarProduto(int i) {
        produto.remove(i);
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
                novo = scan.next();
                cliente.get(i).setNumero(novo);
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
        
        //passar como parametro a posição do fornecedor a ser editado
        //fake limpa tela
        for (int count = 0; count < 50; ++count) System.out.println();
        //
        System.out.println("|---- Menu Editar Fornecedor ----|");
        System.out.println("|---- Escolha o numero da opção a ser editada ----|");
        System.out.println("|---- 1 - " +fornecedor.get(i).getNomeFantasia());
        System.out.println("|---- 2 - " +fornecedor.get(i).getRazaoSocial());
        System.out.println("|---- 3 - " +fornecedor.get(i).getCNPJ());
        System.out.println("|---- 4 - " +fornecedor.get(i).getEmail());
        System.out.println("|---- 5 - " +fornecedor.get(i).getTelefone());
        System.out.println("|---- 6 - " +fornecedor.get(i).getCidade());
        System.out.println("|---- 7 - " +fornecedor.get(i).getEstado());
        System.out.println("|---- 8 - " +fornecedor.get(i).getPais());
        System.out.println("|---- 9 - " +fornecedor.get(i).getEndereco());
        System.out.println("|---- 10 - " +fornecedor.get(i).getNumero());
        System.out.println("|---- 11 - "+fornecedor.get(i).getDataCadastro());
        

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
                System.out.println("|---- Menu Fornecedor ----|");
                System.out.println("|---- Digite o novo E-mail ----|");
                System.out.print("|---- ");
                novo = scan.next();
                fornecedor.get(i).setEmail(novo);
                System.out.println("Email alteradado para: " +fornecedor.get(i).getEmail());
                break;
            case 5:
                System.out.println("|---- Menu Fornecedor ----|");
                System.out.println("|---- Digite o novo Telefone ----|");
                System.out.print("|---- ");
                novo = scan.next();
                fornecedor.get(i).setTelefone(novo);
                System.out.println("Telefone alteradado para: " +fornecedor.get(i).getTelefone());
                break;
            case 6:
                System.out.println("|---- Menu Fornecedor ----|");
                System.out.println("|---- Digite a nova CIDADE ----|");
                System.out.print("|---- ");
                novo = scan.next();
                fornecedor.get(i).setCidade(novo);
                System.out.println("CIDADE alteradado para: " +fornecedor.get(i).getCidade());
                break;
            case 7:
                System.out.println("|---- Menu Fornecedor ----|");
                System.out.println("|---- Digite o novo ESTADO ----|");
                System.out.print("|---- ");
                novo = scan.next();
                fornecedor.get(i).setEstado(novo);
                System.out.println("ESTADO alteradado para: " +fornecedor.get(i).getEstado());
                break;
            case 8:
                System.out.println("|---- Menu fornecedor ----|");
                System.out.println("|---- Digite o novo PAIS ----|");
                System.out.print("|---- ");
                novo = scan.next();
                fornecedor.get(i).setPais(novo);
                System.out.println("PAIS alteradado para: " +fornecedor.get(i).getPais());
                break;
            case 9:
                System.out.println("|---- Menu fornecedor ----|");
                System.out.println("|---- Digite o novo ENDEREÇO ----|");
                System.out.print("|---- ");
                novo = scan.next();
                fornecedor.get(i).setEndereco(novo);
                System.out.println("ENDEREÇO alteradado para: " +fornecedor.get(i).getEndereco());
                break;
            case 10:
                System.out.println("|---- Menu Fornecedor ----|");
                System.out.println("|---- Digite o novo numero ----|");
                System.out.print("|---- ");
                novo = scan.next();
                fornecedor.get(i).setNumero(novo);
                System.out.println("Numero alteradado para: " +fornecedor.get(i).getNumero());
                break;
                
            case 11:
                System.out.println("A data de cadastro não pode ser alterada, contate o Administador");
                editarFornecedor(i);
                break;

            default:
                System.out.println("Numero inexistente");
                editarFornecedor(i);
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
    public void editarProduto(int i) {
        Scanner scan = new Scanner(System.in);
        int inpOpcaoEdicao;
        String novo;
        int numero;
        //passar como parametro a posição do cliente a ser editado
        //fake limpa tela
        for (int count = 0; count < 50; ++count) System.out.println();
        //
        System.out.println("|---- Menu Editar Produto ----|");
        System.out.println("|---- Escolha o numero da opção a ser editada ----|");
        System.out.println("|---- 1 - " +produto.get(i).getNome());
        System.out.println("|---- 2 - " +produto.get(i).getDescricao());
        System.out.println("|---- 3 - " +produto.get(i).getQuantidade());
        System.out.println("|---- 4 - " +produto.get(i).getPreco());
        System.out.println("|---- 5 - " +produto.get(i).getFornecedornome());


        inpOpcaoEdicao = scan.nextInt();
        switch(inpOpcaoEdicao){
            case 1:
                System.out.println("|---- Menu Produto ----|");
                System.out.println("|---- Digite o novo NOME ----|");
                System.out.print("|---- ");
                novo = scan.nextLine();
                produto.get(i).setNome(novo);
                System.out.println("NOME alteradado para: " +produto.get(i).getNome());
                break;
            case 2:
                System.out.println("|---- Menu Produto ----|");
                System.out.println("|---- Digite Uma nova Descricao ----|");
                System.out.print("|---- ");
                novo = scan.nextLine();
                produto.get(i).setDescricao(novo);
                System.out.println("Descricao alteradada para: " +produto.get(i).getDescricao());
                break;
            case 3:
                System.out.println("|---- Menu Produto ----|");
                System.out.println("|---- Digite a nova Quantidade ----|");
                System.out.print("|---- ");
                int nova = scan.nextInt();
                produto.get(i).setQuantidade(nova);
                System.out.println("Quantidade alteradada para: " +produto.get(i).getQuantidade());
                break;
            case 4:
                System.out.println("|---- Menu Produto ----|");
                System.out.println("|---- Digite o novo Preco ----|");
                System.out.print("|---- ");
                double novaD = scan.nextDouble();
                produto.get(i).setPreco(novaD);
                System.out.println("Preco alteradado para: " +produto.get(i).getPreco());
                break;
            case 5:
                System.out.println("|---- Menu Produto ----|");
                for(int j = 0; j < fornecedor.size(); j = j + 1){          
                    System.out.println("|---- " + j + ") " + fornecedor.get(j).getNomeFantasia() + " " +  fornecedor.get(j).getRazaoSocial() + " - " +  fornecedor.get(j).getCNPJ());
                }
                System.out.println("|---- Digite o novo Fornecedor ----|");
                System.out.print("|---- ");
                int posicaoFornecedor = scan.nextInt();
                Fornecedor tempFornecedor = fornecedor.get(posicaoFornecedor);
                produto.get(i).setFornecedor(tempFornecedor);
                System.out.println("Fornecedor alteradado para: " +produto.get(i).getFornecedornome());
                break;                                            
            default:
                System.out.println("Numero inexistente");
                editarProduto(i);
        }
    } 
    
    public void registrarVenda(){
        Scanner scan = new Scanner(System.in);
        String vendedorVenda, clienteVenda, produtoVenda,achou = null;
        int produtoQtdeVenda,validaProduto = 0;
        Vendedor tempVendedor;
        Cliente tempCliente;
        Produto tempProduto;
        
        System.out.println("|---- Menu Registrar Venda ----|");
        System.out.println("Lista de Vendedores:");
        for(int i = 0; i < vendedor.size(); i = i + 1){             
            System.out.println(vendedor.get(i).getNome());        
        }
        System.out.print("|---- Vendedor: ");
        vendedorVenda = scan.nextLine();       
        for(int i = 0; i < vendedor.size(); i = i + 1){  
            tempVendedor = vendedor.get(i);        
             if (vendedorVenda.equals(tempVendedor.getNome())){

                 achou = "sim";
                i = vendedor.size() + 1;                
             }
        }
        if("sim".equals(achou)){
            System.out.println("|---- Vendedor Validado");
            achou = null;
        }else {
            System.out.println("|---- Vendedor nao encontrado");
            newSessao();
        }
        System.out.println("Lista de Clientes:");
        for(int i = 0; i < cliente.size(); i = i + 1){             
            System.out.println(cliente.get(i).getNome());        
        }
        System.out.print("|---- Cliente: ");
        clienteVenda = scan.nextLine();
        for(int i = 0; i < cliente.size(); i = i + 1){  
            tempCliente = cliente.get(i);        
             if (clienteVenda.equals(tempCliente.getNome())){
                 achou = "sim";
                i = cliente.size() + 1;                
             }
        }
        if("sim".equals(achou)){
            System.out.println("|---- Cliente Validado");
            achou = null;
        }else {
            System.out.println("|---- Cliente nao encontrado");
            newSessao();
        }
        
        System.out.println("Lista de Produtos:");
        for(int i = 0; i < produto.size(); i = i + 1){             
            System.out.println(produto.get(i).getNome());        
        }
        System.out.print("|---- Produto: ");
        produtoVenda = scan.nextLine();
        
        for(int i = 0; i < produto.size(); i = i + 1){  
            tempProduto = produto.get(i);        
             if (produtoVenda.equals(tempProduto.getNome())){
                 achou = "sim";
                 validaProduto = i;
                 
                i = produto.size() + 1;                
             }
        }

        tempProduto = produto.get(validaProduto);
        if("sim".equals(achou)){
            System.out.println("|---- Produto Validado");
            achou = null;
        }else {
            System.out.println("|---- Produto nao encontrado");
            newSessao();
        }
        
        System.out.print("|---- Quantidade: ");
        produtoQtdeVenda = scan.nextInt();
        System.out.println("|---- Valor: " + (tempProduto.getPreco() * produtoQtdeVenda));
        //Arruma estoque da quantidade de produtos
        int qntde = tempProduto.getQuantidade();
        qntde = qntde - produtoQtdeVenda;
        tempProduto.setQuantidade(qntde);
        if(qntde == 0){
            deletarProduto(validaProduto);
            System.out.println("Produto acabou e foi removido");
        }
        


        
        //Venda vendaS = new Venda();
        
    }
     
}
