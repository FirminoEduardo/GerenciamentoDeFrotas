package FleetManagement.service;

import FleetManagement.model.Manutencao;
import FleetManagement.repository.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManutencaoService {
    @Autowired
    private ManutencaoRepository manutencaoRepository;

    public List<Manutencao> findAll() {
        return manutencaoRepository.findAll();
    }

    public Manutencao save(Manutencao manutencao) {
        return manutencaoRepository.save(manutencao);
    }

    public void delete(Long id) {
        manutencaoRepository.deleteById(id);
    }
}
