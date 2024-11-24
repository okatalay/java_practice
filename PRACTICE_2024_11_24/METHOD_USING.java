package PRACTICE_2024_11_24;

public class METHOD_USING {

    public static void main(String[] args) {

        String engine = productEngine("pr1", "pr2");
        String bonned = productBonned("pr3", "pr4");

        String car = engine + bonned;
        System.out.println("Car >> " + car);

    }

    public static String productEngine(String pr1, String pr2) {
        String engine = pr1 + pr2;
        System.out.println("Generated Engine: " + engine);
        return engine;
    }

    public static String productBonned(String pr3, String pr4) {
        String bonned = pr3 + pr4;
        System.out.println("Generated Bonned: " + bonned);
        return bonned;
    }
}