public class OtherCat extends Thing {
    private byte pride;
    OtherCat(String name, String description) {
        super(name, description);
        this.pride = 10;
    }

    public void hiss(){
        System.out.println("You let out your very best sibilant wheeze.");
        this.respond();
    }

    public void stare() {
        System.out.println("Summoning all your energy, you give the cat your most powerful withering glare.");
        this.respond();
    }
    @Override
    public void meow() {
        super.meow();
        this.respond();
    }

    public void respond() {
        if (this.pride > 0) {
            byte random = (byte) Math.floor(Math.random() * 3);
            this.pride -= random + 3;
            switch (random) {
                case 1:
                    Game.pride--;
                    System.out.println("The cat stares at you unblinkingly for several seconds. For some reason this makes you feel angry and ashamed.");
                    break;
                case 2:
                    Game.pride -= 3;
                    System.out.println("The cat lets out a long rasping hiss. You are profoundly offended.");
                    break;
                case 3:
                    System.out.println("Suddenly the cat decides to start languorously grooming its toes. You feel a sense of neutral calm.");
                    break;
                default:
                    Game.pride -= 5;
                    System.out.println("The cat entirely ignores you. You are devastated.");
            }
        } else {
            System.out.println("The other cat slinks away, vanquished by your superior self-worth.");
            Game.currentRoom.getContents().remove(this.getName());
        }
    }
}
