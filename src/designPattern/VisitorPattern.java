package designPattern;

abstract class FileVisitor{

    abstract void visitWord(WordFile w);
    abstract void visitPicture(PictureFile p);
}

abstract class  File{

    abstract void visit(FileVisitor fv);

}

class WordFile extends File{

    @Override void visit(FileVisitor fv){
        fv.visitWord(this);
    }
}

class PictureFile extends File{

   @Override void visit(FileVisitor fv){
        fv.visitPicture(this);
    }

}

class PrintFileVisitor extends FileVisitor{

   @Override void visitWord(WordFile f){
        System.out.println("Open word and print word document ");
    }

    @Override void visitPicture(PictureFile f){
        System.out.println("Open Picture viewer and print the picture");
    }

}


public class VisitorPattern {

    public static void main(String[] args) {

        File[] files = { new PictureFile(), new WordFile() } ;

        FileVisitor v = new PrintFileVisitor();

        for(File f : files){
            f.visit(v);
        }

    }
}
