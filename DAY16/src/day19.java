import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class day19 {
    public static void main(String[] args)  {
        List<Integer> dataArray = new ArrayList<>();
        dataArray.add(188);
        dataArray.add(134);
        dataArray.add(323);
        dataArray.add(956);
        dataArray.add(567);
        for(Integer data : dataArray)
            System.out.print(data + " ");
        System.out.println();
        dataArray.sort(Comparator.naturalOrder());
        for(Integer data : dataArray)
            System.out.print(data + " ");
        dataArray.sort(Comparator.naturalOrder());
    }
}
