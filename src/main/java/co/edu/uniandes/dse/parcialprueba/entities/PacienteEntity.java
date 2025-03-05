package co.edu.uniandes.dse.parcialprueba.entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class PacienteEntity extends BaseEntity{

    private String nombre;
    private String correo;
    private Integer telefono;

    @PodamExclude
    @OneToMany(mappedBy = "pacientes")
    List<HistoriaClinicaEntity> historias = new ArrayList<>();


    

}
