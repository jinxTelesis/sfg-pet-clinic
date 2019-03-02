package guru.springframework.stgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.map.PetTypeMapService;
import guru.springframework.stfpetclinic.model.Owner;
import guru.springframework.stfpetclinic.model.Pet;
import guru.springframework.stfpetclinic.model.PetType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


@RequestMapping("/owners/{ownerId}")
@Controller
public class PetController {

    private static String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeMapService petTypeMapService;


    public PetController(PetService petService, OwnerService ownerService, PetTypeMapService petTypeMapService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeMapService = petTypeMapService;
    }


    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes()
    {
        return petTypeMapService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId)
    {
        return ownerService.findById(ownerId);
    }

    @ModelAttribute("owner")
    public void ititOwnerBinder(WebDataBinder dataBinder)
    {
        dataBinder.setDisallowedFields("id");
    }


    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model)
    {
        Pet pet = new Pet();
        owner.getPets().add(pet);
        model.addAttribute("pet",pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateFOrm(@PathVariable Long petId, Model model)
    {
        model.addAttribute("pet", petService.findById(petId));
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/{petId}/edit")

    public String processUpdateForm(@Valid Pet pet, BindingResult result, Owner owner, Model model)
    {
        if(result.hasErrors())
        {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else
        {
            owner.getPets().add(pet);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }



}
