package com.epam.filmmanager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.filmmanager.data.ApiRecord.Film;
import com.epam.filmmanager.repository.ApiRepository;

@Controller
public class MainPage {
	
	private ApiRepository apiRepo;
	
	public MainPage(ApiRepository rep) {
		this.apiRepo = rep;
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
    public String start(Model model, RedirectAttributes redirectAttrs,
            HttpServletRequest request, @RequestParam(defaultValue = "") String search) {
    	
		if(!search.isEmpty()){
			
			List<Film> films =  apiRepo.findByQuery(search).getResults();
			for(Film filmVar : films) {
				filmVar.generateGenreString();
			}
			
			model.addAttribute("films", films);
		}
		
        return "MainPage";
    }
}