package infra;

public class Movie {
    private Integer Year;
    private String Director;
    private String Title;

    public Movie(Integer year, String director, String title) {
        this.Year = year;
        this.Director = director;
        this.Title = title;
    }

    public Integer getYear() {

        return Year;
    }

    public void setYear(Integer year) {

        this.Year = year;
    }

    public String getDirector() {

        return Director;
    }

    public void setDirector(String director) {

        this.Director = director;
    }

    public String getTitle() {

        return Title;
    }

    public void setTitle(String title) {

        this.Title = title;
    }


}
