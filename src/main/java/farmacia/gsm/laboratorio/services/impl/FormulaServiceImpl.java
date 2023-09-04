package farmacia.gsm.laboratorio.services.impl;

import farmacia.gsm.laboratorio.entities.Formula;
import farmacia.gsm.laboratorio.repositories.FormulaRepository;
import farmacia.gsm.laboratorio.services.FormulaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormulaServiceImpl implements  FormulaService{
    private final FormulaRepository formulaRepository;

    public Formula save(Formula formula ){
        return formulaRepository.save(formula);
    }
}
