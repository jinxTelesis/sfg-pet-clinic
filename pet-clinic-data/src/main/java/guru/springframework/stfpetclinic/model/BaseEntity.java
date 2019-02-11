package guru.springframework.stfpetclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private Long id; // box type hibernate recommendation

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
