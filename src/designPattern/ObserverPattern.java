package designPattern;

import java.util.ArrayList;
import java.util.List;

class MobilePhone{

    double lon, lat ;

    List<Observer> os = new ArrayList<>();

    void move(){

        lon += 3.0 ;
        lat += 5.0 ;

        notifyLocationChanged();
    }

    void register(Observer o){

     os.add(o);

    }

    private void notifyLocationChanged(){

        os.forEach(o -> o.update(lon,lat));
    }

}

abstract class Observer{

    abstract void update(double lon, double lat);

}

class MobileApp extends Observer{


    @Override
    void update(double lon, double lat) {
        System.out.println(lon + " - " + lat);
    }
}


public class ObserverPattern {

    public static void main(String[] args) {

        MobilePhone phone = new MobilePhone();

        phone.register(new MobileApp());

        phone.move();
        phone.move();
        phone.move();

    }
}
