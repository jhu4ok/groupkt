package dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class StateDTO {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private @NonNull int id;
    private @NonNull String country;
    private @NonNull String name;
    private @NonNull String abbr;
    private @NonNull String area;
    private @NonNull String largest_city;
    private @NonNull String capital;


    public StateDTO(int id, String country, String name, String abbr, String area, String largest_city, String capital) {
        this.id = id;
        this.country = country;
        this.name = name;
        this.abbr = abbr;
        this.area = area;
        this.largest_city = largest_city;
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "StateDTO [id=" + id + ", country=" + country + ", name=" + name + "]";
    }
}
