-- Insert data into `atc` table
INSERT INTO `atc` (`idatc`, `atc_name`, `atc_type`, `district`)
VALUES
    (1, 'ATC Name 1', 'ATC Type 1', 'District 1'),
    (2, 'ATC Name 2', 'ATC Type 2', 'District 2'),
    (3, 'ATC Name 3', 'ATC Type 3', 'District 3'),
    (4, 'ATC Name 4', 'ATC Type 4', 'District 4'),
    (5, 'ATC Name 5', 'ATC Type 5', 'District 5');

-- Insert data into `subscriber` table
INSERT INTO `subscriber` (`subscriber_id`, `name`, `surname`, `partronym`, `birth_date`, `gender`, `is_benefitiary`, `atc_idatc`, `intercity_enabled`, `is_institution`)
VALUES
    (1, 'Name 1', 'Surname 1', 'Patronymic 1', '2000-01-01', 'Male', 1, 1, 1, 0),
    (2, 'Name 2', 'Surname 2', 'Patronymic 2', '1995-05-10', 'Female', 0, 2, 1, 0),
    (3, 'Name 3', 'Surname 3', 'Patronymic 3', '1988-12-15', 'Male', 1, 3, 1, 1),
    (4, 'Name 4', 'Surname 4', 'Patronymic 4', '1999-06-20', 'Female', 0, 4, 0, 0),
    (5, 'Name 5', 'Surname 5', 'Patronymic 5', '1992-03-25', 'Male', 1, 5, 0, 0);


-- Insert data into `phone` table
INSERT INTO `phone` (`phone_id`, `phone_number`, `phone_type`, `subscriber_subscriber_id`, `subscriber_atc_idatc`)
VALUES
    (1, '123456789', 'Mobile', 1, 1),
    (2, '987654321', 'Landline', 2, 2),
    (3, '555555555', 'Mobile', 3, 3),
    (4, '111111111', 'Landline', 4, 4),
    (5, '999999999', 'Mobile', 5, 5);

-- Insert data into `adress` table
INSERT INTO `adress` (`adress_id`, `district`, `street`, `building`, `flat`, `postcode`, `phone_phone_id`, `phone_subscriber_subscriber_id`, `phone_subscriber_atc_idatc`)
VALUES
    (1, 'District 1', 'Street 1', 'Building 1', 'Flat 1', '10000', 1, 1, 1),
    (2, 'District 2', 'Street 2', 'Building 2', 'Flat 2', '20000', 2, 2, 2),
    (3, 'District 3', 'Street 3', 'Building 3', 'Flat 3', '30000', 3, 3, 3),
    (4, 'District 4', 'Street 4', 'Building 4', 'Flat 4', '40000', 4, 4, 4),
    (5, 'District 5', 'Street 5', 'Building 5', 'Flat 5', '50000', 5, 5, 5);

-- Insert data into `intercity_call` table
INSERT INTO `intercity_call` (`idcall`, `duration`, `subscriber_subscriber_id`, `subscriber_atc_idatc`, `date`)
VALUES
    (1, '00:10:00', 1, 1, '2023-05-01'),
    (2, '00:15:00', 2, 2, '2023-05-02'),
    (3, '00:20:00', 3, 3, '2023-05-03'),
    (4, '00:25:00', 4, 4, '2023-05-04'),
    (5, '00:30:00', 5, 5, '2023-05-05');

-- Insert data into `monthly_payment` table
INSERT INTO `monthly_payment` (`payment_id`, `amount`, `date`, `subscriber_subscriber_id`, `subscriber_atc_idatc`)
VALUES
    (1, '50', '2023-05-01', 1, 1),
    (2, '70', '2023-05-02', 2, 2),
    (3, '60', '2023-05-03', 3, 3),
    (4, '80', '2023-05-04', 4, 4),
    (5, '55', '2023-05-05', 5, 5);


-- Insert data into `connection_request` table
INSERT INTO `connection_request` (`request_id`, `cable_available`, `channel_available`, `number_available`, `type`, `subscriber_subscriber_id`, `subscriber_atc_idatc`)
VALUES
    (1, 1, 1, 1, 'Type 1', 1, 1),
    (2, 1, 0, 1, 'Type 2', 2, 2),
    (3, 0, 1, 0, 'Type 3', 3, 3),
    (4, 1, 1, 0, 'Type 4', 4, 4),
    (5, 1, 0, 0, 'Type 5', 5, 5);