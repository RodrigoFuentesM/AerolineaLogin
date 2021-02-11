package cl.duoc.AerolineaLogin.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "servicio_premium")
public class ServicioPremium implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicio; 
    private String origen;
    private String destino;
    private String fecha;
    private String hotel;
    private String tiempoEstadia;
    private int hotelEstrellas;
    private int valor;
}
