package package0.repository;

import org.springframework.stereotype.Repository;
import package0.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>
{

}
