package org.example.work;

import java.util.Map;

public class Producer {

    private Province province;
    private int cost;
    private String name;
    private int production = 0;

    public Producer(Province aProvince, Map<String, String> data) {
        this.province = aProvince;
        this.cost = Integer.parseInt(data.get("cost"));
        this.name = data.get("name");
        this.production = Integer.parseInt(data.get("production"));
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(String arg) {
        cost = Integer.parseInt(arg);
    }

    public int getProduction() {
        return production;
    }

    public void setProduction(String amountStr) {
        int amount = Integer.parseInt(amountStr);
        int newProduction = amount;
        province.setTotalProduction(newProduction - production);
        production = newProduction;
    }

//    @Override
//    public String toString() {
//        return "province: " + province + " cost: " + cost + " name: " + name + " production: " + production;
//    }
}
