package package0.model;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")

public class User implements  Serializable
{
 @Id
 @Column(name = "id_users")
 //@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id_users;
 @Column(name = "fio")
 private String fio;
 @Column(name = "number")
 private long number;
 @Column(name = "adress")
 private String adress;


 @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
 private List<Order> orders = new ArrayList<>();
 public  User(int id_users,String fio,long number,String adress)
 {
  this.id_users=id_users;
  this.fio=fio;
  this.number=number;
  this.adress=adress;
 }

 public  User(){}
 public  void setId_users(int id_users)
 {
  this.id_users = id_users;
 }
 public  int getId_users(){return id_users;}
 public  void setFio(String fio)
 {
  this.fio=fio;
 }
 public  String getFio(){return  fio;}
 public  void setNumber(long number)
 {
  this.number=number;
 }
 public  Long getNumber(){return  number;}
 public  void setAdress(String adress)
 {
  this.adress=adress;
 }
 public  String getAdress(){return  adress;}
 public void addComment(Order orders){
  this.orders.add(orders);
 }
 @Override
 public String  toString()
 {
  return "User{"
          +"id="+id_users+
          ",fio"+fio+",number"+
          number+",adress"+
          adress+'}';
 }
}