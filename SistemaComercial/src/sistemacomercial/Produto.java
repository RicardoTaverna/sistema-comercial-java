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
public class Produto {
   private String descrição;
   private int quantidade;
   private  double preco;
   private Fornecedor fornecedor;

    public Produto(String descrição, int quantidade, double preco, Fornecedor fornecedor, ArrayList<Produto> produto) {
        this.descrição = descrição;
        this.quantidade = quantidade;
        this.preco = preco;
        this.fornecedor = fornecedor;
        produto.add(this);
    }








    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
}
