package Basic;
import java.util.*;

public class areaofcircle {
    public static void main(String args[]) {
        
        Scanner scan = new Scanner(System.in);
        float area, radius;
        
        System.out.print("ENTER RADIUS: ");
        radius = scan.nextFloat();

        area = 3.17f * radius * radius;
        System.out.print("AREA OF CIRCLE IS ");
        System.out.print(area);
        
        scan.close();
    }
}
