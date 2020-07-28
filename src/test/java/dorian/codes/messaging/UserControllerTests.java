package dorian.codes.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import dorian.codes.messaging.users.controllers.UserController;
import dorian.codes.messaging.users.models.UserNickname;
import dorian.codes.messaging.users.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private JdbcTemplate jdbcTemplate;

    @MockBean
    private UserRepository userRepository;


    @Test
    public void testCreate() throws Exception {

        UserNickname alex = new UserNickname("alex");

        mvc.perform(MockMvcRequestBuilders
                .post("/users/new")
                .content(asJsonString(alex))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    public static String asJsonString(final Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e){
            throw new RuntimeException("Couldn't serialize to json: " + e);
        }
    }
}
