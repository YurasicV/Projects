package app.service;

import app.entity.User;
import app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public List<User> findAllByOrderByFullNameAsc() {
        return userRepository.findAllByOrderByFullNameAsc();
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
