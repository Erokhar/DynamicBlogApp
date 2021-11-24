package com.dynamicapp.dynamicblogapp.repositories;

import com.dynamicapp.dynamicblogapp.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UserModel,Long> {
    @Override
    List<UserModel> findAll();

    List<UserModel> findByUserid(int userid);

    List<UserModel> findByUsername(String username);

    List<UserModel> findByUseremail(String useremail);

}
