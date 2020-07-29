package dorian.codes.messaging.messages.controllers;

import dorian.codes.messaging.AbstractTest;
import dorian.codes.messaging.messages.models.ApiMessage;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MessageControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testGetMessagesReceived() throws Exception {

        String uri = "/messages/user/1/received";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ApiMessage[] messagesList = super.mapFromJson(content, ApiMessage[].class);
        assertTrue(messagesList.length > 0);
    }

    @Test
    public void testGetMessagesSent() throws Exception {

        String uri = "/messages/user/1/sent";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ApiMessage[] messagesList = super.mapFromJson(content, ApiMessage[].class);
        assertTrue(messagesList.length > 0);
    }


    @Test
    public void testGetMessagesReceivedFilter() throws Exception {

        String uri = "/messages/user/1/received/from/2";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ApiMessage[] messagesList = super.mapFromJson(content, ApiMessage[].class);
        assertTrue(messagesList.length > 0);
    }

    @Test
    public void testSendMessage() throws Exception {
        String uri = "/messages/user/send";
        ApiMessage newMessage = new ApiMessage("Good!", 1L, 2L);
        String inputJson = super.mapToJson(newMessage);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"content\":\"Good!\",\"senderId\":1,\"receiverId\":2}");
    }

    @Test
    public void testSendMessageNotAllowed() throws Exception {
        String uri = "/messages/user/send";
        ApiMessage newMessage = new ApiMessage("Good!", 1L, 1L);
        String inputJson = super.mapToJson(newMessage);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(403, status);
    }

}
