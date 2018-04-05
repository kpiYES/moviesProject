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
    private Director director;

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

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (getRuntime() != movie.getRuntime()) return false;
        if (getId() != null ? !getId().equals(movie.getId()) : movie.getId() != null) return false;
        if (getDirector_id() != null ? !getDirector_id().equals(movie.getDirector_id()) : movie.getDirector_id() != null)
            return false;
        if (getTitle() != null ? !getTitle().equals(movie.getTitle()) : movie.getTitle() != null) return false;
        if (getDescription() != null ? !getDescription().equals(movie.getDescription()) : movie.getDescription() != null)
            return false;
        return getImage() != null ? getImage().equals(movie.getImage()) : movie.getImage() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDirector_id() != null ? getDirector_id().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + getRuntime();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", director_id=" + director_id +
                ", title='" + title + '\'' +
                ", runtime=" + runtime +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
