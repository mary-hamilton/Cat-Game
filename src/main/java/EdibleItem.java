public class EdibleItem extends Item {

    boolean eaten;
    String afterEating;
    EdibleItem(String name, String description, String afterEating) {
        super(name, description);
        this.eaten = false;
        this.afterEating = afterEating;
    }

    @Override
    public void eat() {
        if (!this.eaten) {
            System.out.println("You tuck in. Sometime later, " + this.afterEating.toLowerCase());
            this.eaten = true;
            this.setDescription(this.afterEating);
        } else {
            System.out.println(this.afterEating);
        }
    }

    public void bite() {
        if (!this.eaten) {
            System.out.println("You tuck in. Sometime later, " + this.afterEating.toLowerCase());
            this.eaten = true;
            this.setDescription(this.afterEating);
        } else {
            System.out.println(this.afterEating);
        }
    }
}
