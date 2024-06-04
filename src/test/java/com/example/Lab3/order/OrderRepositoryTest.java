package com.example.Lab3.order;

import io.github.wimdeblauwe.jpearl.InMemoryUniqueIdGenerator;
import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("data-jpa-test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderRepositoryTest {
    private final OrderRepository repository;
    private final JdbcTemplate jdbcTemplate;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    OrderRepositoryTest(OrderRepository repository,
                           JdbcTemplate jdbcTemplate) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @BeforeEach
    void validatePreconditions() {
        assertThat(repository.count()).isZero();
    }

    @Test
    void testSaveOrder() {
        OrderId id = repository.nextId();
        repository.save(new Order(id, new UserName("Roman Kovinia"), new Phone("0961782978"), Tour.tour2, TourGuide.guid1, LocalDate.of(2025,12,12)));

        entityManager.flush();
        assertThat(jdbcTemplate.queryForObject("SELECT id FROM tt_order",
                UUID.class)).isEqualTo(id.getId());
        assertThat(jdbcTemplate.queryForObject("SELECT full_name FROM tt_order", String
                .class))
                .isEqualTo("Roman Kovinia");
        assertThat(jdbcTemplate.queryForObject("SELECT tour FROM tt_order", Tour.class
        ))
                .isEqualTo(Tour.tour2);

        assertThat(jdbcTemplate.queryForObject("SELECT guide FROM tt_order", TourGuide.class
        ))
                .isEqualTo(TourGuide.guid1);
        assertThat(jdbcTemplate.queryForObject("SELECT tour_date FROM tt_order", LocalDate
                .class))
                .isEqualTo("2025-12-12");
        assertThat(jdbcTemplate.queryForObject("SELECT phone FROM tt_order", String
                .class))
                .isEqualTo("0961782978");
    }

    @Test
    void testFindAllPageable() {
        saveOrders(8);
        Sort sort = Sort.by(Sort.Direction.ASC, "userName.fullName");

        assertThat(repository.findAll(PageRequest.of(0, 5, sort)))
                .hasSize(5)
                .extracting(order -> order.getUserName().getFullName())
                .containsExactly("Sunshine0", "Sunshine1", "Sunshine2", "Sunshine3", "Sunshine4");

        assertThat(repository.findAll(PageRequest.of(1, 5, sort))) //<.>
                .hasSize(3)
                .extracting(order -> order.getUserName().getFullName())
                .containsExactly("Sunshine5", "Sunshine6", "Sunshine7");

        assertThat(repository.findAll(PageRequest.of(2, 5, sort))).isEmpty();
    }

    private void saveOrders(int numberOfUsers) {
        for (int i = 0; i < numberOfUsers; i++) {
            repository.save(new Order(repository.nextId(),
                    new UserName("Sunshine" + i),
                    new Phone("0961782978"),
                    Tour.tour2,
                    TourGuide.guid1,
                    LocalDate.of(2025, Month.JULY, 15)
                    ));
        }
    }
    @TestConfiguration
    static class TestConfig {
        @Bean
        public UniqueIdGenerator<UUID> uniqueIdGenerator() {
            return new InMemoryUniqueIdGenerator();
        }
    }

}