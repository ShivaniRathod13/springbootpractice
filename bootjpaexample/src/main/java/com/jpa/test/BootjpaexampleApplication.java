package com.jpa.test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
	 ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
	 UserRepository userRepository = context.getBean(UserRepository.class);
	 //SAVE DATA//
	 
//	 User user = new User();
//	 user.setName("shivi");
//	 user.setCity("indore");
//	 user.setStatus("i am developer");
//	User user1 = userRepository.save(user);
//	System.out.println(user1);
	 
//	 User user1 = new User();
//	 user1.setName("mohit");
//	 user1.setCity("indore");
//	 user1.setStatus("software");
//	 
//	 User user2 = new User();
//	 user2.setName("shivani");
//	 user2.setCity("indore");
//	 user2.setStatus("junior developer");
//	 
//    //saving single user
//	//User resultUser = userRepository.save(user2);
//	 //9 feature
//	List<User>users = List.of(user1,user2);
//	//save multiple object
//	Iterable<User>result = userRepository.saveAll(users);
//	
//	result.forEach(user->{
//		System.out.println(user);
//	});
	
//	System.out.println(resultUser);
//	System.out.println("done");
	
// END SAVE DATA//
	 
	 //UPDATE THE USER OF ID 11
        
//  Optional<User>optinal =userRepository.findById(3);
//    User user= optinal.get();
//    
//    user.setName("moht rajput");
//    user.setCity("bengalore");
//   User result = userRepository.save(user);
//    System.out.println(result);
	 
	 
	 
    //how to get the data
	 //type 1
    //findById(id)-return optional containing your data
  //  Iterable<User>itr = userRepository.findAll();
//	 Iterator<User>iterator = itr.iterator();
//	 while (iterator.hasNext()) {
//		 User user = iterator.next();
//		 System.out.println(user);
//		
    
//	}
    //type 2
//    itr.forEach(new Consumer<User>() {
//
//		@Override
//		public void accept(User t) {
//			// TODO Auto-generated method stub
//			 System.out.println(t);
//			
//		}
//    	
//    	
//    });
    
    //better way 
    //type 3
   // itr.forEach(user->{System.out.println(user);});
    
	 
	 //delete the user element
//	 userRepository.deleteById(4);
//	 System.out.println("deleted");
	 
	 //better way
//	 Iterable<User>allusers = userRepository.findAll();
//	 allusers.forEach(user->{System.out.println(user);});
//	 userRepository.deleteAll(allusers);
	 
	// this custome Query
//	List<User>users = userRepository.findByNameAndCity("shivi","indore");
//	users.forEach(user->{System.out.println(user);
//	});
	 
//	 List<User>allUser = userRepository.getAllUsers();
//	allUser.forEach(user->{System.out.println(user);
//		});
	
	List<User> userByName = userRepository.findByName("shivi");
	userByName.forEach(user->{System.out.println(user);
	});
	 
	
	userRepository.getUsers().forEach(e->System.out.println(e));
	}

}
