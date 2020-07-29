package dorian.codes.messaging.users.controllers;

import dorian.codes.messaging.AbstractTest;
import dorian.codes.messaging.users.models.UserNickname;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;


public class UserControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testCreateNewUser() throws Exception {
        String uri = "/users/new";
        UserNickname newUser = new UserNickname("alex");


        String inputJson = super.mapToJson(newUser);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status); //TODO it should return 201 instead of 200
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"nickname\":\"alex\"}");
    }
}
