package com.senac.petshop.bean;

import com.jdf.swing.helper.jtable.ColumnMetadataFormat;
import com.jdf.swing.helper.jtable.JTableColumnMetadata;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lossurdo
 */
public class Dono implements Comparable<Dono> {

    @JTableColumnMetadata(name = "Código", isKey = true)
    private Integer codigo;
    
    @JTableColumnMetadata(name = "Nome", isValue = true)
    private String nome;

    @JTableColumnMetadata(name = "CPF")
    private String cpf;

    @JTableColumnMetadata(name = "Tel.Resid.")
    private String telefoneResidencial;

    @JTableColumnMetadata(name = "Celular")
    private String telefoneCelular;

    @JTableColumnMetadata(name = "Email")
    private String email;

    @JTableColumnMetadata(name = "Email", format = ColumnMetadataFormat.DATE_DD_MM_YYYY)
    private Date dataNascimento;
    
    private List<Animal> animais;

    public Dono() {
        animais = new ArrayList<>();
    }

    public Dono(Integer codigo) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
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
        final Dono other = (Dono) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dono{" + "codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", telefoneResidencial=" + telefoneResidencial + ", telefoneCelular=" + telefoneCelular + ", email=" + email + ", dataNascimento=" + dataNascimento + ", animais=" + animais + '}';
    }

    @Override
    public int compareTo(Dono o) {
        return o.getCodigo().compareTo(codigo);
    }
    
}
