package com.example.subscriptionproject.service;

import com.example.subscriptionproject.model.SubscriptionPlan;
import com.example.subscriptionproject.model.UserInformation;
import com.example.subscriptionproject.repository.SubscriptionPlanRepository;
import com.example.subscriptionproject.repository.UserInformationRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControllerService {

    @Autowired
    UserInformationRepository userInformationRepository;

    @Autowired
    SubscriptionPlanRepository subscriptionPlanRepository;
    public hitValidatorReturn hitValidator(String userName) {
        UserInformation userInformation = userInformationRepository.findByUserName(userName);
        System.out.println(userInformation);

        if(userInformation.getHitsCount() <= userInformation.getSubscriptionPlan().getMaxHitsAllowed() ||
        userInformation.getSubscriptionPlan().getMaxHitsAllowed()==0){
            return new hitValidatorReturn(validHit(userInformation), userInformation.getSubscriptionPlan().getSubscriptionPlan());
        }
        else {
            return new hitValidatorReturn(false, userInformation.getSubscriptionPlan().getSubscriptionPlan());
        }

     }

    private boolean validHit(UserInformation userInformation) {
        userInformation.setHitsCount(userInformation.getHitsCount()+1);
        userInformationRepository.save(userInformation);
        return true;
    }

    public void rechargePlan(String userName) {
        UserInformation userInformation = userInformationRepository.findByUserName(userName);
        System.out.println(userInformation);

        userInformation.setHitsCount(0);
        userInformationRepository.save(userInformation);
    }

    public String updatePlan(String userName, String plan) {
        UserInformation userInformation = userInformationRepository.findByUserName(userName);
        SubscriptionPlan subscriptionPlan = subscriptionPlanRepository.findBySubscriptionPlan(plan);

        System.out.println(userInformation);
        System.out.println(subscriptionPlan);

        if(subscriptionPlan.getMaxHitsAllowed() == userInformation.getSubscriptionPlan().getMaxHitsAllowed()){
            return "No change Required in the Plan as requested plan is the same as subscribed plan";
        } else {//if (subscriptionPlan.getMaxHitsAllowed() > userInformation.getSubscriptionPlan().getMaxHitsAllowed()) {
            userInformation.setSubscriptionPlan(subscriptionPlan);
            userInformationRepository.save(userInformation);
            return "Requested subscription plan upgraded";
        }
    }
}
