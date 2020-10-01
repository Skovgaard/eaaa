package ex7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ObservableBag implements Iterable<String> {

    private List<Observer> observerList = new ArrayList<>();

    private HashMap<String, Integer> map = new HashMap<>();

    public void add(String s) {
        if (map.containsKey(s))
            map.put(s, map.get(s) + 1);
        else
            map.put(s, 1);
        notifyObservers(s, map.get(s));
    }

    public void remove(String s) {
        if (map.containsKey(s)) {
            if (map.get(s) > 1) {
                map.put(s, map.get(s) - 1);
                notifyObservers(s, map.get(s));
            } else {
                map.remove(s);
                notifyObservers(s, 0);
            }
        }
    }

    public HashMap<String, Integer> getMap() {
        return map;
    }

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    public void notifyObservers(String s, int amount) {
        for (Observer observer : observerList) {
            observer.update(s, amount);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return map.keySet().iterator();
    }
}
