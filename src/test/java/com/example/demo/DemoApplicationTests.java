package com.example.demo;

import com.example.demo.models.File;
import com.example.demo.models.Folder;
import com.example.demo.models.User;
import com.example.demo.repositories.FileRepository;
import com.example.demo.repositories.FolderRepository;
import com.example.demo.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@AutoConfigureTestDatabase
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	public void canCreateAndSaveUser(){
		User user = new User("Jim");

		userRepository.save(user);
	}

	@Test
	void contextLoads() {
	}

}
