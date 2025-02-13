package com.example.model.tourism.repository;

import com.example.model.tourism.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository(){
        touristAttractionsPopulate();
    }

    public void touristAttractionsPopulate(){
        touristAttractions.add(new TouristAttraction("Eiffel Tower", "Iconic iron tower offering stunning city views."));
        touristAttractions.add(new TouristAttraction("Great Wall of China", "Ancient wall stretching across breathtaking landscapes."));
        touristAttractions.add(new TouristAttraction("Machu Picchu", "Mystical Incan city nestled in the Andes."));
    }



    public void addAttraction(TouristAttraction attraction){
        touristAttractions.add(attraction);
    }

    public List<TouristAttraction> getAllAttractions(){
        return touristAttractions;
    }


    public TouristAttraction findAttractionByName(String name){
        TouristAttraction temp = null;

        for(TouristAttraction toursAtr : touristAttractions){
            if(toursAtr.getName().equalsIgnoreCase(name)){
                temp = toursAtr;
            }

        }

        return temp;
    }


    public TouristAttraction updateTouristAttraction(String name, TouristAttraction updatedTouristAttraction){
        for(int i = 0; i < touristAttractions.size(); i++){
            if(touristAttractions.get(i).getName().equalsIgnoreCase(name)){
                touristAttractions.set(i, updatedTouristAttraction);
                return updatedTouristAttraction;
            }
        }
        return null; // Hvis ikke fundet
    }



    public void deleteAttraction(String name){
        for(int i = 0; i < touristAttractions.size(); i++){
            if(touristAttractions.get(i).getName().equalsIgnoreCase(name)){
                touristAttractions.remove(i);
                break;
            }
        }
    }



}
