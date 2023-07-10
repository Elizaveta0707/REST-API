package package0.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import package0.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import package0.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
@Service
@Slf4j
public class UserService implements IUserSersice
{
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    @Override
    public User getById(int id)
    {
        return userRepository.findById(id).get();
    }

    public  void save (User user)
    {
        userRepository.save(user);
    }
    public  void delete(int id){
        userRepository.deleteById(id);
    }
    @Override
    public List<User> getAll()
    {
        return userRepository.findAll();
    }
    public List<User> getSortUsers(int page, int size, String[] sort) {

        return userRepository.findAll(PageRequest.of(page, size, getSortCriteria(sort))).getContent();
    }

    public Sort getSortCriteria(String[] sort)
    {
        String[] sortProperties = new String[sort.length];
        Sort.Direction[] sortDirections = new Sort.Direction[sort.length];

        for (int i = 0; i < sort.length; i++) {
            String[] parts = sort[i].split(",");
            sortProperties[i] = parts[0];
            sortDirections[i] = parts[1].equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        }

        return Sort.by(Arrays.toString(sortDirections)).and(Sort.by(sortProperties));
    }

}
