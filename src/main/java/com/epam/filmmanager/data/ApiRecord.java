package com.epam.filmmanager.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ApiRecord {
	private Long page;
    @JsonProperty("total_pages")
    private Long totalPages;
    private List<Film> results;

    public static class Film {
        @JsonProperty("title")
        public String name;
        @JsonProperty("original_language")
        public String originalLanguage;
        @JsonProperty("original_title")
        public String originalName;
        @JsonProperty("poster_path")
        public String pictures;
        @JsonProperty("release_date")
        public String date;
        @JsonProperty("genre_ids")
        public List<Integer> genreIDs;
        public String overview;
        
        public String ganres;
        
        public void generateGenreString() {
        	ganres = "";
        	for(Integer ID : genreIDs) {
        		switch (ID) {
	    	        case 28:
	    	        	ganres+=" Боевик";
	    				break;
	    			case 12:
	    		        ganres+=" Приключения";
	    		        break;
	    			case 16:
	    		        ganres+=" Мультфильм";
	    		        break;
	    			case 35:
	    		        ganres+=" Комедия";
	    		        break;
	    			case 80:
	    		        ganres+=" Криминал";
	    		        break;
	    			case 99:
	    		        ganres+=" Документальный";
	    		        break;
	    			case 18:
	    		        ganres+=" Драма";
	    		        break;
	    			case 10751:
	    		        ganres+=" Семейный";
	    		        break;
	    			case 14:
	    		        ganres+=" Фэнтези";
	    		        break;
	    			case 36:
	    		        ganres+=" История";
	    		        break;
	    			case 27:
	    		        ganres+=" Ужасы";
	    		        break;
	    			case 10402:
	    		        ganres+=" Музыка";
	    		        break;
	    			case 9648:
	    		        ganres+=" Детектив";
	    		        break;
	    			case 10749:
	    		        ganres+=" Мелодрама";
	    		        break;
	    			case 878:
	    		        ganres+=" Фантастика";
	    		        break;
	    			case 10770:
	    		        ganres+=" Телевизионный фильм";
	    		        break;
	    			case 53:
	    		        ganres+=" Триллер";
	    		        break;
	    			case 10752:
	    		        ganres+=" Военный";
	    		        break;
	    			case 37:
	    		        ganres+=" Вестерн";
	    			default:
	    				break;
	    		}
        	}
        	if (ganres == "") {
        		ganres = "Четкий фильм:)"; 
        	}
        }
    }
}
