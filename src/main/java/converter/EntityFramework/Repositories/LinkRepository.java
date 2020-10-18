package converter.EntityFramework.Repositories;

import converter.EntityFramework.Models.LinkEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LinkRepository extends JpaRepository<LinkEntity,Integer> {
}
