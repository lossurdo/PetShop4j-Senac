package com.senac.petshop.bean;

import java.util.Objects;

/**
 *
 * @author lossurdo
 */
public class AgendaAnimal {

    private Agenda agenda;
    private Animal animal;
    private Procedimento procedimento;

    public AgendaAnimal() {
    }

    public AgendaAnimal(Agenda agenda, Animal animal, Procedimento procedimento) {
        this.agenda = agenda;
        this.animal = animal;
        this.procedimento = procedimento;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.agenda);
        hash = 89 * hash + Objects.hashCode(this.animal);
        hash = 89 * hash + Objects.hashCode(this.procedimento);
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
        final AgendaAnimal other = (AgendaAnimal) obj;
        if (!Objects.equals(this.agenda, other.agenda)) {
            return false;
        }
        if (!Objects.equals(this.animal, other.animal)) {
            return false;
        }
        if (!Objects.equals(this.procedimento, other.procedimento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AgendaAnimal{" + "agenda=" + agenda + ", animal=" + animal + ", procedimento=" + procedimento + '}';
    }
    
}
