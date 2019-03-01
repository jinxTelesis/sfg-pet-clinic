package guru.springframework.stgpetclinic.controllers;

//import static org.junit.jupiter.api.Assertions.*;


import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.stfpetclinic.model.Owner;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvcBuilder;

import java.util.HashSet;
import java.util.Set;

//@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @Mock
    OwnerController controller;

    Set<Owner> owners;

    void setUp()
    {
        owners = new HashSet<>();
        owners.add(Owner.builder()).id(1L).build();
        owners.add(Owner.builder()).id(2L).builder();

        mocMvc = MockMvcBuilder
                .standaloneSetup(controller)
                .builder();
    }

    @Test
    void ListOwners(){
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners")).andExpect(.isOk())
            .andExpect(view().name("owners/index"))
                .andExpext(model()).attribute("owners", hasSize(2));


    }

    @Test
    void findOwners(){
        mockMvc.perform(get("/owners/find"))
                .andExpect(status).isOk())
            .andExpect(view().name("notimplemented"));

        verifyZeroInteraction(ownerService);
    }



}