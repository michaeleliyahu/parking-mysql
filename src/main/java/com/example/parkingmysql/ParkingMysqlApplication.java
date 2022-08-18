package com.example.parkingmysql;

import com.example.parkingmysql.models.Post;
import com.example.parkingmysql.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingMysqlApplication{

	public static void main(String[] args) {
		SpringApplication.run(ParkingMysqlApplication.class, args);
	}

//	@Autowired
//	private PostRepository postRepository;

//	@Override
//	public void run(String... args) throws Exception {
//
//
//		Post student1 = new Post("Ramesh", "Fadatare", 0, "now", "later");
//		postRepository.save(student1);
//
//
//		Post student2 = new Post("Sanjay", "Jadhav", 0, "now", "later");
//		postRepository.save(student2);
//
//		Post student3 = new Post("tony", "stark", 0, "now", "later");
//		postRepository.save(student3);
//
//
//	}
}
