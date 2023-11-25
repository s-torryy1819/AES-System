package lr9_2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lr9_2.DTO.Position;

@EnableJpaRepositories
public interface PositionRepo extends JpaRepository<Position, Integer> {

}