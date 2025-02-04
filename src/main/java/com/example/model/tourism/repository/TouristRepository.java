package com.example.model.tourism.repository;

import com.example.model.tourism.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    List<TouristAttraction> touristAttractions = new ArrayList<>();

    public List<TouristAttraction> touristAttractionsList(){
        touristAttractions.add(new TouristAttraction("Eiffel Tower", "Iconic iron tower offering stunning city views."));
        touristAttractions.add(new TouristAttraction("Great Wall of China", "Ancient wall stretching across breathtaking landscapes."));
        touristAttractions.add(new TouristAttraction("Machu Picchu", "Mystical Incan city nestled in the Andes."));

        return touristAttractions;
    }



}
