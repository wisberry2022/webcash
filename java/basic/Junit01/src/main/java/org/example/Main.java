package org.example;

import org.example.work.Data;
import org.example.work.Province;

public class Main {
    public static void main(String[] args) {

        Data sample = Data.sampleProvinceData();

        Province pvc = new Province(sample);
        System.out.println(pvc);

        System.out.println(pvc.getShortFall() + " " + pvc.getProfit());

    }
}