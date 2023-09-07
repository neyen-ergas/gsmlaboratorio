package farmacia.gsm.laboratorio.services.impl;

import farmacia.gsm.laboratorio.entities.ImgRecipe;
import farmacia.gsm.laboratorio.repositories.ImgRecipeRepository;
import farmacia.gsm.laboratorio.services.ImgRecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImgRecipeServiceImpl implements ImgRecipeService {
    private final ImgRecipeRepository imgRecipeRepository;

    public ImgRecipe save(ImgRecipe imgRecipe ){
        return imgRecipeRepository.save(imgRecipe);
    }
}
