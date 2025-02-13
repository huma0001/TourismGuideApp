package com.example.model.tourism.service;

import com.example.model.tourism.model.TouristAttraction;
import com.example.model.tourism.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristAttractionService {
    private final TouristRepository touristRepository;


    public TouristAttractionService(TouristRepository touristRepository){
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAllAttractions(){
        return touristRepository.getAllAttractions();
    }


    public TouristAttraction addTourist(TouristAttraction touristAttraction){
        touristRepository.addAttraction(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction findAttractionByName(String name){
        return touristRepository.findAttractionByName(name);
    }


    public void deleteTouristAttraction(String name){
        touristRepository.deleteAttraction(name);
    }

    public TouristAttraction updateTouristAttraction(String name, TouristAttraction updatedTouristAttractoin){
        touristRepository.updateTouristAttraction(name, updatedTouristAttractoin);
        return updatedTouristAttractoin;
    }
}






