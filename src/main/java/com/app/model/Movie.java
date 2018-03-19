package com.app.model;

public class Movie {

    private String title;
    private int runtime;
    private String describtion;
    private String imagine;

    public Movie() {
    }

    public Movie(String title, int runtime, String describtion, String imagine) {
        this.title = title;
        this.runtime = runtime;
        this.describtion = describtion;
        this.imagine = imagine;
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

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (getRuntime() != movie.getRuntime()) return false;
        if (getTitle() != null ? !getTitle().equals(movie.getTitle()) : movie.getTitle() != null) return false;
        if (getDescribtion() != null ? !getDescribtion().equals(movie.getDescribtion()) : movie.getDescribtion() != null)
            return false;
        return getImagine() != null ? getImagine().equals(movie.getImagine()) : movie.getImagine() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + getRuntime();
        result = 31 * result + (getDescribtion() != null ? getDescribtion().hashCode() : 0);
        result = 31 * result + (getImagine() != null ? getImagine().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", runtime=" + runtime +
                ", describtion='" + describtion + '\'' +
                ", imagine='" + imagine + '\'' +
                '}';
    }
}
