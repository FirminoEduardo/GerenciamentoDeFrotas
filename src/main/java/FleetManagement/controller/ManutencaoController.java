package FleetManagement.controller;

import FleetManagement.model.Manutencao;
import FleetManagement.service.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manutencoes")
public class ManutencaoController {
    @Autowired
    private ManutencaoService manutencaoService;

    @GetMapping
    public List<Manutencao> getAllManutencoes() {
        return manutencaoService.findAll();
    }

    @PostMapping
    public Manutencao createManutencao(@RequestBody Manutencao manutencao) {
        return manutencaoService.save(manutencao);
    }

    @DeleteMapping("/{id}")
    public void deleteManutencao(@PathVariable Long id) {
        manutencaoService.delete(id);
    }

}
