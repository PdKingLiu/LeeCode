package competition_of_leecode;

/**
 * @author liupeidong
 * Created on 2019/9/8 10:31
 */
public class distanceBetweenBusStops_5181 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) {
            return 0;
        }
        int strattem = start;
        int destinationtem = destination;
        int temmin = 0;
        int min;
        while (strattem != destinationtem) {
            temmin += distance[strattem];
            strattem = (strattem + 1) % distance.length;
        }
        min = temmin;
        temmin = 0;
        strattem = start;
        destinationtem = destination;
        while (strattem != destinationtem) {
            temmin += distance[destinationtem];
            destinationtem = (destinationtem + 1) % distance.length;
        }
        min = Math.min(min, temmin);
        return min;
    }
}
