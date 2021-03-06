package com.prueba.demo.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.demo.model.User;
import com.prueba.demo.service.UserService;
import com.prueba.demo.util.RestResponse;

@RestController
public class UserController {

	@Autowired
	protected UserService userService;

	protected ObjectMapper objectMapper;

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJason)
			throws JsonParseException, JsonMappingException, IOException {
		this.objectMapper = new ObjectMapper();
		User user = this.objectMapper.readValue(userJason, User.class);
		
		if (!this.Validate(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no esta diligenciados");
		}
		this.userService.save(user);
		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public List<User> getUsers() {
		return this.userService.findAll();
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public void deleteUser(@RequestBody String userJason) throws Exception{
		this.objectMapper = new ObjectMapper();
		
		User user = this.objectMapper.readValue(userJason, User.class);
		
		if (user.getId() == null) {
			throw new Exception ("El id esta nulo");
		}
		this.userService.deleteUser(user.getId());
	}
	
	private boolean Validate(User user) {
		boolean isValid = true;
		
		if(user.getPrimerNombre() == null || user.getPrimerNombre() == "") {
			isValid = false;
		}

		if(StringUtils.trimToNull(user.getPrimerApellido()) == null) {
			isValid = false;
		}

		if(StringUtils.trimToNull(user.getDireccion()) == null) {
			isValid = false;
		}
		
		return isValid;
	}

}
