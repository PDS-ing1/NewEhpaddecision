-- Table `PDS`.`Connected_Object`
-- -----------------------------------------------------
CREATE TABLE connected_object (
   object_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
   state INT NULL
  )
ENGINE = InnoDB;
--------------------------------------------------------
-- Table Sensor 
  CREATE TABLE sensor (
   sensor_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   mode VARCHAR(45) BINARY NULL,
   object_connected_idObjects INT NOT NULL,
  
 CONSTRAINT fk_sensor_conected_object
    FOREIGN KEY (Object_connected_idObjects)
    REFERENCES connected_object (object_id)
    )
ENGINE = InnoDB;
---------------------------------------------------------
--Table smoke_sensor
CREATE TABLE smoke_sensor (
  smoke_sensor_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  steam_identified VARCHAR(45) BINARY NULL,
  sensor_smokesensor_id INT NOT NULL,
  
 CONSTRAINT fk_sensor_smokesensor
    FOREIGN KEY (sensor_smokesensor_id)
    REFERENCES sensor(sensor_id)
    )
ENGINE = InnoDB;
-------------------------------------------------------------
--Table humidity_sensor

CREATE TABLE humidity_sensor(
   humidity_sensor_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   temperature INT NULL,
   sensor_humiditysensor_id INT NOT NULL,
  
  CONSTRAINT fk_sensor_humiditysensor
    FOREIGN KEY (sensor_humiditysensor_id)
    REFERENCES sensor (sensor_id)
   )
ENGINE = InnoDB;
--------------------------------------------------------------------
--Table alert

CREATE TABLE alert(
   alert_id  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   alert_type VARCHAR(45) NULL,
   sensor_alert_id INT NOT NULL,
  
 CONSTRAINT fk_alert_sensor
    FOREIGN KEY (sensor_alert_id)
    REFERENCES sensor (sensor_id)
    )
ENGINE = InnoDB;
--------------------------------------------------------------------
--Table administrator

CREATE TABLE administrator (
   administrator_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   last_name VARCHAR(45) NULL,
   first_name VARCHAR(45) NULL
  )
  
ENGINE = InnoDB;

----------------------------------------------------------------------
--Table User

CREATE TABLE user (
   user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   last_name VARCHAR(60) NULL,
   first_name VARCHAR(45) NULL
  )
  
ENGINE = InnoDB;

-----------------------------------------------------------------------
--Table location 

CREATE TABLE location (
   hall_nb INT NOT NULL,
   floor_nb INT NOT NULL,
   building_nb INT NOT NULL,
   
  location_connectedobject_id INT NOT NULL,
  
  PRIMARY KEY (hall_nb,floor_nb,building_nb),
  CONSTRAINT fk_location_connectedobject
    FOREIGN KEY (location_connectedobject_id )
    REFERENCES connected_object (object_id)
    )
ENGINE = InnoDB;

-------------------------------------------------------------------------
--Table Camera

CREATE TABLE camera (
   camera_id INT NOT NULL AUTO_INCREMENT  PRIMARY KEY,
   camera_connectedobject_id INT NOT NULL,
 
  CONSTRAINT fk_camera_connectedobject
    FOREIGN KEY (camera_connectedobject_id )
    REFERENCES connected_object(object_id)
    )
ENGINE = InnoDB;

-------------------------------------------------------------------------
--Table History

CREATE TABLE history (
   record_nb INT NOT NULL PRIMARY key,
   record_date DATE NULL,
   history_camera_id INT NOT NULL,
   history_camera_connectedobject_id INT NOT NULL,
  
  CONSTRAINT fk_history_camera_id
    FOREIGN KEY (history_camera_id)
    REFERENCES camera (camera_id),
  CONSTRAINT fk_history_camera_object
    FOREIGN KEY (history_camera_connectedobject_id)
    REFERENCES camera (camera_connectedobject_id)
	
    )
	
ENGINE = InnoDB;

-------------------------------------------------------------------------
-- Table Manage

CREATE TABLE manage(

   object_manage_id INT NOT NULL,
   user_manage_id INT NOT NULL,
  
  PRIMARY KEY (object_manage_id,user_manage_id ),
  
  CONSTRAINT fk_manage_connectedobject_id
    FOREIGN KEY (object_manage_id)
    REFERENCES connected_object (object_id ),
    
  CONSTRAINT fk_manage_user_id
    FOREIGN KEY (user_manage_id)
    REFERENCES user (user_id)
    )
ENGINE = InnoDB;

-------------------------------------------------------------------------
--Table Control

CREATE TABLE control (

  object_control_id INT NOT NULL,
  administrator_control_id INT NOT NULL,
  PRIMARY KEY (object_control_id ,administrator_control_id ),
  CONSTRAINT fk_control_connectedobject_id
    FOREIGN KEY (object_control_id )
    REFERENCES connected_object (object_id),
    
  CONSTRAINT fk_control_administrator_id
    FOREIGN KEY (administrator_control_id)
    REFERENCES administrator (administrator_id)
    )
	
ENGINE = InnoDB;
-------------------------------------------------------------------

CREATE TABLE repository(

   alertId INT NOT NULL PRIMARY KEY,
   alerttype VARCHAR(45) NULL
  )

ENGINE = InnoDB;

insert into repository values(0,'humidite');
insert into repository values(1,'humidite');
insert into repository values(2,'humidite');
insert into repository values(3,'humidite');
insert into repository values(4,'humidite');
insert into repository values(5,'humidite');



























































