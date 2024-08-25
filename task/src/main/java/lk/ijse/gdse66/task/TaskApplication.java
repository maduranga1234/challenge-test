package lk.ijse.gdse66.task;

import lk.ijse.gdse66.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;  // Make sure userService is private

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.createUser();
		userService.getUserDetails("user1234");
		userService.listUsers();
		userService.updateUser("user1234","name:maduranga");
		userService.deleteUser("user1234");
	}
}
