package com.app.model;

import java.util.Set;

public class Movie {

    private Long id;
    private Long director_id;
    private String title;
    private int runtime;
    private String description;
    private String image;
    private Set<Genre> genres;

    public Movie() {
    }

    public Movie(Long id, Long director_id, String title, int runtime, String describtion, String image) {
        this.id = id;
        this.director_id = director_id;
        this.title = title;
        this.runtime = runtime;
        this.description = description;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDirector_id() {
        return director_id;
    }

    public void setDirector_id(Long director_id) {
        this.director_id = director_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Genre> getGenres() {
        return genres ;
    }

    public void setGenres(Set<Genre> typesOfGenres) {
        this.genres = typesOfGenres;
    }

}
