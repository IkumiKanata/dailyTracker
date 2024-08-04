ALTER TABLE user
    ADD COLUMN account_non_expired     BOOLEAN DEFAULT TRUE,
    ADD COLUMN account_non_locked      BOOLEAN DEFAULT TRUE,
    ADD COLUMN credentials_non_expired BOOLEAN DEFAULT TRUE,
    ADD COLUMN enabled                 BOOLEAN DEFAULT TRUE;
