package designPattern;

class CompressionStratege{


}

class StrategyCreator{

    CompressionStratege factoryMethod(){

        return new CompressionStratege();
    }

}

class ZipCompressionStrategy extends CompressionStratege{}

class RarCompressionStrategy extends CompressionStratege{}

abstract class CompressionStrategyFactory{

   abstract CompressionStratege create();

}

class ZipCompressionStrategyFactory extends CompressionStrategyFactory{


    @Override
    CompressionStratege create() {
        return new ZipCompressionStrategy();
    }
}


class RarCompressionStrategyFactory extends CompressionStrategyFactory{


    @Override
    CompressionStratege create() {
        return new RarCompressionStrategy();
    }
}

public class FactoryPattern {

    public static void main(String[] args) {

        CompressionStrategyFactory factory = new ZipCompressionStrategyFactory();
        System.out.println(factory.create());

    }
}
