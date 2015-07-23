package com.senac.petshop.bean;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lossurdo
 */
public class Animal {

    private Integer codigo;
    private String nome;
    private Date dataNascimento;
    
    private TipoAnimal tipoAnimal; // gato, cachorro
    private String descricao; // raça, porte, doenças etc
    private CorPredominante corPredominante;
    
    private Dono dono; // pessoa dona do animal

    public Animal() {
    }

    public Animal(Integer codigo) {
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CorPredominante getCorPredominante() {
        return corPredominante;
    }

    public void setCorPredominante(CorPredominante corPredominante) {
        this.corPredominante = corPredominante;
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.codigo);
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
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", tipoAnimal=" + tipoAnimal + ", descricao=" + descricao + ", corPredominante=" + corPredominante + ", dono=" + dono + '}';
    }
    
}
