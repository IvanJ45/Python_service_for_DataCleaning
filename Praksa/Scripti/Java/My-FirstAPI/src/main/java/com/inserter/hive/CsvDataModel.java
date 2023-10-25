package com.inserter.hive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CsvDataModel {
    private String dateTime;
    private long plantId;
    private double dcPower;
    private double acPower;
    private double dailyYield;
    private long totalYield;
    private int timeGap;
    private double ambientTemperature;
    private double moduleTemperature;
    private double irradiation;
    private int hour;
    private int day;
    private int dayOfWeek;
    private int minutes15;
    private String inverter;
}