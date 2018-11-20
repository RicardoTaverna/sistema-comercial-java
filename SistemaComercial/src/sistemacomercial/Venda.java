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
public class Venda {
    private Cliente cliente;
    private Produto produto;    
    private final Vendedor vendedor;
    private int pagamento;
            
    public Venda( Vendedor vendedor, Cliente cliente, Produto produto,int pagamento, ArrayList<Venda> venda){

        this.vendedor = vendedor;
        this.cliente = cliente;
        this.produto = produto;
        this.pagamento = pagamento;
        
        venda.add(this);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getPagamento() {
        return pagamento;
    }

    public void setPagamento(int pagamento) {
        this.pagamento = pagamento;
    }
    public String getClienteNome() {
        return cliente.getNome()+ " " + cliente.getSobrenome() + " " + cliente.getCPF();
    }
    public String getVendedorNome() {
        return vendedor.getNome()+ " " + vendedor.getSobrenome();
    }
     public String getProdutoNome() {
        return produto.getNome()+ " " + produto.getDescricao();
    }
}   
