package com.revature.location.find.dao;

import com.revature.location.find.model.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void sleepexecution(int i){
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    public List<Customer> getCustomer(){
       return IntStream.rangeClosed(1, 50)
               .peek(CustomerDao::sleepexecution)
               .peek(i-> System.out.println("processing count :" +i))
                .mapToObj(i->new Customer(i,"Customer"+i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomerStream(){
        return Flux.range(1, 50)
                .doOnNext(i-> System.out.println("processing count :" +i))
                .map(i->new Customer(i,"Customer"+i));
    }

    public Flux<Customer> getCustomerList(){
        return Flux.range(1, 50)
                .doOnNext(i-> System.out.println("processing count in stream flow :" +i))
                .map(i->new Customer(i,"Customer"+i));
    }
}
