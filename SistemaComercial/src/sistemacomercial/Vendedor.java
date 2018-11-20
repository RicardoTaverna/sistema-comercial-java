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
public class Vendedor {
    private String nome, sobrenome, datanascimento, telefone, CPF, cidade, estado, pais, endereco, dataCadastro, login, senha, papel;
    int codigo;
    
    public Vendedor(String nome, String sobrenome, String datanascimento, String telefone, String CPF, String cidade, String estado, String pais, String endereco, String dataCadastro, String login, String senha, String papel, int codigo, ArrayList<Vendedor> vendedor) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.datanascimento = datanascimento;
        this.telefone = telefone;
        this.CPF = CPF;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.endereco = endereco;
        this.dataCadastro = dataCadastro;
        this.login = login;
        this.senha = senha;
        this.papel = papel;
        this.codigo = codigo;
        vendedor.add(this);
        
    }    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }
    
    
}
