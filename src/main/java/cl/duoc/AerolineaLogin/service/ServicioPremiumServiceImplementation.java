
package cl.duoc.AerolineaLogin.service;

import cl.duoc.AerolineaLogin.dao.ServicioPremiumDAO;
import cl.duoc.AerolineaLogin.dominio.ServicioPremium;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ServicioPremiumServiceImplementation implements ServicioPremiumService {
    
    @Autowired
    private ServicioPremiumDAO servicioPremiumDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<ServicioPremium> listarServicios() {
        return (List<ServicioPremium>)servicioPremiumDAO.findAll();
    }
    
}
