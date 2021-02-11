package cl.duoc.AerolineaLogin.web;

import cl.duoc.AerolineaLogin.service.ServicioPremiumService;
import cl.duoc.AerolineaLogin.service.ServicioTurismoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class Controlador {
    
    @Autowired
    private ServicioTurismoService servicioTurismoService;
    
    @Autowired
    private ServicioPremiumService servicioPremiumService;
    
    @GetMapping("/")
    public String inicio(@AuthenticationPrincipal User user) {
        String url = "";
        String rol = user.getAuthorities().toString();
        if (rol.contains("ADMIN")) {
            url = "/index";

        } else if (rol.contains("USERTURISMO")) {
            url = "/servicioturismo";
        } else if (rol.contains("USERPREMIUM")) {
            url = "/serviciopremium";
        }
        return url;
    }

    @GetMapping("/index")
    public String index() {
        return "/index";
    }

    @GetMapping("/servicioturismo")
    public String servicioTur(Model model) {
        var serviciosTur = servicioTurismoService.listarServicios();
        model.addAttribute("servicios", serviciosTur);
        return "servicioturismo";
    }

    @GetMapping("/serviciopremium")
    public String servicioPre(Model model) {
        var serviciosPre = servicioPremiumService.listarServicios();
        model.addAttribute("servicios", serviciosPre);
        return "serviciopremium";
    }
}
