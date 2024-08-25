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



		String json="{\n" +
				"    \"uid\": \"user1234\",\n" +
				"    \"email\": \"maduranga@example.com\",\n" +
				"    \"given_name\": \"madu\",\n" +
				"    \"middle_name\": \"madurur\",\n" +
				"    \"name\": \"John Michael Doe\",\n" +
				"    \"family_name\": \"Doe\",\n" +
				"    \"nickname\": \"Johnny\",\n" +
				"    \"phone_number\": \"+1234567890\",\n" +
				"    \"comment\": \"New user account created for testing.\",\n" +
				"    \"picture\": \"https://example.com/profile-picture.jpg\",\n" +
				"    \"directory\": \"default\",\n" +
				"    \"metadata\": {\n" +
				"        \"color\": \"blue\",\n" +
				"        \"size\": \"XL\"\n" +
				"    },\n" +
				"    \"tags\": [\"admin\", \"beta-tester\"],\n" +
				"    \"is_suspended\": false,\n" +
				"    \"is_bot\": false\n" +
				"}\n";
		String update = userService.updateUser("user1234", json);
		System.out.println(update);

//		String delete = userService.deleteUser("user1234");
//		System.out.println(delete);
	}
}
