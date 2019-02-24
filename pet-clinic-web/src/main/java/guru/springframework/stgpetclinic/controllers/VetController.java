package guru.springframework.stgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {


    private final guru.springframework.sfgpetclinic.services.VetService.VetService vetService;


    public VetController(VetService.VetService vetService) {
        this.vetService = vetService;
    }


    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"}) // multiple mappings
    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }

}
