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
    private List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository() {
        populate();
    }

    public void populate() {
        touristAttractions.add(new TouristAttraction("Attraction1", "desc1"));
        touristAttractions.add(new TouristAttraction("Attraction2", "desc2"));
        touristAttractions.add(new TouristAttraction("Attraction3", "desc3"));
    }


    public List<TouristAttraction> getAllAttractions() {
        return touristAttractions;
    }

    public TouristAttraction getAllAttractionsByName(String name) {
        try {
            for (TouristAttraction t : touristAttractions) {
                if (t.getName().equalsIgnoreCase(name)) {
                    return t;
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(String.valueOf(HttpStatus.NOT_FOUND));
        }
    }

    public TouristAttraction addAttraction(String name, String description){
         TouristAttraction touristAttraction = (new TouristAttraction(name,description));
         touristAttractions.add(touristAttraction);
         return touristAttraction;
    }

}
