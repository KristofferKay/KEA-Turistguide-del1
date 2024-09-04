package org.example.touristguideapidel1.controller;

import org.example.touristguideapidel1.model.TouristAttraction;
import org.example.touristguideapidel1.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {
    private TouristService touristService;

    public TouristController(TouristService touristService){
        this.touristService = touristService;
    }

    //All
    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getAllAttractions(){
        List<TouristAttraction> messagesModels = touristService.getAllAttractions();
        return new ResponseEntity<>(messagesModels, HttpStatus.OK);
    }


    //Only by name
    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAllAttractionsByName(@PathVariable String name){
        TouristAttraction touristServiceAllAttractionsByName = touristService.getAllAttractionsByName(name);
        return new ResponseEntity<>(touristServiceAllAttractionsByName, HttpStatus.OK);
    }

    //Add new
    @PostMapping("add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestParam String name, @RequestParam String description){
        TouristAttraction touristAttraction = touristService.addAttraction(name,description);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    //Update existing
    //TODO change return type to String
    @PostMapping("update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestParam String name, @RequestParam String description){
        TouristAttraction touristAttraction = touristService.updateAttraction(name,description);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    //delete by name
    @PostMapping("delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name){
        TouristAttraction deleteAttraction = touristService.deleteAttraction(name);
        return new ResponseEntity<>(deleteAttraction, HttpStatus.OK);
    }
}
