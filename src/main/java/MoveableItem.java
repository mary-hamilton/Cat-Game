public class MoveableItem extends Item {
    MoveableItem(String name, String description) {
        super(name, description);
    }

    @Override
    public void get() {
        System.out.println("Very gently, you pick up the " + this.getName() + " in your teeth.");
        Game.currentRoom.getContents().remove(this.getName());
        Game.inventory.put(this.getName(), this);
    }

    public void drop() {
        System.out.println("You drop the " + this.getName() + ".");
        Game.currentRoom.getContents().put(this.getName(), this);
        Game.inventory.remove(this.getName());
    }
}
