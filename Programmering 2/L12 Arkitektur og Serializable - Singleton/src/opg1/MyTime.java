package opg1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyTime implements Serializable {

    private int time = 0;

    private List<String> times = new ArrayList<>();

    public void increase() {
        time++;
    }

    public void reset() {
        time = 0;
    }

    public int getTime() {
        return time;
    }

    public void saveTime() {
        times.add(String.valueOf(time));
    }

    public List<String> getTimes() {
        return times;
    }
}
