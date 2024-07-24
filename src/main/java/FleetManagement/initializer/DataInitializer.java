package FleetManagement.initializer;

import FleetManagement.model.Usuario;
import FleetManagement.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(String... args) throws Exception {
        Usuario admin = new Usuario();
        admin.setNome("Admin");
        admin.setEmail("admin@admin.com");
        admin.setSenha("admin");
        admin.setRole("ADMIN");
        usuarioService.save(admin);
    }
}
