package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Medicina;
import com.veterinaria.demo.dao.MedicinaDao; // Cambié de medicinaRepository a medicinaDao
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicinaServiceImpl implements MedicinaService {

    @Autowired
    private MedicinaDao medicinaDao;  // Reemplazamos con medicinaDao

    @Override
    public Medicina crearMedicina(Medicina medicina) {
        // Si es necesario, puedes realizar alguna validación o procesamiento adicional aquí
        return medicinaDao.save(medicina); // Guardamos la medicina en el Dao
    }

    @Override
    public List<Medicina> obtenerTodasLasMedicinas() {
        return medicinaDao.findAll(); // Obtenemos todas las medicinas de la base de datos
    }

    @Override
    public Optional<Medicina> obtenerMedicinaPorId(String id) {
        return medicinaDao.findById(id); // Buscamos medicina por ID
    }

    @Override
    public Medicina actualizarMedicina(String id, Medicina medicina) {
        if (medicinaDao.existsById(id)) { // Verificamos si la medicina existe antes de actualizarla
            medicina.setId(id); // Establecemos el ID de la medicina antes de actualizar
            return medicinaDao.save(medicina); // Actualizamos la medicina
        }
        return null; // Si la medicina no existe, retornamos null o lanzamos una excepción
    }

    @Override
    public void eliminarMedicina(String id) {
        medicinaDao.deleteById(id); // Eliminamos la medicina por ID
    }
}
