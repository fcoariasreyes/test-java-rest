DROP TABLE USER IF EXISTS;
CREATE TABLE USER (
    ID_USER integer identity primary key,
    NAME varchar(200) not null,
    EMAIL varchar(255),
    PASSWORD varchar(100) not null
    
);

DROP TABLE PHONE IF EXISTS;
CREATE TABLE PHONE (
    ID_PHONE integer identity primary key,
    ID_USER integer   ,
    NUMBER integer   not null,
    CITY_CODE integer not null,
    COUNTRY_CODE integer not null
    
);

DROP TABLE METADATA IF EXISTS;
CREATE TABLE METADATA (
    ID_METADATA integer identity primary key,
    ID_USER integer   not null,
    UUID varchar(100) not null,
    TOKEN varchar(100) not null,
    CREATED_DATE DATE,
    LAST_LOGIN_DATE DATE,
    UPDATE_DATE DATE,
    IS_ACTIVE BOOLEAN
);