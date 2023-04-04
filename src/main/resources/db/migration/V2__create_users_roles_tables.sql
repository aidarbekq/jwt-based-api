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