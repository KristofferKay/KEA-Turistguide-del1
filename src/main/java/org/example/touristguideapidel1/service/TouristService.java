package org.example.touristguideapidel1.service;

import org.example.touristguideapidel1.controller.TouristController;
import org.example.touristguideapidel1.model.TouristAttraction;
import org.example.touristguideapidel1.repo.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    //TODO add all ACTIONS inside the service and remove them from REPO
    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAllAttractions(){
        return touristRepository.getAllAttractions();
    }

    public TouristAttraction getAllAttractionsByName(String name){
        return touristRepository.getAllAttractionsByName(name);
    }

    public TouristAttraction addAttraction(String name, String description){
        return touristRepository.addAttraction(name, description);
    }

    public TouristAttraction updateAttraction(String name, String description){
        return touristRepository.addAttraction(name, description);
    }
}
