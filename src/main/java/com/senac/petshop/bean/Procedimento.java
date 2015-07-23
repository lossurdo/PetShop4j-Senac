package com.senac.petshop.bean;

import java.util.Objects;

/**
 *
 * @author lossurdo
 */
public class Procedimento {

    private Integer codigo;
    private String nome;
    private String descricao;
    private Double preco;
    private Boolean ativo;

    public Procedimento() {
        ativo = true;
    }

    public Procedimento(Integer codigo) {
        this();
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Procedimento other = (Procedimento) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Procedimento{" + "codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", ativo=" + ativo + '}';
    }
    
}
