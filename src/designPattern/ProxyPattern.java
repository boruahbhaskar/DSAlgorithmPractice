package designPattern;

abstract class Greeter{

    abstract String greet();
}

class RealGreeter extends Greeter{

    String greet(){
        return "Hi there!!";
    }
}

class GreeterProxy extends Greeter{

    Greeter greeter;

    String greet(){

        //check if the user is authorised
        // call the greet method
        if( greeter == null)
            greeter = new RealGreeter();

        return greeter.greet();
    }

}

public class ProxyPattern {

    public static void main(String[] args) {

        Greeter greeter = new GreeterProxy();

        System.out.println(greeter.greet());

        System.out.println(greeter.greet());

    }
}
