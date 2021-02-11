package cl.duoc.AerolineaLogin.service;

import cl.duoc.AerolineaLogin.dao.ServicioTurismoDAO;
import cl.duoc.AerolineaLogin.dominio.ServicioTurismo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioTurismoServiceImplementation implements ServicioTurismoService {
    
    @Autowired
    private ServicioTurismoDAO servicioTurismoDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<ServicioTurismo> listarServicios() {
        return (List<ServicioTurismo>)servicioTurismoDAO.findAll();
    }
    
}
