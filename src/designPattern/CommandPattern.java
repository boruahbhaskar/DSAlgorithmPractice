package designPattern;

class Document{
    String text="";
}

abstract class DocumentCommand{
    Document document;

    public DocumentCommand(Document document) {
        this.document = document;
    }

    abstract void execute();

    abstract DocumentCommand createUndo();
}


 class AddCharCommand extends DocumentCommand{

    char c;

    public AddCharCommand(Document document,char c) {
        super(document);
        this.c  = c;
    }

    @Override
    void execute() {

        document.text += c;

    }

     @Override
     DocumentCommand createUndo() {
         return new DeleteCharCommand(document);
     }


 }

class DeleteCharCommand extends DocumentCommand{

    public DeleteCharCommand(Document document) {

        super(document);
    }

    @Override
    void execute() {
        document.text = document.text.substring(0, document.text.length() -1);
    }

    @Override
    DocumentCommand createUndo() {
        return null;
    }


}

public class CommandPattern {

    public static void main(String[] args) {

        Document d = new Document();

        DocumentCommand[] cs = {new AddCharCommand(d,'H'),new AddCharCommand(d,'I')};

        for(DocumentCommand c : cs){

            c.execute();
        }

        System.out.println(">> "+d.text);

        for(DocumentCommand c : cs){

            c.createUndo().execute();
        }

        System.out.println(">> "+d.text);
    }
}
