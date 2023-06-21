package org.example.work;

import java.util.*;

public class Data {

    private String name;
    private List<Map<String, String>> producers;
    private int demand = 0;
    private int price = 0;

    public Data(String name, List<Map<String, String>> producers, int demand, int price) {
        this.name = name;
        this.producers = producers;
        this.demand = demand;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public List<Map<String, String>> getProducers() {
        return producers;
    }

    public int getDemand() {
        return demand;
    }

    public int getPrice() {
        return price;
    }

    public static Data sampleProvinceData() {
        List<Map<String, String>> producers = new ArrayList<>();
        List<String> names = Arrays.asList("Byzantium,10,9","Attalia,12,10","Sinope,10,6" );

        names.forEach(s -> {
            Map<String, String> sample = new HashMap<>();
            sample.put("name", s.split(",")[0]);
            sample.put("cost", s.split(",")[1]);
            sample.put("production", s.split(",")[2]);
            producers.add(sample);
        });

        return new Data("Asia",producers, 30, 20);
    }

}
