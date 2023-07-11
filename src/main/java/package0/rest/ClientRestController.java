package package0.rest;

import package0.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import package0.service.ClientService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/client/")
public class ClientRestController
{
    @Autowired
    private ClientService clientService;
    @RequestMapping(value = "{id_client}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public ResponseEntity<Client> getUser(@PathVariable("id_client") int id)

    {
        if(id == 0)
            {
    return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        Client user=this.clientService.getById(id);
        if(id==0)
        {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user,HttpStatus.OK);


    }
    @RequestMapping(value="",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Client> createUsers(@RequestBody @Valid Client user)
    {
        HttpHeaders headers=new HttpHeaders();
        if(user == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.clientService.save(user);
        return  new ResponseEntity<>(user,headers,HttpStatus.OK);
    }
    @RequestMapping(value="",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  ResponseEntity<Client>updateUsers(@RequestBody @Valid Client user, UriComponentsBuilder builder)

    {
        HttpHeaders heards =new HttpHeaders();
        if(user==null)
        {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.clientService.save(user);
        return new ResponseEntity<>(user,heards,HttpStatus.OK);
    }
    
    @RequestMapping(value = "{id_client}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Client> deleteUsers(@PathVariable("id_client") int id)
    {
        Client user =this.clientService.getById(id);
                if(user==null){
                    return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                this.clientService.delete(id);
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    
    @RequestMapping(value = "",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  ResponseEntity<List<Client>> getAllUsers()
    {
        List<Client> users=this.clientService.getAll();
        if(users.isEmpty())
        {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(users,HttpStatus.OK);

    }

    
    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllSort
    (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id_client") String[] sort)
    {
        List<Client> users = clientService.getSortUsers(page, size, sort);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }



}
