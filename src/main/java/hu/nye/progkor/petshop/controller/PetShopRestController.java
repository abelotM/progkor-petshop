package hu.nye.progkor.petshop.controller;

import hu.nye.progkor.petshop.model.PetShop;
import hu.nye.progkor.petshop.service.PetShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pet-shop")
public class PetShopRestController {

    private final PetShopService petShopService;

    public PetShopRestController(final PetShopService petShopService) {
        this.petShopService = petShopService;
    }

    @GetMapping
    public List<PetShop> getAllPetShop(){
        return petShopService.getAllPetShop();
    }

    @GetMapping("/{id}")
    PetShop getPetShop(final @PathVariable("id") Long id){
        return petShopService.getPetShop(id);
    }

    @PostMapping
    PetShop createPetShop(final @RequestBody PetShop petShop) {
        return petShopService.createPetShop(petShop);
    }

    @PutMapping("/{id}")
    PetShop updatePetShop(final @PathVariable Long id, final @RequestBody PetShop petShopChange){
        return  petShopService.updatePetShop(id, petShopChange);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePetShop(final @PathVariable Long id) {
        petShopService.deletePetShop(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
