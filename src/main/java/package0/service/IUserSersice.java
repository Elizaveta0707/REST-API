package package0.service;

import org.springframework.data.domain.Sort;
import package0.model.User;

import java.util.List;

public interface IUserSersice
{
    User getById(int id);
    void save(User user);
    void delete(int id);
    List<User> getAll();
    List<User> getSortUsers(int page, int size, String[] sort);
    Sort getSortCriteria(String[] sort);
}
