import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class Shape {
    private String type;
    private String color;
    private Double area;

    public Shape(String type, String color, Double area)  // constructor
    {
        this.type = type;
        this.color = color;
        this.area = area;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public void setArea()
    {
        this.area = area;
    }
    public Double getArea() {
        return area;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String toString(){
        return String.format("%s(%s, %2.1f)", type, color, area);
    }

    // shapes
    public static final List<Shape> shapes;

    static {
        shapes = Arrays.asList(
                new Shape("삼각형", "빨간색", 10.5),
                new Shape("사각형", "파란색", 11.2),
                new Shape("원", "파란색", 16.5),
                new Shape("원", "빨간색", 5.3),
                new Shape("원", "노란색", 8.1),
                new Shape("사각형", "파란색", 20.7),
                new Shape("삼각형", "파란색", 3.4),
                new Shape("사각형", "빨간색", 12.6)
        );
    }

}
