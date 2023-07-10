package package0.model;


import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")

public class Product implements Serializable
{
    @Id
    @Column(name = "id_product", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id_product;
    @Column(name = "name", nullable = false)
    private  String name;
    @Column(name = "price", nullable = false)
    private  int price;
       @ManyToMany(mappedBy = "productList")
       private List<Order> orderList;
    public Product()
    {}
    public Product(String name, int price)
    {

        this.name=name;
        this.price=price;

    }
    public  void setId_product(int id_product)
    {
        this.id_product = id_product;
    }
    public  int getId_product()
    {return id_product;
    }

    public  void setName(String name)
    {
        this.name=name;
    }
    public  String getName(){return  name;}
    public  void setPrice(int price)
    {
        this.price=price;
    }
    public  int getPrice(){return  price;}
    @Override
    public String  toString()
    {
        return "Product{"
                +"id="+id_product+
                ",name"+name+",price"+
                price+'}';
    }
}