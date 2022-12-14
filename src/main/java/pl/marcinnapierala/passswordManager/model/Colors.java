package pl.marcinnapierala.passswordManager.model;

public class Colors {
    public static final String MAIN_RED = "#7c0a02";
    public static final String LIGHT_RED = "#ff0800";
    public static final String MAIN_BLUE = "#4b56d2";
    public static final String LIGHT_BLUE = "#82c3ec";
    public static final String MAIN_GREY = "#334257";
    public static final String LIGHT_Grey = "#d8e3e7";

    public static String setBackgroundColor(String color){
        return "fx-background-color: " + color + "; ";
    }
    public static String setTextColor (String color) {
        return "";
    }
}
