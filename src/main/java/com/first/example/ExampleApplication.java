package com.first.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class,args);
//		ConfigurableApplicationContext context=
//		ApplicationContext context=
		//uper ke dono use ho sakte h

//		ApplicationContext context=SpringApplication.run(ExampleApplication.class, args);
//		UserRepository userRepository=context.getBean(UserRepository.class);
//		User user=new User();
//		user.setName("rameshkumar");
//		user.setCity("allahabad");
//		user.setStatus("i am coding");
////        saving single user
//		User user1= userRepository.save(user);
//		System.out.println(user1);

		//create object of user
//		User user1=new User();
//		user1.setName("ajaykumar");
//		user1.setCity("allahad");
//		user1.setStatus("i am foding");
//		//saving multiple user
//	  List<User> users=List.of(user,user1);
//	Iterable<User> result=userRepository.saveAll(users);
//	result.forEach(user2->{
//		System.out.println(user2);
//	});
     //update the user of id 3
		//Optinal use karte h get data ke liye
//		Optional<User> optional=userRepository.findById(4);
//		User user3=optional.get();
//		user3.setName("Sumit kumar");
//		User result=userRepository.save(user3);
//		System.out.print(result);

		//delete user
//		userRepository.deleteById(1);
	}




}
