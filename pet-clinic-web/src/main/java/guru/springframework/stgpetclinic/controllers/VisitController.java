package guru.springframework.stgpetclinic.controllers;


import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.VisitService;
import guru.springframework.stfpetclinic.model.Pet;
import guru.springframework.stfpetclinic.model.Visit;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class VisitController {



    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }


    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder)
    {
        dataBinder.setDisallowedFields("id");
    }

    public Visit loadPetWithVisit(@PathVariable("pedId") Long petId, Map<String, Object> model)
    {
        Pet pet = petService.findById(petId);
        model.put("pet", pet);
        Visit visit = new Visit();
        //pet.getVisits().add(visist);
        visit.setPet(pet);
        return visit;
    }

    @GetMapping("/owners/*/pets/{petId}/visit/new")
    public String initNewVisitForm(@PathVariable("petId") Long petId, Map<String,Object> model)
    {
        return "pets/createOrUpdateVisitForm";
    }

    public String processNewVisitFOrm(@Valid Visit visit, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "pets/createOrUpdateVisitForm";
        } else
        {
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }


}
