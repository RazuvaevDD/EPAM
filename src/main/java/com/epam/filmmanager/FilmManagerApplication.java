package com.epam.filmmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.json.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FilmManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(FilmManagerApplication.class, args);
		
	}
}
