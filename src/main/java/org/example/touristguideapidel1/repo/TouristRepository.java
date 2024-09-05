package org.example.touristguideapidel1.repo;

import org.example.touristguideapidel1.controller.TouristController;
import org.example.touristguideapidel1.model.TouristAttraction;
import org.example.touristguideapidel1.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    //TODO add expections with HTTPS status codes instead of NULLs where it returns

    private List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository() {
        populate();
    }

    public void populate() {
        touristAttractions.add(new TouristAttraction("Eiffel Tower", "An iconic wrought-iron lattice tower in Paris, France."));
        touristAttractions.add(new TouristAttraction("Great Wall of China", "A series of fortifications made of stone, brick, and other materials, built along the northern borders of China."));
        touristAttractions.add(new TouristAttraction("Statue of Liberty", "A colossal neoclassical sculpture on Liberty Island in New York Harbor, USA."));
        touristAttractions.add(new TouristAttraction("Colosseum", "An ancient amphitheater in Rome, Italy, known for its grandeur and history."));
    }


    public List<TouristAttraction> getAllAttractions() {
        return touristAttractions;
    }

    public TouristAttraction getAllAttractionsByName(String name) {
            for (TouristAttraction t : touristAttractions) {
                if (t.getName().equalsIgnoreCase(name)) {
                    return t;
                }
            }
            return null;
    }

    public TouristAttraction addAttraction(String name, String description){
         TouristAttraction touristAttraction = (new TouristAttraction(name,description));
         touristAttractions.add(touristAttraction);
         return touristAttraction;
    }

    public TouristAttraction updateAttraction(String name, String description) {
        for (TouristAttraction t : touristAttractions) {
            if (t.getName().equalsIgnoreCase(name)) {
                t.setName(name);
                t.setDescription(description);
                return t;
            }
        }
        return null;
    }

    public TouristAttraction deleteAttraction(String name){
        for (TouristAttraction t : touristAttractions){
            if (t.getName().equalsIgnoreCase(name)){
                touristAttractions.remove(t);
                return t;
            }
        }
        return null;
    }
}
