package beavers;

public class Clock {
    private int time; // time is represented in minutes (0-1439)

    public Clock() {
        this.time = 0; // Starting at 12:00 AM
    }

    // Method to move time forward by a certain number of minutes (in 5-minute increments)
    public int moveTime(int minutes) {
        time = (time + minutes) % 1440; // Ensures time wraps around after 1439 minutes (23:59)
        return time;
    }

    // Method to get the current time in minutes
    public int getTime() {
        return time;
    }

    // Method to get a formatted time string
    public String getFormattedTime() {
        int hours = (time / 60) % 12;
        if (hours == 0) hours = 12;
        int minutes = time % 60;
        String period = time < 720 ? "AM" : "PM";
        return String.format("%d:%02d %s", hours, minutes, period);
    }

    // Method to get the current hour
    public int getCurrentHour() {
        return time / 60;
    }
}
