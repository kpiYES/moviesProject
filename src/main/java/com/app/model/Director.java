package com.app.model;

import java.time.LocalDate;

public class Director {

    private String name;
    private LocalDate dayOfBirth;
    private String imagine;

    public Director(){
    };


    public Director(String name, LocalDate dayOfBirth, String imagine) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.imagine = imagine;
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

        Director director = (Director) o;

        if (getName() != null ? !getName().equals(director.getName()) : director.getName() != null) return false;
        if (getDayOfBirth() != null ? !getDayOfBirth().equals(director.getDayOfBirth()) : director.getDayOfBirth() != null)
            return false;
        return getImagine() != null ? getImagine().equals(director.getImagine()) : director.getImagine() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getDayOfBirth() != null ? getDayOfBirth().hashCode() : 0);
        result = 31 * result + (getImagine() != null ? getImagine().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", imagine='" + imagine + '\'' +
                '}';
    }
}

