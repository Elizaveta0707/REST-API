package package0.service;

import org.springframework.data.domain.Sort;
import package0.model.Client;

import java.util.List;

public interface IClientService
{
    Client getById(int id);
    void save(Client user);
    void delete(int id);
    List<Client> getAll();
    List<Client> getSortUsers(int page, int size, String[] sort);
    Sort getSortCriteria(String[] sort);
}
