package org.example.touristguideapidel1.model;

import org.springframework.http.HttpStatus;

public class TouristAttraction {
    private String name;
    private String description;

    public TouristAttraction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public TouristAttraction(){

    }

    public TouristAttraction(HttpStatus httpStatus){

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TouristAttraction{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
