package com.hellospring.demo.repository;

import com.hellospring.demo.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {
    @Query("update Author a set a.name = :name where a.id = :id")
    void updateName(@Param("id") String id, @Param("name") String name);

    @Query("update Author a set a.surname = :surname where a.id = :id")
    void updateSurname(@Param("id") String id, @Param("surname") String surname);

    @Query("update Author a set a.bio = :bio where a.id = :id")
    void updateBio(@Param("id") String id, @Param("bio") String bio);
}
