public class Thing {

    private String name;
    private String description;

    public Thing(String name, String description) {
        this.name = name;
        this.description = description;
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
        System.out.println("You let out a " + meowType + ".");
        if (!this.getClass().equals(OtherCat.class)) {
            System.out.println("The " + this.getName() + " looks back at you, unmoved.");
        }

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
