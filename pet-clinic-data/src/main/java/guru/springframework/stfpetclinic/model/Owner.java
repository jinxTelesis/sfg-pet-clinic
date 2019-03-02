package guru.springframework.stfpetclinic.model;

import javax.persistence.*;
import java.util.Set;

@Entity // javax persistnance
@Table(name = "owners")
public class Owner extends Person {

    @Column(name = "address")
    private String addesss;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets;

    public String getAddesss() {
        return addesss;
    }

    public void setAddesss(String addesss) {
        this.addesss = addesss;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Pet getPet(String name{
        return getPet(name, false);
    }

    public Pet getPet(String name, boolean ignoreNew)
    {
        name = name.toLowerCase();
        for(Pet pet : pets)
        {
            if(!ignoreNew || !pet.isNew())
            {
                String compName = pet.getName();
                compName = compName.toLowerCase();
                if(compName.equals(name)){
                    return pet;
                }
            }
        }
        return null;
    }
}
