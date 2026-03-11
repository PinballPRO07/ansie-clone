package nl.han.se.ans.mongoquestions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Seeds MongoDB Atlas with example questions on first startup.
 * Skipped automatically if the collection already has data.
 */
@Component
public class MongoDataSeeder implements CommandLineRunner {

    @Autowired
    private MongoExamQuestionRepository repository;

    @Override
    public void run(String... args) {
        if (repository.count() > 0) {
            System.out.println("[Seeder] MongoDB already has data, skipping seed.");
            return;
        }

        System.out.println("[Seeder] Seeding MongoDB Atlas...");

        // --- OPEN questions ---
        MongoExamQuestion open1 = new MongoExamQuestion();
        open1.setTitle("Toetsvraag 1");
        open1.setDescription("Wat is het antwoord op toetsvraag 1?");
        open1.setType("open");
        open1.setPublished(true);
        open1.setMetadata(Map.of("difficulty", "easy"));

        MongoExamQuestion open2 = new MongoExamQuestion();
        open2.setTitle("Toetsvraag 2");
        open2.setDescription("Wat is het antwoord op toetsvraag 2?");
        open2.setType("open");
        open2.setPublished(true);
        open2.setMetadata(Map.of("difficulty", "medium"));

        MongoExamQuestion open3 = new MongoExamQuestion();
        open3.setTitle("Toetsvraag 3");
        open3.setDescription("Wat is het antwoord op toetsvraag 3?");
        open3.setType("open");
        open3.setPublished(false);
        open3.setMetadata(Map.of("difficulty", "hard"));

        MongoExamQuestion open4 = new MongoExamQuestion();
        open4.setTitle("Toetsvraag 4");
        open4.setDescription("Wat is het antwoord op toetsvraag 4?");
        open4.setType("open");
        open4.setPublished(false);
        open4.setMetadata(Map.of("difficulty", "hard"));

        // --- MC questions ---
        MongoExamQuestion mc1 = new MongoExamQuestion();
        mc1.setTitle("MC Vraag 1");
        mc1.setDescription("Wat is een DTO?");
        mc1.setType("mc");
        mc1.setPublished(true);
        mc1.setOptions(List.of(
                new MongoExamQuestion.MCOption("Delta Tracking Order", false),
                new MongoExamQuestion.MCOption("Data Transfer Object", true),
                new MongoExamQuestion.MCOption("Direct Table Operation", false),
                new MongoExamQuestion.MCOption("Dynamic Type Override", false)
        ));
        mc1.setMetadata(Map.of("difficulty", "easy", "topic", "patterns"));

        MongoExamQuestion mc2 = new MongoExamQuestion();
        mc2.setTitle("MC Vraag 2");
        mc2.setDescription("Welk HTTP-statuscode geeft aan dat een resource niet gevonden is?");
        mc2.setType("mc");
        mc2.setPublished(true);
        mc2.setOptions(List.of(
                new MongoExamQuestion.MCOption("200 OK", false),
                new MongoExamQuestion.MCOption("201 Created", false),
                new MongoExamQuestion.MCOption("404 Not Found", true),
                new MongoExamQuestion.MCOption("500 Internal Server Error", false)
        ));
        mc2.setMetadata(Map.of("difficulty", "easy", "topic", "HTTP"));

        MongoExamQuestion mc3 = new MongoExamQuestion();
        mc3.setTitle("MC Vraag 3");
        mc3.setDescription("Wat is het voordeel van een document-gebaseerde database voor toetsvragen?");
        mc3.setType("mc");
        mc3.setPublished(true);
        mc3.setOptions(List.of(
                new MongoExamQuestion.MCOption("Minder opslagruimte nodig", false),
                new MongoExamQuestion.MCOption("Flexibel schema per vraagtype zonder migraties", true),
                new MongoExamQuestion.MCOption("Snellere JOIN operaties", false),
                new MongoExamQuestion.MCOption("Betere transactie ondersteuning", false)
        ));
        mc3.setMetadata(Map.of("difficulty", "medium", "topic", "databases"));

        // --- ORDERING questions ---
        MongoExamQuestion ordering1 = new MongoExamQuestion();
        ordering1.setTitle("Sorteer de HTTP-methoden");
        ordering1.setDescription("Zet de volgende REST operaties in de juiste volgorde voor een CRUD workflow.");
        ordering1.setType("ordering");
        ordering1.setPublished(true);
        ordering1.setItems(List.of(
                new MongoExamQuestion.OrderItem("POST - Maak een nieuwe resource aan", 1),
                new MongoExamQuestion.OrderItem("GET - Haal de resource op", 2),
                new MongoExamQuestion.OrderItem("PUT - Werk de resource bij", 3),
                new MongoExamQuestion.OrderItem("DELETE - Verwijder de resource", 4)
        ));
        ordering1.setMetadata(Map.of("difficulty", "medium", "topic", "REST"));

        MongoExamQuestion ordering2 = new MongoExamQuestion();
        ordering2.setTitle("Volgorde van Docker Compose opstarten");
        ordering2.setDescription("Zet de stappen voor het opstarten van de ANSIE applicatie in de juiste volgorde.");
        ordering2.setType("ordering");
        ordering2.setPublished(true);
        ordering2.setItems(List.of(
                new MongoExamQuestion.OrderItem("Database container start op", 1),
                new MongoExamQuestion.OrderItem("Database health check slaagt", 2),
                new MongoExamQuestion.OrderItem("Backend container start op", 3),
                new MongoExamQuestion.OrderItem("Frontend container start op", 4)
        ));
        ordering2.setMetadata(Map.of("difficulty", "easy", "topic", "docker"));

        // --- MATCHING questions ---
        MongoExamQuestion matching1 = new MongoExamQuestion();
        matching1.setTitle("Koppel de HTTP-statuscodes");
        matching1.setDescription("Koppel elk HTTP-statuscode aan de juiste betekenis.");
        matching1.setType("matching");
        matching1.setPublished(true);
        matching1.setMatchPairs(List.of(
                new MongoExamQuestion.MatchPair("200", "OK - Verzoek geslaagd"),
                new MongoExamQuestion.MatchPair("201", "Created - Resource aangemaakt"),
                new MongoExamQuestion.MatchPair("400", "Bad Request - Ongeldig verzoek"),
                new MongoExamQuestion.MatchPair("404", "Not Found - Resource niet gevonden"),
                new MongoExamQuestion.MatchPair("500", "Internal Server Error")
        ));
        matching1.setMetadata(Map.of("difficulty", "medium", "topic", "HTTP"));

        MongoExamQuestion matching2 = new MongoExamQuestion();
        matching2.setTitle("Koppel de software architectuur begrippen");
        matching2.setDescription("Koppel elk begrip aan de juiste definitie.");
        matching2.setType("matching");
        matching2.setPublished(true);
        matching2.setMatchPairs(List.of(
                new MongoExamQuestion.MatchPair("Repository", "Abstractie laag voor database toegang"),
                new MongoExamQuestion.MatchPair("Controller", "Verwerkt HTTP verzoeken en stuurt responses"),
                new MongoExamQuestion.MatchPair("DTO", "Object voor data overdracht tussen lagen"),
                new MongoExamQuestion.MatchPair("Docker", "Platform voor containerisatie van applicaties"),
                new MongoExamQuestion.MatchPair("MongoDB", "Document-gebaseerde NoSQL database")
        ));
        matching2.setMetadata(Map.of("difficulty", "hard", "topic", "architecture"));

        repository.saveAll(List.of(
                open1, open2, open3, open4,
                mc1, mc2, mc3,
                ordering1, ordering2,
                matching1, matching2
        ));

        System.out.println("[Seeder] Done! Inserted " + repository.count() + " questions into MongoDB Atlas.");
    }
}