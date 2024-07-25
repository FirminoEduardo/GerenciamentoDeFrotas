package FleetManagement.controller;

import FleetManagement.model.Manutencao;
import FleetManagement.model.Veiculo;
import FleetManagement.repository.ManutencaoRepository;
import FleetManagement.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manutencoes")
public class ManutencaoController {

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public List<Manutencao> getAllManutencoes() {
        return manutencaoRepository.findAll();
    }

    @PostMapping
    public Manutencao createManutencao(@RequestBody Manutencao manutencao) {
        // Verifica se o veículo existe
        Veiculo veiculo = veiculoRepository.findById(manutencao.getVeiculo().getId())
                .orElseThrow(() -> new RuntimeException("Veiculo not found"));
        manutencao.setVeiculo(veiculo);
        return manutencaoRepository.save(manutencao);
    }

    @PutMapping("/{id}")
    public Manutencao updateManutencao(@PathVariable Long id, @RequestBody Manutencao manutencaoDetails) {
        Manutencao manutencao = manutencaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manutencao not found"));

        Veiculo veiculo = veiculoRepository.findById(manutencaoDetails.getVeiculo().getId())
                .orElseThrow(() -> new RuntimeException("Veiculo not found"));

        manutencao.setVeiculo(veiculo);
        manutencao.setData(manutencaoDetails.getData());
        manutencao.setTipo(manutencaoDetails.getTipo());
        manutencao.setDescricao(manutencaoDetails.getDescricao());

        return manutencaoRepository.save(manutencao);
    }

    @DeleteMapping("/{id}")
    public void deleteManutencao(@PathVariable Long id) {
        Manutencao manutencao = manutencaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manutencao not found"));

        manutencaoRepository.delete(manutencao);
    }
}
