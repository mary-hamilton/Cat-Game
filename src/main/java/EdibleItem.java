public class EdibleItem extends Item {

    private boolean eaten;
    private String afterEating;
    EdibleItem(String name, String description, String afterEating) {
        super(name, description);
        this.eaten = false;
        this.afterEating = afterEating;
    }

    @Override
    public void eat() {
        if (!this.eaten) {
            System.out.println("You tuck in. Sometime later, " + this.afterEating.toLowerCase() + ". You are still hungry.");
            this.eaten = true;
            this.setDescription(this.afterEating);
        } else {
            System.out.println(this.afterEating);
        }
    }

    public void bite() {
        this.eat();
    }
}
