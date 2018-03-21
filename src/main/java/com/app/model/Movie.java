package com.app.model;

public class Movie {

    private int id;
    private int director_id;
    private String title;
    private int runtime;
    private String describtion;
    private String image;

    public Movie() {
    }

    public Movie(int id ,int director_id,String title, int runtime, String describtion, String image) {
        this.id = id;
        this.director_id = director_id;
        this.title = title;
        this.runtime = runtime;
        this.describtion = describtion;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
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

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (getId() != movie.getId()) return false;
        if (getDirector_id() != movie.getDirector_id()) return false;
        if (getRuntime() != movie.getRuntime()) return false;
        if (getTitle() != null ? !getTitle().equals(movie.getTitle()) : movie.getTitle() != null) return false;
        if (getDescribtion() != null ? !getDescribtion().equals(movie.getDescribtion()) : movie.getDescribtion() != null)
            return false;
        return getImage() != null ? getImage().equals(movie.getImage()) : movie.getImage() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getDirector_id();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + getRuntime();
        result = 31 * result + (getDescribtion() != null ? getDescribtion().hashCode() : 0);
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
                ", describtion='" + describtion + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
