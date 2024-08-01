package FleetManagement.controller;

import FleetManagement.model.Veiculo;
import FleetManagement.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return veiculoService.findAll();
    }

    @PostMapping
    public ResponseEntity<Veiculo> addVeiculo(@RequestBody Veiculo veiculo) {
        return ResponseEntity.ok(veiculoService.save(veiculo));
    }

    @DeleteMapping("/{id}")
    public void deleteVeiculo(@PathVariable Long id) {
       veiculoService.delete(id);
    }
}
