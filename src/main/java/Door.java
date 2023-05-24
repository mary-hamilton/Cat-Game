public class Door extends Item {
    private  Item key;
    private boolean open;
    private Direction direction;
    private String otherSide;
    private byte attempts;
    private byte attemptsNeeded;

    Door(String name, String description, Direction direction, String otherSide, byte attemptsNeeded) {
        super(name, description);
        this.direction = direction;
        this.otherSide = otherSide;
        this.open = false;
        this.attempts = 0;
        this.attemptsNeeded = attemptsNeeded;
        this.key = null;
    }

    public void push(){
        if(!this.open) {
            System.out.println("The door is firmly closed.");
        } else {
            System.out.println(this.getDescription());
        }
    }
    public void meow() {
        if (this.attempts < this.attemptsNeeded) {
            super.meow();
            this.attempts++;
        } else if (!this.open) {
            this.setOpen(true);
            System.out.println("You hear the sounds of annoyed fumbling. The " + this.direction.toString().toLowerCase() + "-facing door swings open and you catch a glimpse of retreating human feet.");
            this.setDescription("The " + this.direction.toString().toLowerCase() + "-facing door is open.");
            Game.currentRoom.getAdjacentRooms().put(this.direction, this.otherSide);
        } else {
            super.meow();
        }
    }



    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getOtherSide() {
        return otherSide;
    }

    public void setOtherSide(String otherSide) {
        this.otherSide = otherSide;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
