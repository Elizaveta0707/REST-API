package package0.rest;

import package0.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import package0.service.OrderService;

import package0.model.Order;
import javax.validation.Valid;
import java.util.List;

@EntityScan
@RequestMapping("/api/v1/orders")
@RestController
public class OrderRestController
{
        @Autowired
        private OrderService orderService;
        @RequestMapping(value = "{ID}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public ResponseEntity<Order> getOrders(@PathVariable("ID") int id)

        {
            if(id == 0)
            {
                return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Order order=this.orderService.getById(id);
            if(id==0)
            {
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(order,HttpStatus.OK);
        }
        @RequestMapping(value="",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public ResponseEntity<Order> createOrders(@RequestBody @Valid Order order)
        {

            HttpHeaders headers=new HttpHeaders();
            if(order == null){
                return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            this.orderService.save(order);
            return  new ResponseEntity<>(order,headers,HttpStatus.OK);
        }
        @RequestMapping(value="",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public  ResponseEntity<Order>updateOrders(@RequestBody @Valid Order order, UriComponentsBuilder builder)

        {
            HttpHeaders heards =new HttpHeaders();
            if(order==null)
            {
                return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            this.orderService.save(order);
            return new ResponseEntity<>(order,heards,HttpStatus.OK);
        }
        //Удаление по ID
        @RequestMapping(value = "{ID}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public ResponseEntity<Client> deleteOrders(@PathVariable("ID") int id)
        {
            Order order =this.orderService.getById(id);
            if(order==null){
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            this.orderService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        
        @RequestMapping(value = "",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public  ResponseEntity<List<Order>> getAllOrders()
        {
            List<Order> orders=this.orderService.getAll();
            if(orders.isEmpty())
            {
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return  new ResponseEntity<>(orders,HttpStatus.OK);

        }
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllSort
            (
                    @RequestParam(defaultValue = "0") int page,
                    @RequestParam(defaultValue = "5") int size,
                    @RequestParam(defaultValue = "ID") String[] sort)
    {
        List<Order> orderList = orderService.getSortUsers(page, size, sort);
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }
}
