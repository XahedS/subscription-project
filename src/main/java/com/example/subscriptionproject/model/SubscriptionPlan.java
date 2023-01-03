package com.example.subscriptionproject.model;

import javax.persistence.*;

@Entity
@Table(name = "SubscriptionPlan")
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "SubscriptionPlan")
    private String subscriptionPlan;
    @Column(name = "MaxHitsAllowed")
    private int maxHitsAllowed;

    public SubscriptionPlan() {
    }

    public int getId() {
        return id;
    }

    public String getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public int getMaxHitsAllowed() {
        return maxHitsAllowed;
    }

    @Override
    public String toString() {
        return "SubscriptionPlan{" +
                "id=" + id +
                ", subscriptionPlan='" + subscriptionPlan + '\'' +
                ", maxHitsAllowed=" + maxHitsAllowed +
                '}';
    }
}
