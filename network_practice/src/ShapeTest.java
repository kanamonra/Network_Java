
import java.util.*;

public class ShapeTest
{
    static List<Shape> findShapes1(List<Shape> shapes, String type, String color, Double area){
        List<Shape> result1 = new ArrayList<>();
        List<Shape> result2 = new ArrayList<>();

        for(Shape s : shapes) {
            if (type == s.getType())
                result1.add(s);
        }
        System.out.println(type + " : " + result1);

        for(Shape s : shapes) {
            if ((color == s.getColor()) && (s.getArea() <= area))
                result2.add(s);
        }
        System.out.println(color + " 도형(면적<=12.0) : " + result2);

        return shapes;
    }


}
