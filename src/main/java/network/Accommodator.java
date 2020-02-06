package network;

import gameplay.CountedCharacters;
import gameplay.PlayerCharacter;

import java.util.Set;

public class Accommodator {
    // Lobby
    public UserAccount user;
    public LobbyEntry lobbyEntry;

    // In-Game
    private PlayerCharacter character;

    public Accommodator() {
        lobbyEntry = new LobbyEntry();
    }

    public void setUser(UserAccount user) {
        this.user = user;
        this.lobbyEntry = new LobbyEntry(user.getId(), user.getUsername(), false, LobbyEntry.ROOMLESS);
    }

    public void setPlayerCharacter(PlayerCharacter character) {
        this.character = character;
    }

    public PlayerCharacter getPlayerCharacter() {
        return this.character;
    }

    public static CountedCharacters countedCharacters(Set<Accommodator> populatedRoom) {
        CountedCharacters counted = new CountedCharacters();

        for (Accommodator accommodator : populatedRoom) {
            if (accommodator.lobbyEntry.isReadyForGame()) {
                counted.ready++;
            }
            if (accommodator.lobbyEntry.getChosenTeamId() > 0) {
                counted.inTeams++;
            }
        }
        counted.all = populatedRoom.size();
        counted.inSpectate = counted.all - counted.inTeams;

        return counted;
    }
}