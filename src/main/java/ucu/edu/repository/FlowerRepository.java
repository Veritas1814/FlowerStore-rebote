package ucu.edu.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucu.edu.model.Flower;

@Repository
public interface FlowerRepository extends JpaRepository <Flower, Integer> {
    
}
