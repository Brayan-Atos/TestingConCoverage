package com.example.persona;

import com.example.persona.entities.Persona;
import com.example.persona.repositories.PersonaRepository;
import com.example.persona.services.PersonaServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
class PersonaApplicationTests {

	@Autowired
	private PersonaServiceImpl Personaservice;

	@MockBean
	private PersonaRepository repository;

	Persona persona1 = new Persona("Gabriel","Garcia",40404040);
	Persona persona2 = new Persona("Brayan","Segovia",40404040);
	Persona personaSave = new Persona("Juan","Lopez", 50505050);
	ArrayList<Persona> record = new ArrayList<Persona>(Arrays.asList(persona1,persona2));
	Long ID = Long.valueOf(2);

	@Test
	public void getUsersTest(){
		Mockito.when(repository.findAll()).thenReturn(record);
		Assertions.assertEquals(record.size(),repository.findAll().size());
	}

	@Test
	public void getOneUserTest(){
		Mockito.when(repository.getById(ID)).thenReturn(persona1);
		boolean condition = persona1.getNombre().equals(repository.getById(ID).getNombre());
		Assertions.assertTrue(condition);
	}

	@Test
	public void saveUserTest(){
		Mockito.when(repository.save(personaSave)).thenReturn(personaSave);
		Assertions.assertEquals(personaSave,repository.save(personaSave));
	}

	@Test
	public void deleteUser() throws Exception {
		Mockito.when(Personaservice.delete(ID)).thenReturn(true);
		Assertions.assertEquals(Personaservice.delete(ID),true);
	}

}
