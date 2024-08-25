package lk.ijse.gdse66.task;

import lk.ijse.gdse66.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TaskApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;  // Ensure userService is private

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String user = userService.createUser();
		System.out.println(user);

		String getUserDetails = userService.getUserDetails("user1234");
		System.out.println(getUserDetails);

		String userList = userService.listUsers();
		System.out.println(userList);


		String update = userService.updateUser("user1234", "name:maduranga");
		System.out.println(update);

//		String delete = userService.deleteUser("user1234");
//		System.out.println(delete);
	}
}
