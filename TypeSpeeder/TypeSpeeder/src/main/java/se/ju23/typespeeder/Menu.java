package se.ju23.typespeeder;

import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuService{

    private String language = "svenska";
    @Override
    public void displayMenu(){
        getMenuOptions();
        if (language.equalsIgnoreCase("svenska")){
            System.out.println("Svenska valt.");

        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String option : getMenuOptions()){
            stringBuilder.append(option);
        }
        System.out.println(stringBuilder.toString());


    }

    public List<String> getMenuOptions() {
        List<String> menuOptions = new ArrayList<>();
        menuOptions.add("Välj språk (svenska/engelska):\n");
        menuOptions.add("1. alternativ\n");
        menuOptions.add("1. alternativ\n");
        menuOptions.add("1. alternativ\n");
        menuOptions.add("1. alternativ");

        return menuOptions;

    }

    public void setLanguage(){
        System.out.println("Svenska valt.");
    }

}
