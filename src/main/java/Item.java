import java.util.Map;

public class Item {
    private String name;
    private String description;

    Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void eat() {
        System.out.print("You sniff hesitantly and nibble a corner. ");
        this.bite();
    }

    public void bite() {
        System.out.println("The " + this.name + " tastes awful. You are filled with regret.");
    }

    public void sleep() {
        System.out.println("The " + this.name + " does not meet your exacting requirements for a sleeping spot.");
    }

    public void meow() {
        if (Game.inventory == null) {
            String meowType;
            int randomiser = (int) Math.floor(Math.random() * 4);
            switch (randomiser) {
                case 1:
                    meowType = "high-pitched squeak";
                    break;
                case 2:
                    meowType = "strangled growl";
                    break;
                case 3:
                    meowType = "deeply-irritating whine";
                    break;
                default:
                    meowType = "breathy hiss";
            }
            System.out.println("You let out a " + meowType + ". The " + this.name + " looks back at you, unmoved.");
        } else {
            System.out.println("You cannot meow with your mouth full.");
        }
    }

    public void get() {
        System.out.println("You cannot pick up the " + this.name + ", you are a small cat.");
    }

    public void push() {
        System.out.println("You push the " + this.name + ". It seems largely pointless.");
    }

    public void play() {
        System.out.println("You consider playing with the " + this.name + " for a time but decide it would be beneath your dignity.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
