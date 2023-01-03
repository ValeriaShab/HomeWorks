CREATE TABLE ActType (
    id int(11) NOT NULL,
    typeName VARCHAR (255),
    CONSTRAINT pk_actType PRIMARY KEY (id)
);

CREATE TABLE DevType(
    id int(11) NOT NULL,
    typeName VARCHAR(255),
    CONSTRAINT pk_devType PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS Device(
    id int(11) NOT NULL,
    modelName VARCHAR(255),
    devType_id int(11),
    CONSTRAINT pk_device PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS Tariff(
    id int(11) NOT NULL,
    nameOfTariff VARCHAR(255),
    price FLOAT,
    CONSTRAINT pk_tariff PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS Abonent(
    id int(11) NOT NULL,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    phoneNumber VARCHAR(255),
    tariff_id int(11),
    device_id int(11),
    CONSTRAINT pk_abonent PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS Activity(
    id int(11) NOT NULL,
    text VARCHAR(255),
    actType_id int(11),
    abonent_id int(11),
    CONSTRAINT pk_activity PRIMARY KEY (id)
    );

alter table Device add CONSTRAINT FK_DEVICE_ON_TYPE FOREIGN KEY (devType_id) REFERENCES DevType (id);
alter table Abonent add CONSTRAINT FK_ABONENT_ON_TARIFF FOREIGN KEY (tariff_id) REFERENCES Tariff (id);
alter table Abonent add CONSTRAINT FK_ABONENT_ON_DEVICE FOREIGN KEY (device_id) REFERENCES Device (id);
alter table Activity add CONSTRAINT FK_ACTIVITY_ON_TYPE FOREIGN KEY (actType_id) REFERENCES ActType (id);
alter table Activity add CONSTRAINT FK_ACTIVITY_ON_ABONENT FOREIGN KEY (abonent_id) REFERENCES abonent (id);