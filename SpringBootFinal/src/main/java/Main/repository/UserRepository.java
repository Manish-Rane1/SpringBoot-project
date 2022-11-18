package Main.repository;

import org.springframework.data.repository.CrudRepository;

import Main.model.User;

public interface UserRepository extends CrudRepository<User, String> {

}
