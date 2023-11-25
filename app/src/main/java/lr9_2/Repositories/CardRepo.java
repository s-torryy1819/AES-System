package lr9_2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lr9_2.DTO.Card;

@EnableJpaRepositories
public interface CardRepo extends JpaRepository<Card, Integer> {

}