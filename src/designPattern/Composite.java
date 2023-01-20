package designPattern;

import java.util.ArrayList;
import java.util.List;

abstract class MenuComponent{

    String text;

    MenuComponent(String text){
        this.text = text;
    }

}

class MenuItem extends MenuComponent{
    MenuItem(String text){
        super(text);
    }
}

class Menu extends MenuComponent{

    List<MenuComponent> components = new ArrayList<>();

    Menu(String text){
        super(text);
    }

}

public class Composite {

    public static void main(String[] args) {

        Menu file = new Menu("File");

        file.components.add(new MenuItem("Open"));
        file.components.add(new MenuItem("Save"));
        file.components.add(new MenuItem("Exit"));

        Menu recentFiles = new Menu("Recent");
        file.components.add(recentFiles);

        Menu edit = new Menu("Edit");


    }

}

