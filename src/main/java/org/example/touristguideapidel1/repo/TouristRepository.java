package org.example.touristguideapidel1.repo;

import org.example.touristguideapidel1.model.TouristAttraction;
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
        touristAttractions.add(new TouristAttraction("Københavns Zoo", "København Zoo eller Zoologisk Have i København er på 11 ha og en af Europas ældste zoologiske haver. Den ligger på Frederiksberg ved Roskildevej på Valby Bakke. København Zoo har 181 fuldtidsansatte og et årligt besøgstal på ca. 1.3 mio. Der er over 3.500 dyr fordelt på 227 arter i København Zoo."));
        touristAttractions.add(new TouristAttraction("Amalienborg slot", "Amalienborg er et slotsanlæg i Frederiksstaden i København og er hovedresidens for det danske Kongehus. Anlægget består af fire næsten ens palæer, der omkranser en ottekantet slotsplads. Amalienborg er et hovedværk i dansk bygningskunst og nok det fornemste stykke rokokoarkitektur i Danmark og måske et af de fineste eksempler i Europa"));
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

    public boolean addAttraction(TouristAttraction touristAttraction){
        if (touristAttractions.add(touristAttraction)){
            return true;
        }
         return false;
    }

    public TouristAttraction updateAttraction(TouristAttraction touristAttraction) {
        for(int i =0; i < touristAttractions.size(); i++){
            if(touristAttractions.get(i).getName().equalsIgnoreCase(touristAttraction.getName())){
                touristAttractions.get(i).setName(touristAttraction.getName());
                touristAttractions.get(i).setDescription(touristAttraction.getDescription());
                return touristAttractions.set(i, touristAttraction);
            }
        }
        return touristAttraction;
    }

    public boolean deleteAttraction(String name){
        for (TouristAttraction t : touristAttractions){
            if (t.getName().equalsIgnoreCase(name)){
                touristAttractions.remove(t);
                return true;
            }
        }
        return false;
    }
}
