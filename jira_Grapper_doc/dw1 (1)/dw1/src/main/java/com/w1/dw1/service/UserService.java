package com.w1.dw1.service;

import com.w1.dw1.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public List<User> store=new ArrayList<>();
   public UserService(){
      // store.add(new User("1L",));
       store.add(new User(1L,"shubham","shubham@gmail.com"));
   }

    public List<User> getStore() {
       System.out.println(" store "+store);
        return this.store;
    }
}
