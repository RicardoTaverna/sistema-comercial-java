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
            
    public Venda( Vendedor vendedor, Cliente cliente, Produto produto, ArrayList<Venda> venda){

        this.vendedor = vendedor;
        this.cliente = cliente;
        this.produto = produto;
        
        venda.add(this);
    }
}
