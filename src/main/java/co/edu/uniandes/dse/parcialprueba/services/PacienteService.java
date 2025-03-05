package co.edu.uniandes.dse.parcialprueba.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Transactional
    public PacienteEntity createPaciente (PacienteEntity paciente) throws EntityNotFoundException, IllegalOperationException{
        if(paciente.getTelefono() == null){
            throw new IllegalOperationException("El numero no puede estar vacio");
        }
        if(paciente.getTelefono().toString().length() == 11){
            throw new IllegalOperationException("El numero debe ser de 11 digitos");
        }
        if(!paciente.getTelefono().toString().startsWith("311") || !paciente.getTelefono().toString().startsWith("601")){
            throw new IllegalOperationException("El numero debe empezar por 311 0 601");
        }
        return pacienteRepository.save(paciente);

    }

}
