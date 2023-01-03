package com.example.subscriptionproject.service;

public class hitValidatorReturn {
    private boolean hitStatus;
    private String subscriptionPlan;
    public hitValidatorReturn(boolean hitStatus, String subscriptionPlan) {
        this.hitStatus = hitStatus;
        this.subscriptionPlan = subscriptionPlan;
    }

    public boolean isHitStatus() {
        return hitStatus;
    }

    public void setHitStatus(boolean hitStatus) {
        this.hitStatus = hitStatus;
    }

    public String getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(String subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }
}
