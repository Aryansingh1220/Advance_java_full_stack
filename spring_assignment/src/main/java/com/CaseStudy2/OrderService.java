package com.CaseStudy2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
	
	private NotificationService notificationService;
	@Autowired
	private RestaurantService resService;
	
	public OrderService(@Qualifier("smsNotification")NotificationService notificationService) {
		this.notificationService=notificationService;
	}
	
	public void placeOrder() {
		resService.prepareOrder();
		notificationService.sendNotification("Your order is placed");
	}
	
	

}
