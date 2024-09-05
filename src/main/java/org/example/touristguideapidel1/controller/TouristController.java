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
        return touristService.getAllAttractionsByName(name);
    }

    //Add new
    @PostMapping("add")
    public ResponseEntity<String> addAttraction(@RequestBody TouristAttraction touristAttraction){
        return touristService.addAttraction(touristAttraction);
    }

    //Update existing
    @PostMapping("update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction touristAttraction){
        return new ResponseEntity<>(touristService.updateAttraction(touristAttraction), HttpStatus.OK);
    }

    //delete by name
    @PostMapping("delete/{name}")
    public ResponseEntity<String> deleteAttraction(@PathVariable String name){
        return touristService.deleteAttraction(name);
    }
}
