package ex7;

public class ObserveableBagAdapter implements Bag {

    private ObservableBag observableBag;

    public ObserveableBagAdapter(ObservableBag observableBag) {
        this.observableBag = observableBag;
    }

    @Override
    public void add(String s) {
        observableBag.add(s);
    }

    @Override
    public void remove(String s) {
        observableBag.remove(s);
    }

    @Override
    public int getCount(String s) {
        return observableBag.getMap().get(s);
    }

    public void addObserver(Observer observer) {
        observableBag.addObserver(observer);
    }

}
