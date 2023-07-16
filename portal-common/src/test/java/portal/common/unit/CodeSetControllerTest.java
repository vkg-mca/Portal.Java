//package portal.common.unit;
//
//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import portal.common.controllers.CommonCodeSetController;
//import portal.common.services.CodeSetService;
//
//@WebMvcTest(controllers= CommonCodeSetController.class)
////@ExtendWith(MockitoExtension.class)
////@AutoConfigureMockMvc
//
//public class CodeSetControllerTest {
//    @MockBean private CodeSetService service;
//    @Autowired private MockMvc mockMvc;
//
//    @Test
//    @DisplayName("Should return all codeset from /api/codeset endpoint")
//    public void shouldListAllCodeSet() throws Exception{
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/codeset"))
//                .andExpect(MockMvcResultMatchers.status().is(200) );
//    }
//
//}
