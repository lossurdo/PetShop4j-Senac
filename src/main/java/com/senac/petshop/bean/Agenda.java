package com.senac.petshop.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lossurdo
 */
public class Agenda {

    private Integer codigo;
    private Date data;
    private List<Animal> animais;    
    private List<Procedimento> procedimentos;
    private String descricao;
    private Boolean entradaAnimal;
    private Boolean saidaAnimal;
    
    private Double valorTotal;    

    public Agenda() {
        animais = new ArrayList<>();
        procedimentos = new ArrayList<>();
        entradaAnimal = false;
        saidaAnimal = false;
    }

    public Agenda(Integer codigo) {
        this();
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public List<Procedimento> getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(List<Procedimento> procedimentos) {
        this.procedimentos = procedimentos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getEntradaAnimal() {
        return entradaAnimal;
    }

    public void setEntradaAnimal(Boolean entradaAnimal) {
        this.entradaAnimal = entradaAnimal;
    }

    public Boolean getSaidaAnimal() {
        return saidaAnimal;
    }

    public void setSaidaAnimal(Boolean saidaAnimal) {
        this.saidaAnimal = saidaAnimal;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.codigo);
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
        final Agenda other = (Agenda) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Agenda{" + "codigo=" + codigo + ", data=" + data + ", animais=" + animais + ", procedimentos=" + procedimentos + ", descricao=" + descricao + ", entradaAnimal=" + entradaAnimal + ", saidaAnimal=" + saidaAnimal + ", valorTotal=" + valorTotal + '}';
    }

}
