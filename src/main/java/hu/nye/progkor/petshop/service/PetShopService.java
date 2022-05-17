package hu.nye.progkor.petshop.service;

import hu.nye.progkor.petshop.model.PetShop;

import java.util.List;

public interface PetShopService {

    List<PetShop> getAllPetShop();

    PetShop getPetShop(Long id);

    PetShop createPetShop(PetShop petShop);

    PetShop updatePetShop(Long id, PetShop petShopChange);

    void deletePetShop(Long id);
}
