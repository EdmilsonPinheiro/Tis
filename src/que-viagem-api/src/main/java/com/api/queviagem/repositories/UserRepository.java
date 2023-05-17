package com.api.queviagem.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.queviagem.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, LocalDate> {

    @Query(value = "SELECT * FROM users WHERE email_user = :email AND password_user = :password", nativeQuery = true)
    Optional<UserModel> getUser(String email, String password);
}
