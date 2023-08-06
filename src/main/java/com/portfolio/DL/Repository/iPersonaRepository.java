/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.DL.Repository;

import com.portfolio.DL.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego Luna
 */

@Repository
public interface iPersonaRepository extends JpaRepository<Persona, Integer>{ // A través de Persona el repositorio se comunica con la Entidad
    public Optional<Persona> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
