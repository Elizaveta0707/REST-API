package package0.rest;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import package0.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import package0.repository.UserRepository;
import package0.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user/")
public class UserRestController
{
    @Autowired
    private UserService userService;
    @RequestMapping(value = "{id_users}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public ResponseEntity<User> getUser(@PathVariable("id_users") int id)

    {
        if(id == 0)
            {
    return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        User user=this.userService.getById(id);
        if(id==0)
        {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user,HttpStatus.OK);


    }
    @RequestMapping(value="",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createUsers(@RequestBody @Valid User user)
    {
        HttpHeaders headers=new HttpHeaders();
        if(user == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.userService.save(user);
        return  new ResponseEntity<>(user,headers,HttpStatus.OK);
    }
    @RequestMapping(value="",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  ResponseEntity<User>updateUsers(@RequestBody @Valid User user, UriComponentsBuilder builder)

    {
        HttpHeaders heards =new HttpHeaders();
        if(user==null)
        {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.userService.save(user);
        return new ResponseEntity<>(user,heards,HttpStatus.OK);
    }
    //Удаление по ID
    @RequestMapping(value = "{id_users}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> deleteUsers(@PathVariable("id_users") int id)
    {
        User user =this.userService.getById(id);
                if(user==null){
                    return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                this.userService.delete(id);
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    //получение всех клиентов
    @RequestMapping(value = "",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users=this.userService.getAll();
        if(users.isEmpty())
        {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(users,HttpStatus.OK);

    }

    //запрос  с возможностью пагинтации  и с возможностью сортировки
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllSort
    (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id_users") String[] sort)
    {
        List<User> users = userService.getSortUsers(page, size, sort);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }



}
