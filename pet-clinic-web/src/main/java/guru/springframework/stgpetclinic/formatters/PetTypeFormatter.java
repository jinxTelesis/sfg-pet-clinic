package guru.springframework.stgpetclinic.formatters;

import guru.springframework.sfgpetclinic.services.map.OwnerMapService;
import guru.springframework.stfpetclinic.model.PetType;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;


@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final OwnerMapService.PetTypeService petTypeService;

    public PetTypeFormatter(OwnerMapService.PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    public String print(PetType petType, Locale locale)
    {
        return petType.getName();
    }

    public PetType parse(String text, Locale locale) throws ParseException{
        Collection<PetType> findPetTypes = petTypeService.findAll();

        for(PetType type : findPetTypes)
        {
            if(type.getName().equals(text))
            {
                return type;
            }
        }
        throw new ParseException("type not found: " + text , 0);
    }


}
