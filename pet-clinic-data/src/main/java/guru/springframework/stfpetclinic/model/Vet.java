package guru.springframework.stfpetclinic.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER) // == javax persistance == eager tries to load it all at once
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id")
            ,inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> speciality;

    public Set<Speciality> getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Set<Speciality> speciality) {
        this.speciality = speciality;
    }
}
