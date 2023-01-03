package com.example.subscriptionproject.repository;

import com.example.subscriptionproject.model.SubscriptionPlan;
import com.example.subscriptionproject.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Integer> {
    SubscriptionPlan findBySubscriptionPlan(String subscriptionPlan);
}
