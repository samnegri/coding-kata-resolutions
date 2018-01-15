package br.com.sam.tests;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Samuel Negri Morais on 1/14/18.
 */
public class Tests {

/*    public static void main(String[] args) {
        System.out.println("olar");



    }*/

    static List<Integer> greatestFlightRangeDrones(Integer numberOfRequiredDrones, List<Drone> drones, List<Integer> inMaintenanceDrones) {
        return drones.stream()
            .filter(drone -> !inMaintenanceDrones.contains(drone.getId()))
            .sorted((drone1,drone2) -> Integer.compare(drone2.flightRange,drone1.flightRange))
            .limit(numberOfRequiredDrones)
            .map(Drone::getId)
            .collect(Collectors.toList());
    }


    private static class Drone {
        private int id;
        private int flightRange;

        public Drone(int id, int flightRange) {

            this.id = id;
            this.flightRange = flightRange;
        }

        public int getId() {
            return id;
        }

        public int getFlightRange() {
            return flightRange;
        }
    }

    // The first line of the input contains three decimal integers separated by space: total number of drones ('D'), number of drones to be selected ('G') and number of drones in maintenance ('M').
    // The following 'D' lines each contains two decimal integers separated by space with information about each drone: ID and flight range in kilometers.
    // The following 'M' lines each contains the numeric ID of a drone currently in maintenance.

    // Print the IDs of the 'G' selected drones to the standard output, one per line, sorted by flight range (greater first).
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfDrones = in.nextInt();
        int numberOfRequiredDrones = in.nextInt();
        int numberOfDronesInMaintenance = in.nextInt();

        List<Drone> drones = new ArrayList<Drone>();
        List<Integer> inMaintenanceDrones = new ArrayList<Integer>();

        for(int i=0; i< numberOfDrones; i++) {
            drones.add(new Drone(in.nextInt(), in.nextInt()));
        }

        for(int i=0; i< numberOfDronesInMaintenance; i++) {
            inMaintenanceDrones.add(in.nextInt());
        }

        List<Integer> greatestFlightRangeDrones = greatestFlightRangeDrones(numberOfRequiredDrones, drones, inMaintenanceDrones);

        for(int i=0; i < greatestFlightRangeDrones.size(); i++) {
            System.out.println(greatestFlightRangeDrones.get(i));
        }

    }


    static int minimumNumberOfTrips(int tripMaxWeight, int[] packagesWeight) {
        if (packagesWeight.length == 0) {
            return 0;
        }

        Map<Integer, Integer> packagesWeightMap = createMapWithIds(packagesWeight, tripMaxWeight);
        int minumumTrips = 0;
        int sumWeight = 0;
        int sumPackages = 0;

        while(!packagesWeightMap.isEmpty()) {
            final int finalSumWeight = sumWeight;
            Optional<Map.Entry<Integer, Integer>> maybeMax = packagesWeightMap.entrySet().stream()
                .filter(entry -> entry.getValue() <= tripMaxWeight - finalSumWeight)
                .max((Comparator.comparing(Map.Entry::getValue)));

            if(maybeMax.isPresent()) {
                Map.Entry<Integer, Integer> max = maybeMax.get();
                sumWeight += max.getValue();
                sumPackages++;
                packagesWeightMap.remove(max.getKey());
            } else {
                sumPackages = 0;
                sumWeight =0;
                minumumTrips++;
            }

            if(sumPackages == 2) {
                sumPackages=0;
                minumumTrips++;
                sumWeight = 0;
            }
        }
        return minumumTrips + ((sumWeight != 0 || minumumTrips != 0) ? 1 : 0);
//        return minumumTrips + 1;
    }

    private static Map<Integer, Integer> createMapWithIds(int[] packagesWeight, int maxWeight) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < packagesWeight.length; i++) {
            map.put(i,packagesWeight[i]);
        }

        return map.entrySet().stream()
            .filter(entry -> entry.getValue() < maxWeight)
            .sorted(Comparator.comparing(Map.Entry::getValue))
            .collect(java.util.stream.Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                HashMap::new
            ));
    }

}
/*
    static int minimumNumberOfTrips(int tripMaxWeight, int[] packagesWeight) {
        int minumumTrips = 0;
        int sumWeight = 0;
        int sumPackages = 0;

        if (packagesWeight.length == 0) {
            return 0;
        }

        for(int i = 0; i < packagesWeight.length; i++) {
            int currentWeight = packagesWeight[i];
            //System.out.println( currentWeight + " " + sumWeight );
            if(currentWeight > tripMaxWeight) {
                continue;
            }

            if(sumWeight + currentWeight > tripMaxWeight
                || sumPackages == 2 ) {
                minumumTrips++;
                sumWeight = currentWeight;
                sumPackages = 0;
            } else {
                sumWeight += currentWeight;
                sumPackages++;
            }
        }

        return minumumTrips + 1;

    }
* */