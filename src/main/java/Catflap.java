public class Catflap extends Door {

    private String key;

    Catflap(String name, String description, Direction direction, String otherSide, byte attemptsNeeded, String key) {
        super(name, description, direction, otherSide, attemptsNeeded);
        this.key = key;
    }

    public void push() {
        if (Game.inventory != null) {
            if (Game.inventory.getName().equals(this.key)) {
                this.setOpen(true);
                Game.currentRoom.getAdjacentRooms().put(this.getDirection(), this.getOtherSide());
                System.out.println("You hear a click from the catflap. A gust of breeze catches it and it starts to swing gently.");
                System.out.println("You squeeze through.");
                Game.move(this.getDirection().toString());
            }
        } else {
            System.out.println("The catflap is firmly closed.");
        }
    }

    public void meow() {
        super.meow();
    }
}

