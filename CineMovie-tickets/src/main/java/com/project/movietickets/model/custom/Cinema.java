package com.project.movietickets.model.custom;

import java.util.List;

public class Cinema {
    private final String name;
    private final List<Schedule> schedules;

    public Cinema(String name, List<Schedule> schedules) {
        this.name = name;
        this.schedules = schedules;
    }

    public String getName() {
        return name;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", schedules=" + schedules +
                '}';
    }
}
