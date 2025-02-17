package com.example.model.tourism.controller;

import com.example.model.tourism.model.TouristAttraction;
import com.example.model.tourism.service.TouristAttractionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
//Skal have en base URL før HTML virker
@RequestMapping("/attractions")
public class TouristAttractionController {
    private final TouristAttractionService touristAttractionService;

    public TouristAttractionController(TouristAttractionService touristAttractionService){
        this.touristAttractionService = touristAttractionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TouristAttraction>> getAllTouristAttractions(){
        List<TouristAttraction> touristAttractions = touristAttractionService.getAllAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<TouristAttraction> getTouristAttractionByName(@RequestParam String name){
        TouristAttraction touristAttraction = touristAttractionService.findAttractionByName(name);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction (@RequestBody TouristAttraction touristAttraction){
        TouristAttraction newTouristAttraction = touristAttractionService.addTourist(touristAttraction);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.CREATED);
    }


    //Skal laves
    @PutMapping("/update/{name}")
    public ResponseEntity<TouristAttraction> updateAttraction(@PathVariable String name, @RequestBody TouristAttraction updatedTouristAttraction) {
        TouristAttraction updatedAttraction = touristAttractionService.updateTouristAttraction(name, updatedTouristAttraction);
        return new ResponseEntity<>(updatedAttraction, HttpStatus.OK);
    }


    @DeleteMapping("{name}") @ResponseBody
    public String deleteAttraction(@PathVariable String name) {
        touristAttractionService.deleteTouristAttraction(name);
        return "Tourist attraction with name " + name + " has been deleted.";
    }

    @GetMapping("/{name}/tags")
    public ResponseEntity<List<String>> getAttractionTags(@PathVariable String name) {
        TouristAttraction attraction = touristAttractionService.findAttractionByName(name);
        if (attraction != null) {
            return new ResponseEntity<>(attraction.getTags(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}