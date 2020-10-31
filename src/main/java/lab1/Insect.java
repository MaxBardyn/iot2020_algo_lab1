package lab1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Insect {


    private String name;

    private Float speed;

    private Float weight;

    public static String getHeaders() {
        return "name, speed, weight";
    }

    public String toCSV() {
        return name + ", " + speed + ", " + weight;
    }
}
