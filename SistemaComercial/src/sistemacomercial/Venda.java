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
    private String tipoPagamento;
    private double juros;
    private final Vendedor vendedor;
            
    public Venda(String tipoPagamento, double juros, Vendedor vendedor, Cliente cliente, Produto produto, ArrayList<Venda> venda){
        this.tipoPagamento = tipoPagamento;
        this.juros = juros;
        this.vendedor = vendedor;
        this.produto = produto;
        this.cliente = cliente;
        venda.add(this);
    }
}
