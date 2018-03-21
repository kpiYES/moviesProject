package com.app.model;

public class Genre {

    private int id;

    private String typeOfGenre;

    public Genre() {
    }

    public Genre(int id,String typeOfGenre) {
        this.id=id;
        this.typeOfGenre = typeOfGenre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        if (getId() != genre.getId()) return false;
        return getTypeOfGenre() != null ? getTypeOfGenre().equals(genre.getTypeOfGenre()) : genre.getTypeOfGenre() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getTypeOfGenre() != null ? getTypeOfGenre().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", typeOfGenre='" + typeOfGenre + '\'' +
                '}';
    }
}
