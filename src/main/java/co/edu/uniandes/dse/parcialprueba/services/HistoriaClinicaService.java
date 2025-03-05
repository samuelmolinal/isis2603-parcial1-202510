package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialprueba.entities.HistoriaClinicaEntity;
import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.HistoriaClinicaRepository;
import lombok.extern.slf4j.Slf4j;
import java.util.Optional;
@Slf4j
@Service
public class HistoriaClinicaService {

    @Autowired
    HistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    HistoriaClinicaEntity historiaClinicaEntity;

    @Transactional
    public HistoriaClinicaEntity createHistoriaClinica (HistoriaClinicaEntity historia, PacienteEntity paciente) throws EntityNotFoundException, IllegalOperationException{
        if(historia.getDiagnostico() == null){
            throw new IllegalOperationException("Diagnositco no puede ser null");
        }
        Optional<HistoriaClinicaEntity> historiaOpt = historiaClinicaRepository.findById(historiaClinicaEntity.getId());
        if (historiaOpt.isEmpty()){
            throw new IllegalOperationException("La publicacion no existe");
        }
        return historiaClinicaRepository.save(historia);
    }

}
