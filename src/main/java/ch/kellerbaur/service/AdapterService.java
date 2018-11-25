package ch.kellerbaur.service;

import java.util.Optional;

import ch.kellerbaur.model.AdapterUser;
import ch.kellerbaur.model.User;

public interface AdapterService {

    Optional<AdapterUser> getUser(String adapterId, String methodName, User user);

}
