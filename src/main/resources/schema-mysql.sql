CREATE TABLE IF NOT EXISTS ticket (
    ticket_id  VARCHAR(255) NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP,
    status BOOLEAN NOT NULL,
    PRIMARY KEY (ticket_id)
);
