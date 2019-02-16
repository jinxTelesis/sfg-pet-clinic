package guru.springframework.stgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners") // == this applies to all of them
@Controller
public class OwnerController  {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService)
    {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/", "/index", "/index.html"}) // multiple mappings
    public String listOwners(){
        return "owners/index";
    }

}
