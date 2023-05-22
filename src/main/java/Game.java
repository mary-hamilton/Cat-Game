import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Game {

    public Game() {
    }

    public static Map<String, Room> roomList = new HashMap<>();
    public static Room currentRoom;
    public static Item inventory;
    public static byte pride = 15;

    public static void loadRooms() {
        try {
            BufferedReader roomReader = new BufferedReader(new FileReader("resources/theHouse.txt"));
            Iterator<String> roomIterator = roomReader.lines().iterator();
            while (roomIterator.hasNext()) {
                String name = roomIterator.next();
                byte xdirection = Byte.parseByte(roomIterator.next());
                byte ydirection = Byte.parseByte(roomIterator.next());
                String description = roomIterator.next();
                CellType status = CellType.valueOf(roomIterator.next());
                Map<Direction, String> adjacentRooms = new HashMap<>();
                String nextline = roomIterator.next();
                while (!nextline.equals("---")) {
                    Direction direction = Direction.valueOf(nextline);
                    String adjacentRoomName = roomIterator.next();
                    adjacentRooms.put(direction, adjacentRoomName);
                    nextline = roomIterator.next();
                }
                Room newRoom = new Room(name, description, xdirection, ydirection, status, adjacentRooms);
                roomList.put(name, newRoom);
            }
            currentRoom = roomList.get("Bedroom");
            addThing(roomList.get("Bedroom"), "walnut");
            addThing(roomList.get("Bedroom"), "door");
            addThing(roomList.get("Bedroom"), "bed");
            addThing(roomList.get("Corridor 2"), "cat");
            addThing(roomList.get("Bathroom"), "walnut");
            addThing(roomList.get("Bathroom"), "laundry");
            addThing(roomList.get("Corridor 1"), "food");
            addThing(roomList.get("Office"), "houseplant");
            addThing(roomList.get("Stairs"), "door2");
        } catch (FileNotFoundException e) {
            System.out.println("Could not load level.");
        }
    }

    public static void addThing(Room room, String thingToAdd) {
        Thing newThing;
        switch (thingToAdd) {
            case "walnut":
                newThing = new MoveableItem("walnut", "A small brown walnut is on the floor.");
                break;
            case "food":
                newThing = new EdibleItem("food", "A red bowl on the floor is filled with glistening jellied chunks. They smell terrible but in a way you weirdly find appealling.", "The red bowl is empty.");
                break;
            case "houseplant":
                newThing = new Item("houseplant", "On the floor by the window is a large neglected-looking houseplant.");
                break;
            case "door":
                newThing = new Door("door", "A stripped pine door to the west is closed.", Direction.WEST, "Corridor 1", (byte) 0);
                break;
            case "door2":
                newThing = new Door("door", "At the south end of the stairs is a thick heavy door with stained glass panels. You think you see something move beyond it.", Direction.SOUTH, "Landing", (byte) 2);
                break;
            case "cat":
                newThing = new OtherCat("cat", "There is a huge ginger and white cat standing in front of you.");
                break;
            case "bed":
                newThing = new SleepableItem("bed", "Sunlight streams onto a large, enticing-looking bed.");
                break;
            case "laundry":
                newThing = new SleepableItem("laundry", "In the corner is a large basket of fresh, crisp-looking laundry.");
                break;
            default:
                newThing = null;
        }
        room.getContents().put(newThing.getName(), newThing);

    }

    public static void move(String stringDirection) {
        Direction directionToMove;
        if (stringDirection.equals("w") || stringDirection.equals("west")) {
            directionToMove = Direction.WEST;
        } else if (stringDirection.equals("n") || stringDirection.equals("north")) {
            directionToMove = Direction.NORTH;
        } else if (stringDirection.equals("e") || stringDirection.equals("east")) {
            directionToMove = Direction.EAST;
        } else {
            directionToMove = Direction.SOUTH;
        }

        String nextRoomName = currentRoom.getAdjacentRooms().get(directionToMove);
        if (nextRoomName == null) {
            System.out.println("You can't go that way.");
        } else {
            Room nextRoom = roomList.get(nextRoomName);
            if (!currentRoom.getStatus().equals(CellType.START)) {
                currentRoom.setStatus(CellType.VISITED);
            }
            currentRoom = nextRoom;
            if (!currentRoom.getStatus().equals(CellType.START)) {
                currentRoom.setStatus(CellType.CURRENT_ROOM);
            }
            look();
        }
    }

    public static void look() {
        System.out.println(currentRoom.getDescription());
        currentRoom.getContents().values().forEach(item -> System.out.println(item.getDescription()));
    }

    public static void seeInventory() {
        if (inventory != null) {
            System.out.println("You are carrying:");
            System.out.println("A " + inventory.getName());
        } else {
            System.out.println("You are not carrying anything.");
        }
    }

    public static void refillAll() {
        for(Room room : roomList.values()) {
            for (Thing thing : room.getContents().values()) {
                if (thing.getClass().equals(EdibleItem.class)) {
                    ((EdibleItem) thing).refill();
                }
            }
        }
    }

    public static List<String> getWordList(String input) {
        String delims = " \t,.:;?!\"'";
        List<String> words = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, delims);
        while (tokenizer.hasMoreTokens()) {
            words.add(tokenizer.nextToken());
        }
        return words;
    }

    public static void parseCommand(List<String> words) {
        String verb;
        String noun;
        List<String> directionVerbs = Arrays.stream(Direction.values())
                .map(Direction::toString)
                .collect(Collectors.toList());
        directionVerbs.add("w");
        directionVerbs.add("n");
        directionVerbs.add("e");
        directionVerbs.add("s");
        List<String> verbs = new ArrayList<>(Arrays.asList("look", "see", "eat", "sleep", "meow", "bite", "get", "push", "drop", "play", "scratch", "stare", "hiss"));
        List<String> nouns = new ArrayList<>(Arrays.asList("walnut", "food", "houseplant", "inventory", "door", "cat", "bed", "laundry"));
        if (words.size() > 2) {
            System.out.println("Commands should be 2 words or less");
        } else {
            verb = words.get(0);
            if (directionVerbs.contains(verb)) {
                move(verb);
            } else if (verb.equals("look")) {
                look();
            } else if (!verbs.contains(verb)) {
                System.out.println(verb + " is not a known verb");
            } else {
                if (words.size() == 2) {
                    noun = words.get(1);
                    if (!nouns.contains(noun)) {
                        System.out.println(noun + " is not a known noun");
                    } else {
                        if (verb.equals("see") && noun.equals("inventory")) {
                            seeInventory();
                        } else {
                            Thing thing = currentRoom.getContents().get(noun);
                            if (thing instanceof Item) {
                                switch (verb) {
                                    case "see":
                                        System.out.println(thing.getDescription());
                                        break;
                                    case "eat":
                                        ((Item) thing).eat();
                                        break;
                                    case "bite":
                                        ((Item) thing).bite();
                                        break;
                                    case "sleep":
                                        ((Item) thing).sleep();
                                        break;
                                    case "meow":
                                        if (Game.inventory == null) {
                                            ((Item) thing).meow();
                                        } else {
                                            System.out.println("You cannot meow with your mouth full.");
                                        }
                                        break;
                                    case "get":
                                        ((Item) thing).get();
                                        break;
                                    case "push":
                                        ((Item) thing).push();
                                        break;
                                    case "play":
                                        ((Item) thing).play();
                                    case "scratch":
                                        ((Item) thing).scratch();
                                        break;
                                    case "drop":
                                        System.out.println("You cannot drop something you aren't carrying!");
                                        break;
                                    default:
                                        System.out.println("You can't do that.");
                                }
                            } else if (thing instanceof OtherCat) {
                                switch (verb) {
                                    case "stare":
                                        ((OtherCat) thing).stare();
                                        break;
                                    case "hiss":
                                        ((OtherCat) thing).hiss();
                                        break;
                                    default:
                                        System.out.println("You would never lower yourself to such behaviour.");
                                }
                            } else if (inventory.getName().equals(noun)) {
                                if (verb.equals("drop")) {
                                    ((MoveableItem) inventory).drop();
                                } else {
                                    System.out.println("You can't do that while carefully carrying it in your mouth.");
                                }
                            } else {
                                System.out.println("There is no " + noun + " here.");
                            }
                        }
                    }
                }
            }
        }
    }

    public String runCommand(String input) {
        List<String> wordList;
        String output = "";
        String lowerCaseTrimmed = input.trim().toLowerCase();
        if (lowerCaseTrimmed.isBlank()) {
            output = "...Well?";
        } else {
            wordList = getWordList(lowerCaseTrimmed);
            parseCommand(wordList);
        }
        return output;
    }
}
