public class SleepableItem extends Item {
    public SleepableItem(String name, String description) {
        super(name, description);
    }
    public void sleep(){
        int random = (int)Math.floor(Math.random() * 5 + 1);
        Game.refillAll();
        System.out.println("You curl up on the " + this.getName() + " and sleep intensely for " + random + " hours. You awake feeling invigorated and several ounces lighter due to the sheer amount of fur you have deposited.");
    }
}
