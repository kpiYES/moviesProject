package com.app.model;

public class Genre {

    private String typeOfGenre;

    public Genre() {
    }

    public Genre(String typeOfGenre) {
        this.typeOfGenre = typeOfGenre;
    }

    public String getTypeOfGenre() {
        return typeOfGenre;
    }

    public void setTypeOfGenre(String typeOfGenre) {
        this.typeOfGenre = typeOfGenre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        return getTypeOfGenre() != null ? getTypeOfGenre().equals(genre.getTypeOfGenre()) : genre.getTypeOfGenre() == null;
    }

    @Override
    public int hashCode() {
        return getTypeOfGenre() != null ? getTypeOfGenre().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "typeOfGenre='" + typeOfGenre + '\'' +
                '}';
    }
}
