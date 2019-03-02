package guru.springframework.stgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.stfpetclinic.model.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/owners") // == this applies to all of them
@Controller
public class OwnerController  {

    private final OwnerService ownerService;


    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/", "/index", "/index.html"}) // multiple mappings
    public String listOwners(Model model){

        model.addAttribute("owners",ownerService.findAll());

        return "owners/index";
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }


    @GetMapping("/{ownerId")
    public ModelAndView showOwner(@PathVariable("ownerid") Long ownerId)
    {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    public String findOwners(Model model)
    {
        model.addAttribute("owner", Owner.builder());
        return "owners/findOwners";
    }

    public String processFindFOrm(Owner owner, BindingResult, Model model)
    {
        if(owner.getLastName() == null)
        {
            owner.setLastName("");
        }

        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");


        if(results.isEmpty())
        {

            //result.rejectValue("lastName", "notFound","not Found");
            return "owners/findOwners";

        } else if (results.size() == 1)
        {
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else
        {
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }


    }





}
