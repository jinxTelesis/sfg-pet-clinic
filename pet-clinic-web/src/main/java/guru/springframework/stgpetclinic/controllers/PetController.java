package guru.springframework.stgpetclinic.controllers;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.map.PetTypeMapService;
import guru.springframework.stfpetclinic.model.Owner;
import guru.springframework.stfpetclinic.model.PetType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    public void ititOwnerBinder(WebDataBinder dataBinder)
    {
        dataBinder.setDisallowedFields("id");
    }
}
