package com.example.subscriptionproject.repository;

import com.example.subscriptionproject.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInformationRepository extends JpaRepository<UserInformation, Integer> {
    UserInformation findAllById(int i);
    UserInformation findByUserName(String userName);
}
