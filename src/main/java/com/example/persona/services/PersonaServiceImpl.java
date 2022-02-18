package com.example.persona.services;

import com.example.persona.entities.Persona;
import com.example.persona.repositories.BaseRepository;
import com.example.persona.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service// Esta anotacion indica que una clase es un servicio tambien puede indicar que una clase es "Una fachada de negocios"
public class PersonaServiceImpl extends BaseServiceImpl<Persona , Long > implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
               // List<Persona> persona = personaRepository.findByNombreContainingOrApellidoContaining(filtro,filtro);
               //List<Persona> persona = personaRepository.search(filtro);
                 List<Persona> persona = personaRepository.searchNativo(filtro);
                 return persona;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try {
            // Page<Persona> persona = personaRepository.findByNombreContainingOrApellidoContaining(filtro,filtro, pageable);
            //Page<Persona> persona = personaRepository.search(filtro, pageable);
            Page<Persona> persona = personaRepository.searchNativo(filtro, pageable);
            return persona;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
