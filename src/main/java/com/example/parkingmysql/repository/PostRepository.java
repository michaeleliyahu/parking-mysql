package com.example.parkingmysql.repository;

import com.example.parkingmysql.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
