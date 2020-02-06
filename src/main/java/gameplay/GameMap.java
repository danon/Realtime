package gameplay;

import gameplay.scene.Floor;
import gameplay.scene.Ladder;
import lombok.Getter;
import util.save.Savable;
import util.save.SaveInput;
import util.save.SaveOutput;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GameMap implements Savable {
    private final List<Floor> floors = new ArrayList<>();
    private final List<Ladder> ladders = new ArrayList<>();

    private String name;
    private int width;
    private int height;

    public GameMap(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    @Override
    public void restoreState(SaveInput input) throws java.io.IOException {
        this.name = input.readString();
        this.width = input.readInt();
        this.height = input.readInt();

        int floorsCount = input.readInt();
        for (int i = 0; i < floorsCount; i++) {
            floors.add(new Floor(
                    input.readInt(),
                    input.readInt(),
                    input.readInt()));
        }

        int laddersCount = input.readInt();
        for (int i = 0; i < laddersCount; i++) {
            ladders.add(new Ladder(
                    input.readInt(),
                    input.readInt(),
                    input.readInt()));
        }
    }

    @Override
    public void storeState(SaveOutput output) throws java.io.IOException {
        output.writeString(this.getName());
        output.writeInt(this.getWidth());
        output.writeInt(this.getHeight());

        output.writeInt(this.getFloors().size());
        for (Floor floor : this.getFloors()) {
            output.writeInt(floor.getLeft());
            output.writeInt(floor.getTop());
            output.writeInt(floor.getTiles());
        }

        output.writeInt(this.getLadders().size());
        for (Ladder ladder : this.getLadders()) {
            output.writeInt(ladder.getLeft());
            output.writeInt(ladder.getBottom());
            output.writeInt(ladder.getTiles());
        }
    }
}
