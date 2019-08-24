package springAndMongoDB.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springAndMongoDB.Models.Pets;
import springAndMongoDB.Repositories.PetsRepository;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetsController {
    @Autowired
    private PetsRepository petsRepository;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Pets> getAllPets() {
        return petsRepository.findAll();
    }

    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public Pets getPetsByName(@PathVariable("name") String name) {
        return petsRepository.findByName(name);
    }
}
