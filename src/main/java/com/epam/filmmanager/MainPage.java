package com.epam.filmmanager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
		
		
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        List<FilmBlock>  filmBlocks = new ArrayList<FilmBlock>();
        
        try {
            JSONObject obj = new JSONObject(getRest(films[0]));

            int total_results = obj.getInt("total_results");
            int total_pages = obj.getInt("total_pages");
            System.out.println(total_results + " " + total_pages);

            JSONArray arr = obj.getJSONArray("results");
            
            for(int i=0;i<arr.length();i++)
                //filmBlocks.add(context.getBean("FilmBlock", FilmBlock.class));
            	filmBlocks.add(new FilmBlock());
            
            for (int i = 0; i < arr.length(); i++) {
                try {
                    filmBlocks.get(i).setTitle(arr.getJSONObject(i).getString("title"));
                    filmBlocks.get(i).setOriginal_language(arr.getJSONObject(i).getString("original_language"));
                    filmBlocks.get(i).setOriginal_title(arr.getJSONObject(i).getString("original_title"));
                    filmBlocks.get(i).setPoster_path(arr.getJSONObject(i).getString("poster_path"));
                    filmBlocks.get(i).setRelease_date(arr.getJSONObject(i).getString("release_date"));
                    filmBlocks.get(i).setOverview(arr.getJSONObject(i).getString("overview"));
                } catch (org.json.JSONException e) {
                }
            }
            
            
            String htmlFilms = "";
            for(int i=0;i<arr.length();i++)
            	htmlFilms+=filmBlocks.get(i);
            

    		model.addAttribute("films", filmsStr+" "+(htmlFilms));
            
        }catch (org.json.JSONException e){
        }catch (java.lang.NullPointerException e) {
        }
		
		
        return "MainPage";
    }
	
	public static String getRest(String request) {
	    String res = "";
	    try {
	        URL url = new URL("https://api.themoviedb.org/3/search/movie?api_key=748998fd3047279443fd976cf5cd627f&language=ru-RU&page=1&include_adult=false&query="+java.net.URLEncoder.encode(request, "UTF-8"));

	        String encoding = "";

	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");
	        connection.setDoOutput(true);
	        //connection.setRequestProperty("Authorization", "Basic " + encoding);
	        InputStream content = connection.getInputStream();
	        BufferedReader in =
	                new BufferedReader(new InputStreamReader(content));
	        String line;
	        while ((line = in.readLine()) != null) {
	            res += line + "\n";
	        }

	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return res;
	}
}