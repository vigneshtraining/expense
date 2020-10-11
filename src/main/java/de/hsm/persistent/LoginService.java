package de.hsm.persistent;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    private static List<User> users = new ArrayList<>();
    private static List<Participant> participants = new ArrayList<>();

    public void register(User usr) {
        users.add(usr);
    }


    public Participant addParticipant(Participant participant) {
        participants.add(participant);
        return null;
    }
}
