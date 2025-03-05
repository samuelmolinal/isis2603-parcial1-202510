package co.edu.uniandes.dse.parcialprueba.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import org.springframework.context.annotation.Import;


@DataJpaTest
@Transactional
@Import(PacienteService.class)
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;
    

    @Autowired
    private TestEntityManager entityManager;

    private PodamFactory factory = new PodamFactoryImpl();

    List<PacienteEntity> pacienteList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        clearData();
        insertData();
    }

    private void clearData() {
        entityManager.getEntityManager().createQuery("DELETE FROM PacienteEntity").executeUpdate();
    }

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PacienteEntity paciente = factory.manufacturePojo(PacienteEntity.class);
            entityManager.persist(paciente);
            pacienteList.add(paciente);
            
        }
    }

    @Test
    void testCreatePaciente() throws EntityNotFoundException, IllegalOperationException{
        PacienteEntity paciente = factory.manufacturePojo(PacienteEntity.class);
        entityManager.persist(paciente);
        paciente.setTelefono(311675481);
        PacienteEntity resultado = pacienteService.createPaciente(paciente);
        assertNotNull(resultado);
        assertEquals(311675491, resultado.getTelefono());

    }

}
