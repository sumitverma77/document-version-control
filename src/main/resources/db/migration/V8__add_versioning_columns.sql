ALTER TABLE documents ADD COLUMN version INT NOT NULL;
ALTER TABLE documents ADD COLUMN s3Key VARCHAR(255);
ALTER TABLE documents ADD COLUMN s3Url TEXT;
ALTER TABLE documents ADD COLUMN uploadedBy BIGINT;
