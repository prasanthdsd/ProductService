package com.project.productservice.inheritancerelations.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("st_userrepository")
public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    <S extends User> S save(S entity);
}
