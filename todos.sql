-- Database PostgreSQL 17

CREATE TABLE IF NOT EXISTS "todos" (
    "id" BIGSERIAL PRIMARY KEY,
    "user_id" BIGINT NOT NULL,
    "title" VARCHAR(255) NOT NULL,
    "description" TEXT NOT NULL,
    "is_completed" BOOLEAN NOT NULL DEFAULT FALSE,
    "created_at" TIMESTAMP NULL,
    "updated_at" TIMESTAMP NULL,
    "is_deleted" BOOLEAN NOT NULL DEFAULT FALSE
);

-- Dumping 5 row data for table todos
-- INSERT INTO "todos" ("user_id","title", "description", "completed", "created_at", "updated_at", "is_deleted") VALUES
-- (302, 'Learn Java', 'Learn Java Programming Language', FALSE, '2022-01-01 00:00:00', '2022-01-01 00:00:00', FALSE),
-- (302, 'Learn Spring Boot', 'Learn Spring Boot Framework', FALSE, '2022-01-01 00:00:00', '2022-01-01 00:00:00', FALSE),
-- (302, 'Learn PostgreSQL', 'Learn PostgreSQL Database', FALSE, '2022-01-01 00:00:00', '2022-01-01 00:00:00', FALSE),
-- (302, 'Learn React', 'Learn React JavaScript Library', FALSE, '2022-01-01 00:00:00', '2022-01-01 00:00:00', FALSE),
-- (302, 'Learn Docker', 'Learn Docker Containerization', FALSE, '2022-01-01 00:00:00', '2022-01-01 00:00:00', FALSE);