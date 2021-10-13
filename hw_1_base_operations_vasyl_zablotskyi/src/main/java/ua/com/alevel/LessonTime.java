package ua.com.alevel;

public class LessonTime {
    private final int hour;
    private final int minutes;

    public LessonTime(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }
}
