import java.util.Map;

public class Item extends Thing {

    public Item(String name, String description) {
        super(name, description);
    }

    public void eat() {
        System.out.print("You sniff hesitantly and nibble a corner. ");
        this.bite();
    }

    public void bite() {
        System.out.println("The " + this.getName() + " tastes awful. You are filled with regret.");
    }

    public void sleep() {
        System.out.println("The " + this.getName() + " does not meet your exacting requirements for a sleeping spot.");
    }

    public void meow() {
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
                meowType = "breathy trill";
        }
        System.out.println("You let out a " + meowType + ". The " + this.getName() + " looks back at you, unmoved.");

    }

    public void get() {
        System.out.println("You cannot pick up the " + this.getName() + ", you are a small cat.");
    }

    public void push() {
        System.out.println("You push the " + this.getName() + ". It seems largely pointless.");
    }

    public void play() {
        System.out.println("You consider playing with the " + this.getName() + " for a time but decide it would be beneath your dignity.");
    }

    public void scratch() {
        System.out.println("You vigorously tear at " + this.getName() + " for several minutes until your desire is sated. It looks somewhat shabbier but is basically intact.");
    }

    public void hiss() {

    }

}
