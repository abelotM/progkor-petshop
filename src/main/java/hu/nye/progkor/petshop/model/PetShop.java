package hu.nye.progkor.petshop.model;

import java.util.Objects;

public class PetShop {

    private Long id;
    private String name;
    private Species species;

    public PetShop() {
    }

    public PetShop(final Long id, final String name, final Species species) {
        this.id = id;
        this.name = name;
        this.species = species;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(final Species species) {
        this.species = species;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PetShop))
            return false;
        final PetShop petShop = (PetShop) o;
        return Objects.equals(id, petShop.id) && Objects.equals(name, petShop.name) && species == petShop.species;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, species);
    }

    @Override
    public String toString() {
        return "PetShop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species=" + species +
                '}';
    }
}
