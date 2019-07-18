package com.epam.filmmanager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.data.ApiRecord.Film;
import com.epam.repository.ApiRepository;

@Controller
public class MainPage {
	
	ApiRepository apiRepo;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
    public String start(Model model, RedirectAttributes redirectAttrs,
            HttpServletRequest request) {
    	
		String[] filmsQuery = request.getParameterValues("film");
		
		if(filmsQuery!=null) {
			apiRepo = new ApiRepository();
			List<Film> films =  apiRepo.findByQuery(filmsQuery[0]).getResults();
			model.addAttribute("films", films);
		}
		
        return "MainPage";
    }
}