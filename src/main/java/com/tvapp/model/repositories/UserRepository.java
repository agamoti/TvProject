package com.tvapp.model.repositories;

import com.tvapp.model.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nimrod_t on 5/15/2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
