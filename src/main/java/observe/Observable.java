package observe;

import java.util.ArrayList;

public abstract class Observable<T> {
    private final ArrayList<T> observers;

    protected Observable() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(T observer) {
        observers.add(observer);
    }

    protected void notifyObservers(Notifier<T> n) {
        for (T observer : observers) {
            n.notifyObject(observer);
        }
    }
}
