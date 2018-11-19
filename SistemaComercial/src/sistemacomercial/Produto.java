/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacomercial;

import java.util.ArrayList;
import static sistemacomercial.SistemaComercial.fornecedor;

/**
 *
 * @author taver
 */
public class Produto {
   private String descrição;
   private int quantidade;
   private  float preco;
   private Fornecedor fornecedor;

    public Produto(String descrição, int quantidade, float preco, Fornecedor fornecedor) {
        this.descrição = descrição;
        this.quantidade = quantidade;
        this.preco = preco;
        this.fornecedor = fornecedor;
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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
}
