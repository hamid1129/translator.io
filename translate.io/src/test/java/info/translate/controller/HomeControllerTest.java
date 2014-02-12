package info.translate.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.awt.print.Printable;

import info.translate.configuration.WebAppConfiguration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@org.springframework.test.context.web.WebAppConfiguration
@ContextConfiguration(classes = WebAppConfiguration.class)
public class HomeControllerTest {
	@Autowired
	private WebApplicationContext context;

	MockMvc mockMvc;

	@Before
	public void before() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void rootDomainIsOK() throws Exception {
		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void rootWithParamWillBeForward() throws Exception {
		mockMvc.perform(get("/{word}", "hamid")).andDo(print())
				.andExpect(status().isMovedTemporarily())
				.andExpect(redirectedUrl(("/blah")));
	}
}
