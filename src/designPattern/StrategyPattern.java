package designPattern;


class Files{

    CompressionStrategy strategy;

    void compress(){
        strategy.compress();
    }

}

abstract class CompressionStrategy {

    abstract void compress();

}

class ZipCompression extends CompressionStrategy{


    @Override
    void compress() {
        System.out.println("Compression with ZIP");
    }
}

class RarCompression extends CompressionStrategy{

    @Override
    void compress() {
        System.out.println("Compression with RAR");
    }
}


public class StrategyPattern {

    public static void main(String[] args) {

        Files f = new Files();
        f.strategy= new RarCompression();
        f.compress();

    }

}
