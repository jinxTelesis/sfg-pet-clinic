package guru.springframework.stgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners") // == this applies to all of them
@Controller
public class OwnerController  {

    @RequestMapping({"","/", "/index", "/index.html"}) // multiple mappings
    public String listOwners(){
        return "owners/index";
    }

}
