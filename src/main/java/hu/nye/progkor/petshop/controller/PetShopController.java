package hu.nye.progkor.petshop.controller;

import hu.nye.progkor.petshop.model.PetShop;
import hu.nye.progkor.petshop.model.exception.NotFoundException;
import hu.nye.progkor.petshop.service.PetShopService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pet-shop")
public class PetShopController {

    private final PetShopService petShopService;

    public PetShopController(final PetShopService petShopService) {
        this.petShopService = petShopService;
    }

    @GetMapping
    public String getAllPetShop(final Model model) {
       final List<PetShop> petShops = petShopService.getAllPetShop();
        model.addAttribute("petShops", petShops);
        return "petshop/list";
    }

    @GetMapping("/{id}")
    public String getPetShop(final Model model, final @PathVariable Long id) {
        final PetShop petShop = petShopService.getPetShop(id);
        model.addAttribute("petShop", petShop);
        return "petshop/edit";
    }


    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createPetShop(final Model model,
                               final @RequestParam(value = "id", required = false) Long id,
                               final PetShop petShopChanges) {
       final PetShop petShop = petShopService.updatePetShop(id, petShopChanges);
        model.addAttribute("petShop", petShop);
        return "petshop/edit";
    }

    @GetMapping("/create")
    public String createPetShopForm(final Model model) {
        return "petshop/create";
    }

    @PostMapping("/create")
    public String createPetShop(final Model model, final PetShop petShop) {
        final PetShop savedPetShop = petShopService.createPetShop(petShop);
        model.addAttribute("petShop", savedPetShop);
        return "petshop/edit";
    }


    @GetMapping("/{id}/delete")
    public String deletePetShop(final Model model, final @PathVariable("id") Long id) {
        try {
            petShopService.deletePetShop(id);
        } catch (NotFoundException e){
            // Ignored
        }
        final List<PetShop> petShops = petShopService.getAllPetShop();
        model.addAttribute("petShops", petShops);
        return "petshop/list";
    }
}
