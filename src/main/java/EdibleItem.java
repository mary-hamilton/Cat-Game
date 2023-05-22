public class EdibleItem extends Item {

    private boolean eaten;

    private String originalDescription;
    private String afterEating;
    EdibleItem(String name, String description, String afterEating) {
        super(name, description);
        this.originalDescription = description;
        this.eaten = false;
        this.afterEating = afterEating;
    }

    @Override
    public void eat() {
        if (!this.eaten) {
            System.out.println("You tuck in. Some time later, " + this.afterEating.toLowerCase() + " You are still hungry.");
            this.eaten = true;
            this.setDescription(this.afterEating);
        } else {
            System.out.println(this.afterEating);
        }
    }

    public void refill() {
        this.eaten = false;
        this.setDescription(originalDescription);
    }

    public void bite() {
        this.eat();
    }
}
