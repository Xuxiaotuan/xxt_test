package cn.xuyinyin.magic.service;

import cn.xuyinyin.magic.entity.User;
import cn.xuyinyin.magic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * User service class
 *
 * @author xjw
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    
    public List<User> getAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
    
    public Optional<User> getUserById(Long id) {
        log.info("Fetching user with id: {}", id);
        return userRepository.findById(id);
    }
    
    public User saveUser(User user) {
        log.info("Saving user: {}", user.getName());
        return userRepository.save(user);
    }
    
    public Optional<User> getUserByEmail(String email) {
        log.info("Fetching user with email: {}", email);
        return userRepository.findByEmail(email);
    }
}