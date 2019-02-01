package com.abhi.java.PrepGS;

/**
 * Created by abhdogra1 on 1/31/2019.
 */

import java.util.*;

/**
 * Instructions to candidate.
 * 1) Run this code in the REPL to observe its behaviour. The
 * execution entry point is main().
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement def shortestPath(self, fromStationName, toStationName)
 * method to find shortest path between 2 stations
 * 4) If time permits, some possible follow-ups.
 */

/*
 *      Visual representation of the Train map used
 *
 *      King's Cross St Pancras --- Angel ---- Old Street
 *      |                   \                            |
 *      |                    \                            |
 *      |                     \                            |
 *      Russell Square         Farringdon --- Barbican --- Moorgate
 *      |                                                  /
 *      |                                                 /
 *      |                                                /
 *      Holborn --- Chancery Lane --- St Paul's --- Bank
 */

public class TrainMap {

    /**
     * class Station
     * <p>
     * Respresents Station in the rail network. Each station is identified by
     * unique name. Station is connected with other stations - this information
     * is stored in the 'neighbours' field. Two station objects with the same name are
     * equal therefore they are considered to be same station.
     */
    private static class Station {
        private String name;
        private List<Station> neighbours;

        public Station(String name) {
            this.name = name;
            this.neighbours = new ArrayList<>(3);
        }

        String getName() {
            return name;
        }

        void addNeighbour(Station v) {
            this.neighbours.add(v);
        }

        List<Station> getNeighbours() {
            return this.neighbours;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Station && this.name.equals(((Station) obj).getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.name);
        }
    }

    /**
     * class TrainMap
     * <p>
     * Respresents whole rail network - consists of number of the Station objects.
     * Stations in the map are bi-directionally connected. Distance between any 2 stations
     * is of same constant distance unit. This implies that shortest distance between any
     * 2 stations depends only on number of stations in between
     */
    private static class TrainMapping {

        private HashMap<String, Station> stations;

        public TrainMapping() {
            this.stations = new HashMap<>();
        }

        public TrainMapping addStation(String name) {
            Station s = new Station(name);
            this.stations.putIfAbsent(name, s);
            return this;
        }

        public Station getStation(String name) {
            return this.stations.get(name);
        }

        public TrainMapping connectStations(Station fromStation, Station toStation) {
            if (fromStation == null) {
                throw new IllegalArgumentException("From station is null");
            }
            if (toStation == null) {
                throw new IllegalArgumentException("From station is null");
            }
            fromStation.addNeighbour(toStation);
            toStation.addNeighbour(fromStation);
            return this;
        }

        public List<Station> shortestPath(String from, String to) {
        /*
         * TODO Implement
         */
            Station fromStation = stations.get(from);
            Station toStation = stations.get(to);

            return getShortestPath(fromStation, toStation);
        }


        private List<Station> getShortestPath(Station fromStation, Station toStation) {

            //this queue will keep on adding elemets to it and will poll then mark them as visited
            Queue<Station> isVisited = new LinkedList<Station>();
            //this map is used to taking the path with us, we store every node as key and its previous node as its value
            //we will use this map to generate the final path
            // this map is like Map<currentPostion, parentPositionOfCurrent>,
            // parentPositionOfCurrent is position form where current is getting callled or linked to.
            HashMap<Station, Station> pathMapping = new HashMap<>();

            //we add start point to the queue
            isVisited.add(fromStation);
            //as from start point there will be no parent to
            pathMapping.put(fromStation,null);

            //We traverse the queue till it is empty
            while(!isVisited.isEmpty()){
                //poll the firt station
                Station st = isVisited.poll();
                //if first station is our destination then there is not path then path is null
                if(st.getName().equalsIgnoreCase(toStation.getName())){
                    break;
                }
                // for polled station, we check for every node it points to add it to queue
                // and update pathMapping map will child node with its parent node which is polled node from the queue
                // which we polled above
                // here we also have to make visited check,
                // for visited node check, we take help of map, we are adding every nodes to map,
                // if that node is already present in the map, then that means we have already visited that node
                for(Station neighbour : st.getNeighbours()){
                    if(!pathMapping.containsKey(neighbour)){
                        isVisited.add(neighbour);
                        pathMapping.put(neighbour,st);
                    }
                }
            }

            //after above while loop, we know that either we came out from break statement
            // or we traversed entire graph and destination node was not found.
            // we make that check here
            if(!pathMapping.containsKey(toStation))
                return null;

            // resultant list to hold the path
            List<Station> result = new LinkedList<>();

            Station curr = toStation;

            // we start from destination and traverse back in the map to its source station, which will return the value null
            // as above we inserted source value as nulll (as there is no parent for source)
            while (curr != null){
                result.add(0,curr);
                curr = pathMapping.get(curr);
            }

            //"King's Cross St Pancras->Russel Square->Holborn->Chancery Lane->St Paul's";

            return result;


        }

        public static String convertPathToStringRepresentation(List<Station> path) {
            if (path.isEmpty()) {
                return "";
            }
            return path.stream().map(Station::getName).reduce((s1, s2) -> s1 + "->" + s2).get();
        }
    }


    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        TrainMapping trainMap = new TrainMapping();

        trainMap.addStation("King's Cross St Pancras").addStation("Angel").addStation("Old Street").addStation("Moorgate")
                .addStation("Farringdon").addStation("Barbican").addStation("Russel Square").addStation("Holborn")
                .addStation("Chancery Lane").addStation("St Paul's").addStation("Bank");

        trainMap.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Angel"))
                .connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Farringdon"))
                .connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Russel Square"))
                .connectStations(trainMap.getStation("Russel Square"), trainMap.getStation("Holborn"))
                .connectStations(trainMap.getStation("Holborn"), trainMap.getStation("Chancery Lane"))
                .connectStations(trainMap.getStation("Chancery Lane"), trainMap.getStation("St Paul's"))
                .connectStations(trainMap.getStation("St Paul's"), trainMap.getStation("Bank"))
                .connectStations(trainMap.getStation("Angel"), trainMap.getStation("Old Street"))
                .connectStations(trainMap.getStation("Old Street"), trainMap.getStation("Moorgate"))
                .connectStations(trainMap.getStation("Moorgate"), trainMap.getStation("Bank"))
                .connectStations(trainMap.getStation("Farringdon"), trainMap.getStation("Barbican"))
                .connectStations(trainMap.getStation("Barbican"), trainMap.getStation("Moorgate"));

        String solution = "King's Cross St Pancras->Russel Square->Holborn->Chancery Lane->St Paul's";

        return solution.equals(TrainMapping.convertPathToStringRepresentation(trainMap.shortestPath("King's Cross St Pancras", "St Paul's")));
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}
