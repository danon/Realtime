package gameplay;

final public class PlayerCharacter extends Character {
    private int userId;
    public String username;
    private int teamId;

    public PlayerCharacter() {
    }

    public PlayerCharacter(int userId, String username, int teamId, int characterId) {
        super(characterId);
        this.userId = userId;
        this.username = username;
        this.teamId = teamId;
    }

    public PlayerCharacter(PlayerCharacter base) {
        this.userId = base.userId;
        this.username = base.username;
        this.teamId = base.teamId;
        this.characterId = base.characterId;

        this.shared = base.shared.copy();
        this.common = base.common.copy();
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String getDisplayName() {
        return this.username;
    }


    @Override
    public String toString() {
        return String.format("player #%d %s (charId: %d, teamId: %d)", userId, username, characterId, teamId);
    }
}
