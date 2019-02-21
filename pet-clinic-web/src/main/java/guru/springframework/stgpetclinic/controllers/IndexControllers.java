package guru.springframework.stgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControllers {

    @RequestMapping({"","/","index","index.html"}) // multiple request mappings
    public String index(){
        return "index";
    }

    @RequestMapping("/oups") //TODO place holder
    public String oupsHandler(){
        return "notimplemented";
    }
}
