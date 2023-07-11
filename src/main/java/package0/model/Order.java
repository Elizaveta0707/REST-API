package package0.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Table(name = "orders")
@Entity
public class Order implements Serializable
{
    @Id
    @Column(name = "ID",nullable = false,insertable = false, updatable = false)
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_order;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "price", nullable = false)
    private int price;

    public Order( Date date,int price)
    {
        this.date=date;
        this.price=price;
    }
    public Order(){}
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    @ManyToMany
    @JoinTable
            (
                    name = "order_product",
                    joinColumns = @JoinColumn(name = "id",referencedColumnName = "ID"),
                    inverseJoinColumns = @JoinColumn(name = "id_pro",referencedColumnName = "ID")
            )
    private List<Product> productList;

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_order() {
        return id_order;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    //добавление товара в заказ
    public void addProduct(Product product){
        this.productList.add(product);
       // product.getName();
    }
    //удаление товара из заказа
    public void removeProduct(Product product){
        this.productList.remove(product);
     //  product.getName();
    }
    @Override
    public String  toString()
    {
        return "Order{"
                +"id="+id_order+
                ",date"+date+",price"+
                price+'}';
    }

}