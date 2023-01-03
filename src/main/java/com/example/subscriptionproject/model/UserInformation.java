package com.example.subscriptionproject.model;

import javax.persistence.*;

@Entity
@Table(name = "UserInformation")

public class UserInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "HitsCount")
    private int hitsCount;

    @OneToOne
    SubscriptionPlan subscriptionPlan;

    public UserInformation() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getHitsCount() {
        return hitsCount;
    }

    public void setHitsCount(int hitsCount) {
        this.hitsCount = hitsCount;
    }

    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", hitsCount=" + hitsCount +
                ", subscriptionPlan=" + subscriptionPlan +
                '}';
    }
}
