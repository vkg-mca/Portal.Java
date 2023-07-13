package portal.directory.unit;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import portal.directory.controllers.CodeSetController;
import portal.directory.services.CodeSetService;

@WebMvcTest(controllers= CodeSetController.class)
//@ExtendWith(MockitoExtension.class)
//@AutoConfigureMockMvc

public class CodeSetControllerTest {
    @MockBean private CodeSetService service;
    @Autowired private MockMvc mockMvc;

    @Test
    @DisplayName("Should return all codeset from /api/codeset endpoint")
    public void shouldListAllCodeSet() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/codeset"))
                .andExpect(MockMvcResultMatchers.status().is(200) );
    }

}
