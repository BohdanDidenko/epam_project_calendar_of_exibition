package com.calendarofexibition.service;

import com.calendarofexibition.persistence.FactoryDAO;
import com.calendarofexibition.service.implementation.ConsumerServiceImpl;
import com.calendarofexibition.service.implementation.EventServiceImpl;
import com.calendarofexibition.service.implementation.OrderServiceImpl;
import com.calendarofexibition.service.interfeices.ConsumerService;
import com.calendarofexibition.service.interfeices.EventService;
import com.calendarofexibition.service.interfeices.OrderService;

public class ServiceFactory {
    private static volatile ServiceFactory instance;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance(){
        if(instance == null){
            synchronized (ServiceFactory.class){
                if(instance == null){
                    instance = new ServiceFactory();
                }
            }
        }
        return instance;
    }

    public ConsumerService getConsumerService(){
        return new ConsumerServiceImpl();
    }

    public EventService getEventService(){
        return new EventServiceImpl();
    }

    public OrderService getOrderService(){
        return new OrderServiceImpl();
    }
}
