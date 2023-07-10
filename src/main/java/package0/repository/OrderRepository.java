package package0.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import package0.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>
{
}
