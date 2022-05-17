package hu.nye.progkor.petshop.service.impl;

import hu.nye.progkor.petshop.model.PetShop;
import hu.nye.progkor.petshop.model.Species;
import hu.nye.progkor.petshop.model.exception.NotFoundException;
import hu.nye.progkor.petshop.service.PetShopService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PetShopServiceImpl implements PetShopService {

    private static final List<PetShop> DATA_BASE = new ArrayList<>();

    static {
        DATA_BASE.add(new PetShop(1L, "Kutya", Species.MAMMAL));
        DATA_BASE.add(new PetShop(2L, "Papagáj", Species.BIRD));
        DATA_BASE.add(new PetShop(3L, "Anakonda", Species.REPTILE));
        DATA_BASE.add(new PetShop(4L, "Rálya", Species.FISH));
        DATA_BASE.add(new PetShop(5L, "Béka", Species.AMPHIBIAN));
    }

    @Override
    public List<PetShop> getAllPetShop() {
        return Collections.unmodifiableList(DATA_BASE);
    }

    @Override
    public PetShop getPetShop(final Long id) {
        return DATA_BASE.stream()
                .filter(petShop -> petShop.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public PetShop createPetShop(final PetShop petShop) {
       petShop.setId(getNextId());
       DATA_BASE.add(petShop);
       return petShop;
    }

    @Override
    public PetShop updatePetShop(final Long id, final PetShop petShopChange) {
       final PetShop petShop = getPetShop(id);
        petShop.setName(petShopChange.getName());
        petShop.setSpecies(petShopChange.getSpecies());

        return petShop;
    }

    @Override
    public void deletePetShop(final Long id) {
      final PetShop petShop = getPetShop(id);
      DATA_BASE.remove(petShop);
    }

    private long getNextId(){
        return getLastId() + 1L;
    }

    private long getLastId() {
        return DATA_BASE.stream()
                .mapToLong(PetShop::getId)
                .max()
                .orElse(0);
    }

}
