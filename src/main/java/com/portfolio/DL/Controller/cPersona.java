/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.DL.Controller;

import com.portfolio.DL.Dto.dtoPersona;
import com.portfolio.DL.Entity.Persona;
import com.portfolio.DL.Service.sPersona;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diego Luna
 */

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://dlportfolioap.web.app")
public class cPersona {
    @Autowired
    sPersona sPersona;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> detail(@PathVariable("id") int id){
        if(!sPersona.existsById(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        Persona persona = sPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtoPersona){
        if(!sPersona.existsById(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        
//        if(sPersona.existsByNombre(dtoPersona.getNombre()) && sPersona.getByNombre(dtoPersona.getNombre()).get().getId() != id)
//            return new ResponseEntity(new Mensaje("La experiencia que intenta ingresar ya existe..."), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoPersona.getNombre()))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoPersona.getApellido()))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoPersona.getDescripcion()))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoPersona.getImg()))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        
        Persona persona = sPersona.getOne(id).get();
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setDescripcion(dtoPersona.getDescripcion());
        persona.setImg(dtoPersona.getImg());
        sPersona.save(persona);
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    
//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody dtoPersona dtoPersona){
//        if(StringUtils.isBlank(dtoPersona.getNombre()))
//            return new ResponseEntity(new Mensaje("Nombre obligatorio..."), HttpStatus.BAD_REQUEST);
//        if(sPersona.existsByNombre(dtoPersona.getNombre()))
//            return new ResponseEntity(new Mensaje("La experiencia que intenta agregar ya existe..."), HttpStatus.BAD_REQUEST);
//        
//        Persona persona = new Persona(dtoPersona.getNombre(), dtoPersona.getApellido(), dtoPersona.getDescripcion(), dtoPersona.getImg());
//        sPersona.save(persona);
//        
//        return new ResponseEntity(new Mensaje("La experiencia se agregó exitosamente..."), HttpStatus.OK);
//    }
    
//    @DeleteMapping("delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") int id){
//        if(!sPersona.existsById(id))
//            return new ResponseEntity(new Mensaje("La experiencia que intenta eliminar no existe..."), HttpStatus.BAD_REQUEST);
//        sPersona.delete(id);
//        
//        return new ResponseEntity(new Mensaje("Experiencia eliminada exitosamente..."), HttpStatus.OK);
//    }
    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        sPersona.save(persona);
        return "Persona creada correctamente";
    }
}
