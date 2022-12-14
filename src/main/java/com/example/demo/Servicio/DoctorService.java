/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Doctor;
import com.example.demo.Repositorio.DoctorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angela
 */

@Service

public class DoctorService {
      @Autowired
    private DoctorRepository doctorRepository;
    
    public List<Doctor> getAll(){
        return doctorRepository.getAll();
    }
    
    public Optional<Doctor> getdoctor(int id){
        return doctorRepository.getDoctor(id);
    }
    
    public Doctor save (Doctor doctor){
        if (doctor.getId() == null){
            return doctorRepository.save(doctor);
        } else {
            Optional<Doctor> doctor1 = doctorRepository.getDoctor(doctor.getId());
            if(doctor1.isEmpty()){
                return doctorRepository.save(doctor);
            } else{
                return doctor;
            }
            
        }
    }
    
}