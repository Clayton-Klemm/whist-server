package com.clayton.whistserver.service;

import com.clayton.whistserver.model.Lobby;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LobbyService {
    private final Map<String, Lobby> lobbies = Collections.synchronizedMap(new HashMap<>());

    // Create a new lobby
    public Lobby createLobby(String name) {
        Lobby newLobby = new Lobby(name);
        lobbies.put(name, newLobby);
        return newLobby;
    }

    // Get a lobby by name
    public Lobby getLobby(String name) {
        return lobbies.get(name);
    }

        // List all active lobbies
    public List<Lobby> listLobbies() {
        return lobbies.values().stream().collect(Collectors.toList());
    }

    // Additional methods like deleteLobby, listLobbies, etc.
    // ...
}
