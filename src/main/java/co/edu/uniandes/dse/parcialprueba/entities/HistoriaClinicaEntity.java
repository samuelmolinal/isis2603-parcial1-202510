package co.edu.uniandes.dse.parcialprueba.entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;


@Data
@Entity
public class HistoriaClinicaEntity extends BaseEntity{

    private String diagnostico;
    private String tratamiento;
    private String fechaDeCreacion;

    @PodamExclude
    @ManyToOne
    List<PacienteEntity> pacientes = new ArrayList<>();



    

}
