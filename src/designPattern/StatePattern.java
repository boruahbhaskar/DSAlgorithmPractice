package designPattern;

class Phone{
    RingState s = new SoundState();

    void ring(){
        s.ring();
    }

    void volumeUp(){
        s = s.nextStateVolumeUp();

    }

    void volumeDown(){
        s = s.nextStateVolumeDown();
    }
}

abstract class RingState{

    abstract void ring();

    abstract RingState nextStateVolumeUp();


    abstract RingState nextStateVolumeDown();

}

class SoundState extends RingState{

    void ring(){
        System.out.println("Phone is ringing ");
    }

    RingState nextStateVolumeUp(){
        return this;
    };

    RingState nextStateVolumeDown(){
        return new VibrateState();
    }

}

class VibrateState extends RingState{

    void ring(){
        System.out.println("Phone is vibrating ");
    }

    RingState nextStateVolumeUp(){
        return new SoundState();
    };

    RingState nextStateVolumeDown(){
        return new SilentState();
    }

}


class SilentState extends RingState{

    void ring(){
        System.out.println("Phone is silent .. ");
    }

    RingState nextStateVolumeUp(){
        return new VibrateState();
    };

    RingState nextStateVolumeDown(){
        return this;
    }

}

public class StatePattern {

    public static void main(String[] args) {

        Phone p = new Phone();

        p.ring();
        p.volumeDown();
        p.ring();
        p.volumeDown();
        p.ring();
        p.volumeDown();
        p.ring();
        p.volumeUp();
        p.ring();
        p.volumeUp();
        p.ring();
        p.volumeUp();


    }
}
