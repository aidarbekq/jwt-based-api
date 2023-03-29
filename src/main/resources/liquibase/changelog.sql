-- Liquibase formatted SQL

-- Create the users table
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       first_name VARCHAR(255),
                       last_name VARCHAR(255),
                       password VARCHAR(255) NOT NULL,
                       created TIMESTAMP NOT NULL,
                       updated TIMESTAMP NOT NULL,
                       status VARCHAR(20) NOT NULL
);

-- Create the roles table
CREATE TABLE roles (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       created TIMESTAMP NOT NULL,
                       updated TIMESTAMP NOT NULL,
                       status VARCHAR(20) NOT NULL
);

-- Create the user_roles table to establish the many-to-many relationship between users and roles
CREATE TABLE user_roles (
                            user_id BIGINT NOT NULL,
                            role_id BIGINT NOT NULL,
                            PRIMARY KEY (user_id, role_id),
                            FOREIGN KEY (user_id) REFERENCES users(id),
                            FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Add an index to improve performance when querying for roles by name
CREATE INDEX idx_roles_name ON roles (name);

-- Add default values for the status column in both tables
ALTER TABLE users ALTER COLUMN status SET DEFAULT 'ACTIVE';
ALTER TABLE roles ALTER COLUMN status SET DEFAULT 'ACTIVE';

-- Add foreign key constraints to ensure referential integrity
ALTER TABLE user_roles ADD CONSTRAINT fk_user_roles_user_id FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE user_roles ADD CONSTRAINT fk_user_roles_role_id FOREIGN KEY (role_id) REFERENCES roles(id);