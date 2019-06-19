package app.controller;

import app.entity.Client;
import app.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ClientService clientService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void createClient_whenClientExists_thenReturnJsonArray() throws Exception {

        Client ivanov = new Client();
        ivanov.setId(1L);
        ivanov.setFullName("Ivanov");

        given(clientService.exists(ArgumentMatchers.any(Client.class))).willReturn(false);

        mvc.perform(post("/api/client/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ivanov)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.fullName", is(ivanov.getFullName())));
    }

    @Test
    public void createClient_whenClientDoesnotExist_thenReturnErrorMessage() throws Exception {

        Client ivanov = new Client();
        ivanov.setId(1L);
        ivanov.setFullName("Ivanov");

        given(clientService.exists(ArgumentMatchers.any(Client.class))).willReturn(true);

        mvc.perform(post("/api/client/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ivanov)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message", is(String.format("Client %s already exists",
                        ivanov.getFullName()))));
    }
}