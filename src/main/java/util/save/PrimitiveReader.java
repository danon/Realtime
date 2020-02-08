package util.save;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public final class PrimitiveReader implements Saveable, SaveableFactory<Primitive> {
    private int value;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void storeState(SaveOutput output) throws IOException {
        output.writeInt(value);
    }

    @NotNull
    @Override
    public Primitive load(@NotNull SaveInput input) throws IOException {
        return new Primitive(value = input.readInt());
    }
}
