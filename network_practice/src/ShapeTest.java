
import java.util.*;

public class ShapeTest
{
    static List<Shape> findShapesByType(List<Shape> shapes, String type) {
        List<Shape> result = new ArrayList<>();
        for(Shape s: shapes){
            if (type == s.getType())
                result.add(s);
        }
        return result;
    }
    static List<Shape> findShapesByColorNArea(List<Shape> shapes, String color, double area){
        List<Shape> result = new ArrayList<>();
        for(Shape s : shapes) {
            if ((color == s.getColor()) && (s.getArea() <= area))
                result.add(s);
        }
        return result;
    }


}
