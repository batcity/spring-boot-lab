package com.example.Repositories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableJpaRepositories(considerNestedRepositories = true)
public class RepositoriesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepositoriesApplication.class, args);
    }

    @Entity
    static class Word {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String text;

        public Word() {}
        public Word(String text) { this.text = text; }
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
    }

    @Repository
    interface WordRepository extends JpaRepository<Word, Long> {}

    @RestController
    class WordController {
        private final WordRepository repo;
        private final Random random = new Random();

        WordController(WordRepository repo) {
            this.repo = repo;
        }

        // Seed database with some sample words after startup
        @PostConstruct
        public void init() {
            if (repo.count() == 0) {
                repo.saveAll(List.of(
                        new Word("serendipity"),
                        new Word("ephemeral"),
                        new Word("luminous"),
                        new Word("sonder"),
                        new Word("mellifluous")
                ));
            }
        }

        @GetMapping("/word-of-the-day")
        public String getWordOfTheDay() {
            List<Word> words = repo.findAll();
            if (words.isEmpty()) return "No words found!";
            Word randomWord = words.get(random.nextInt(words.size()));
            return "Word of the day: " + randomWord.getText();
        }
    }
}
