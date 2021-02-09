package com.example.demo.components;

import com.example.demo.models.File;
import com.example.demo.models.Folder;
import com.example.demo.models.User;
import com.example.demo.repositories.FileRepository;
import com.example.demo.repositories.FolderRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;


    public DataLoader() {
    }


    @Override
    public void run(ApplicationArguments args) {
        User user1 = new User("Jim");
        userRepository.save(user1);

        User user2 = new User("Bill");
        userRepository.save(user2);

        Folder folder = new Folder("Docs", user1);
        folderRepository.save(folder);

        Folder folder2 = new Folder("Pics", user1);
        folderRepository.save(folder2);

        Folder folder3 = new Folder("Taxes", user2);
        folderRepository.save(folder3);

        File file = new File("CV", "PDF", 24.6, folder);
        fileRepository.save(file);

        File  file2 = new File("Cat Pics", "png", 50.6, folder2);
        fileRepository.save(file2);

        File file3 = new File("Dog Pics", "png", 50.6, folder2);
        fileRepository.save(file3);
    }
}
