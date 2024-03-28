package ar.edu.itba.paw.persistance;

import ar.edu.itba.paw.models.User;

import java.util.Optional;

public interface UserDao {

        Optional<User> findById(long id);

        User create(final String username);
}
