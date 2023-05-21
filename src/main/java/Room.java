
import java.util.HashMap;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private Map<String, Item> contents;
    private byte xlocation;
    private byte ylocation;
    private CellType status;
    private Map<Direction, String> adjacentRooms;


    public Room(String name, String description, byte xlocation, byte ylocation, CellType status, Map<Direction, String> adjacentRooms) {
        this.name = name;
        this.description = description;
        this.contents = new HashMap<>();
        this.xlocation = xlocation;
        this.ylocation = ylocation;
        this.status = status;
        this.adjacentRooms = adjacentRooms;
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

    public Map<String, Item> getContents() {
        return contents;
    }

    public void setContents(Map<String, Item> contents) {
        this.contents = contents;
    }

    public byte getXlocation() {
        return xlocation;
    }

    public void setXlocation(byte xlocation) {
        this.xlocation = xlocation;
    }

    public byte getYlocation() {
        return ylocation;
    }

    public void setYlocation(byte ylocation) {
        this.ylocation = ylocation;
    }

    public CellType getStatus() {
        return status;
    }

    public void setStatus(CellType status) {
        this.status = status;
    }

    public Map<Direction, String> getAdjacentRooms() {
        return adjacentRooms;
    }

    public void setAdjacentRooms(Map<Direction, String> adjacentRooms) {
        this.adjacentRooms = adjacentRooms;
    }
}
