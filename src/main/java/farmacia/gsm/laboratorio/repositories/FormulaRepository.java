package farmacia.gsm.laboratorio.repositories;

import farmacia.gsm.laboratorio.entities.Formula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormulaRepository extends JpaRepository<Formula, Long> {
    Formula save(Formula formula);
}
