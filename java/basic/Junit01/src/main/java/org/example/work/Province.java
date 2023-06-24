package org.example.work;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Province {

    private String name;
    private List<Producer> producers = new ArrayList<>();
    private int totalProduction = 0;
    private int demand = 0;
    private int price = 0;

    public Province(Data data) {
        this.name = data.getName();
        this.demand = data.getDemand();
        this.price = data.getPrice();
        data.getProducers().forEach(s -> addProducer(new Producer(this, s)));
    }

    public void addProducer(Producer arg) {
        producers.add(arg);
        totalProduction += arg.getProduction();
    }

    public int getDemandCost() {
        int remainingDemand = demand;
        int result = 0;

        List<Producer> pList = producers.stream()
                .sorted(Comparator.comparingInt(Producer::getCost))
                .collect(Collectors.toList());

        for(Producer p:pList) {
            int contribution = Math.min(remainingDemand, p.getProduction());
            remainingDemand -= contribution;
            result += contribution * p.getCost();
        }

        return result;
    }

    public void setTotalProduction(int num) {
        totalProduction += num;
    }

    public void setDemand(int num) {
        demand = num;
    }

    public String getName() {
        return name;
    }

    public List<Producer> getProducers() {
        return producers;
    }

    public int getTotalProduction() {
        return totalProduction;
    }

    public int getDemand() {
        return demand;
    }

    public int getPrice() {
        return price;
    }

    public int getShortFall() {
        return demand - totalProduction;
    }

    public int getProfit() {
        return getDemandValue() - getDemandCost();
    }

    public int getDemandValue() {
        return getSatisfiedDemand() * price;
    }

    public int getSatisfiedDemand() {
        return Math.min(demand, totalProduction);
    }

    @Override
    public String toString() {
        return "name: " + name + " producers: " + producers + " totalProduction: " + totalProduction + " demand: " + demand + " price: " + price;
    }


}
