CREATE TABLE users (
    id NUMBER GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    firstname VARCHAR2(255) NOT NULL,
    lastname VARCHAR2(255) NOT NULL,
    email VARCHAR2(255) NOT NULL,
    password VARCHAR2(255) NOT NULL,
    reset_token VARCHAR2(255),
    role VARCHAR2(255) DEFAULT 'User',
    CHECK (role in ('User','Admin')) ENABLE,
    PRIMARY KEY (id),
    UNIQUE (email)
)

CREATE TABLE todos (
    id NUMBER GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    user_id NUMBER NOT NULL,
    title VARCHAR2(255) NOT NULL,
    description CLOB NOT NULL,
    is_completed NUMBER(1) DEFAULT 0, -- BOOLEAN diganti dengan NUMBER(1)
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    is_deleted NUMBER(1) DEFAULT 0, -- BOOLEAN diganti dengan NUMBER(1)
    PRIMARY KEY (id)
);