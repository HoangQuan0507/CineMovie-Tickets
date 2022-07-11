package com.project.movietickets.model.custom;

public class Schedule {
    private final int id;
    private final String time;

    public Schedule(int id, String time) {
        this.id = id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", time='" + time + '\'' +
                '}';
    }
}
