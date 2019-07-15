package com.epam.filmmanager;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component ("FilmBlock")
@Scope("prototype")

public class FilmBlock {
    String title = "title";
    String original_title = "original_title";
    String release_date = "release_date";
    String original_language = "original_language";
    String poster_path = "backdrop_path";
    String overview = "overview";

    FilmBlock(){
    }

//    FilmBlock(String title, String original_title, String release_date, String original_language, String backdrop_path, String overview){
//        this.title = title;
//        this.original_title = original_title;
//        this.release_date = release_date;
//        this.original_language = original_language;
//        this.poster_path = backdrop_path;
//        this.overview = overview;
//    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @Override
    public String toString() {
        return "<table>\n" +
                "<tbody>\n" +
                "<tr style=\"height: 1%;\">\n" +
                "<td style=\"height: 1%; width: 100%\" colspan=\"2\">\n" +
                "<h1><span aria-labelledby=\"value\"><span class=\"objectBox objectBox-string\"><strong><em>"+title+" ("+original_title+")</em></strong></span></span></h1>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 61%;\">\n" +
                "<td style=\"height: 1%; width: 497px;\" colspan=\"2\">\n" +
                "<h2 style=\"color: #2e6c80;\"><span aria-labelledby=\"value\"><span class=\"objectBox objectBox-string\">"+release_date+"</span></span></h2>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 1%;\">\n" +
                "<td style=\"height: 1%; width: 193px;\">\n" +
                "<p><img src=\"https://image.tmdb.org/t/p/w200"+poster_path+"\" width=\"193\" height=\"276\" /></p>\n" +
                "</td>\n" +
                "<td style=\"height: 1%; width: 100%\">\n" +
                "<table style=\"width: 100%; height: 100%; float: left;\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td>Оригинальный язык:</td>\n" +
                "<td>"+original_language+"</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>Описание:</td>\n" +
                "<td>"+overview+"</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>";
    }
}