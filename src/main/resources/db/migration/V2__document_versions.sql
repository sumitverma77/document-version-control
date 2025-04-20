CREATE TABLE document_versions (
                                   id BIGINT PRIMARY KEY,
                                   document_id BIGINT NOT NULL,
                                   version INT NOT NULL,
                                   s3_key VARCHAR(255) NOT NULL,
                                   s3_url TEXT NOT NULL,
                                   uploaded_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                   uploaded_by BIGINT,

                                   CONSTRAINT fk_document
                                       FOREIGN KEY (document_id)
                                           REFERENCES documents(id)
                                           ON DELETE CASCADE
);
