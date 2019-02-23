package guru.springframework.stfpetclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass // Tells JPA gonna inhert from this
public class BaseEntity implements Serializable {

    @Id // JPA comment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // box type hibernate recommendation

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
