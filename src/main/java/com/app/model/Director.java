package com.app.model;

import java.time.LocalDate;
import java.util.List;

public class Director {

    private Long id;
    private String name;
    private LocalDate dayOfBirth;
    private String image;
    private List<Movie> movieList;

    public Director() {
    }


    public Director(Long id, String name, LocalDate dayOfBirth, String imagine) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Movie> getMovies() {
        return movieList;
    }

    public void setMovies(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Director director = (Director) o;

        if (getId() != director.getId()) return false;
        if (getName() != null ? !getName().equals(director.getName()) : director.getName() != null) return false;
        if (getDayOfBirth() != null ? !getDayOfBirth().equals(director.getDayOfBirth()) : director.getDayOfBirth() != null)
            return false;
        return getImage() != null ? getImage().equals(director.getImage()) : director.getImage() == null;
    }

    @Override
    public int hashCode() {
        int result = Math.toIntExact(getId());
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDayOfBirth() != null ? getDayOfBirth().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", image='" + image + '\'' +
                '}';
    }
}

