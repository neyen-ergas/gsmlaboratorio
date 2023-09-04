package farmacia.gsm.laboratorio.repositories;

import farmacia.gsm.laboratorio.entities.ImgRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgRecipeRepository extends JpaRepository<ImgRecipe, Long> {

    ImgRecipe save(ImgRecipe imgRecipe);
}
