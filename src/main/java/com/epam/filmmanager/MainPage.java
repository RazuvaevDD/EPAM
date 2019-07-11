package com.epam.filmmanager;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainPage {
	@RequestMapping(value="/", method = RequestMethod.GET)
    public String start(Model model, RedirectAttributes redirectAttrs,
            HttpServletRequest request) {
    	
		String[] films = request.getParameterValues("film");
		
		String filmsStr = "";
		if(films!=null)
			for(int i = 0; i<films.length; i++)
				filmsStr+=films[i]+" ";
		model.addAttribute("films", filmsStr);
		
        return "MainPage";
    }
////////   with PathVariable (experemental)   ////////
//	@RequestMapping(value="/{path}", method = RequestMethod.GET)
//    public String start2(Model model, RedirectAttributes redirectAttrs,@PathVariable("path") String path,
//            HttpServletRequest request) {
//    	
//		String[] films = request.getParameterValues("film");
//		
//		String filmsStr = "";
//		if(films!=null)
//			for(int i = 0; i<films.length; i++)
//				filmsStr+=films[i]+" ";
//		model.addAttribute("films", filmsStr);
//		
//        return "MainPage";
//    }
////////
}