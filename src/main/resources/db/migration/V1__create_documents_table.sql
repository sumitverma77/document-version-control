CREATE TABLE documents (
                           id BIGINT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           user_id VARCHAR(255) NOT NULL,
                           created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
