package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Doctor;
import com.veterinaria.demo.dao.DoctorDao; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDao doctorDao;  // Cambié de doctorRepository a doctorDao

    // Método para convertir String a Date
    private Date convertirStringAFecha(String fechaString) {
        try {
            // Definir el formato de la fecha que esperamos en el String
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy");
            return formato.parse(fechaString);
        } catch (Exception e) {
            // Si ocurre algún error en la conversión, retornamos null
            return null;
        }
    }

    @Override
    public Doctor crearDoctor(Doctor doctor) {
        // Conversión de la fecha de nacimiento
        doctor.setFechaNacimientoFormateada(convertirStringAFecha(doctor.getFechaNacimiento()));
        return doctorDao.save(doctor); // Guardamos el doctor en el DoctorDao
    }

    @Override
    public List<Doctor> obtenerTodosLosDoctores() {
        List<Doctor> doctores = doctorDao.findAll(); 
        // Convertir la fecha de nacimiento de todos los doctores a Date
        for (Doctor doctor : doctores) {
            Date fechaNacimiento = convertirStringAFecha(doctor.getFechaNacimiento());
            doctor.setFechaNacimientoFormateada(fechaNacimiento);
        }
        return doctores;
    }

    @Override
    public Optional<Doctor> obtenerDoctorPorId(String id) {
        return doctorDao.findById(id);
    }

    @Override
    public Doctor actualizarDoctor(String id, Doctor doctor) {
        // Si el doctor existe, actualizamos la fecha y los demás campos
        doctor.setFechaNacimientoFormateada(convertirStringAFecha(doctor.getFechaNacimiento()));
        return doctorDao.save(doctor); // Guardamos el doctor actualizado
    }

    @Override
    public void eliminarDoctor(String id) {
        doctorDao.deleteById(id); 
    }
}
