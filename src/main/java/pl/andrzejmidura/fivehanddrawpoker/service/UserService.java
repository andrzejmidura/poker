package pl.andrzejmidura.fivehanddrawpoker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.andrzejmidura.fivehanddrawpoker.entity.User;
import pl.andrzejmidura.fivehanddrawpoker.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with username '" + username + "'"));
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
}
