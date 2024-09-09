package org.example.touristguideapidel1.service;

import org.example.touristguideapidel1.model.TouristAttraction;
import org.example.touristguideapidel1.repo.TouristRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<TouristAttraction> getAllAttractionsByName(String name){
        TouristAttraction attraction = touristRepository.getAllAttractionsByName(name);
        if (attraction != null) {
            return new ResponseEntity<>(attraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<String> addAttraction(TouristAttraction touristAttraction) {
        if (touristRepository.addAttraction(touristAttraction)) {
            return new ResponseEntity<>("Attraction added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add attraction", HttpStatus.NOT_FOUND);
        }
    }

    //TODO add if else Http status
    public TouristAttraction updateAttraction(TouristAttraction touristAttraction){
        return touristRepository.updateAttraction(touristAttraction);
    }

    public ResponseEntity<String> deleteAttraction(String name) {
        if(touristRepository.deleteAttraction(name)){
            return new ResponseEntity<>("Attraction deleted", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Attraction not deleted", HttpStatus.NOT_FOUND);
        }
    }
}
