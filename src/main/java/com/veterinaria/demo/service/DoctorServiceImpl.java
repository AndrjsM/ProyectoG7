package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Doctor;
import com.veterinaria.demo.dao.DoctorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDao doctorDao;  // Reemplazamos con doctorDao

    @Override
    public Doctor crearDoctor(Doctor doctor) {
        // Si es necesario, puedes realizar alguna validación o procesamiento adicional aquí
        return doctorDao.save(doctor); // Guardamos el doctor en el Dao
    }

    @Override
    public List<Doctor> obtenerTodosLosDoctores() {
        return doctorDao.findAll(); // Obtenemos todos los doctores de la base de datos
    }

    @Override
    public Optional<Doctor> obtenerDoctorPorId(String id) {
        return doctorDao.findById(id); // Buscamos doctor por ID
    }

    @Override
    public Doctor actualizarDoctor(String id, Doctor doctor) {
        if (doctorDao.existsById(id)) { // Verificamos si el doctor existe antes de actualizarlo
            doctor.setId(id); // Establecemos el ID del doctor antes de actualizar
            return doctorDao.save(doctor); // Actualizamos el doctor
        }
        return null; // Si el doctor no existe, retornamos null o lanzamos una excepción
    }

    @Override
    public void eliminarDoctor(String id) {
        doctorDao.deleteById(id); // Eliminamos el doctor por ID
    }
}

