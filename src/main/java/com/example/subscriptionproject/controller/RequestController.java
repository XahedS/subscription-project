package com.example.subscriptionproject.controller;

import com.example.subscriptionproject.service.ControllerService;
import com.example.subscriptionproject.service.hitValidatorReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class RequestController {

    @Autowired
    ControllerService controllerService;

    public RequestController() {
    }

    @RequestMapping("/username/{userName}/hit")
    public String hitRequest(@PathVariable String userName){
        hitValidatorReturn returnStatus = controllerService.hitValidator(userName);
        if(returnStatus.isHitStatus())
            return "Maximum subscription limit not reached";
        else{
            return "Maximum subscription limit reached, please recharge your account or update your plan";
        }
    }

    @RequestMapping("/username/{userName}/rechargePlan")
    public String rechargePlan(@PathVariable String userName){
        controllerService.rechargePlan(userName);
        return "Subscription Re-charged";
    }

    @RequestMapping("/username/{userName}/updatePlan/{plan}")
    public String updatePlan(@PathVariable String userName, @PathVariable String plan){
        String replyRcvd = controllerService.updatePlan(userName, plan);
        return replyRcvd;
    }

}
