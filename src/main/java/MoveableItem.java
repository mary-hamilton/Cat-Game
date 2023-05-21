public class MoveableItem extends Item {
    MoveableItem(String name, String description) {
        super(name, description);
    }

    @Override
    public void get() {
        if (Game.inventory == null) {
            System.out.println("Very gently, you pick up the " + this.getName() + " in your teeth.");
            Game.currentRoom.getContents().remove(this.getName());
            Game.inventory = this;
        } else {
            System.out.println("You cannot carry two things at once, you are a small cat.");
        }
    }

    public void drop() {
        System.out.println("You drop the " + this.getName() + ".");
        Game.currentRoom.getContents().put(this.getName(), this);
        Game.inventory = null;
    }

    public void play() {
        if (Game.inventory == this) {
            this.drop();
        }
        System.out.println("You bat the " + this.getName() + " excitedly back and forth across the floor for several minutes, before becoming suddenly and inexplicably bored.");
    }
}
