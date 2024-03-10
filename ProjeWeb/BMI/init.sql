create table users
(
    id            serial
        primary key,
    date_of_birth varchar(255),
    first_name    varchar(255),
    gender        varchar(255),
    height        double precision,
    last_name     varchar(255),
    weight        double precision
);

create table bmi
(
    id              serial primary key,
    bmi_index       double precision,
    classification  varchar(255),
    date_calculated date,
    user_id         integer references users (id)
);


create view report as
select first_name, last_name, weight, height, bmi_index, classification, bmi.id as id
from bmi
         join users on users.id = bmi.user_id;

CREATE OR REPLACE FUNCTION calculate_bmi_classification()
    RETURNS TRIGGER AS $$
DECLARE
    user_weight DOUBLE PRECISION;
    user_height DOUBLE PRECISION;
    bmi_index DOUBLE PRECISION;
    bmi_classification VARCHAR(255);
BEGIN

    SELECT weight, height INTO user_weight, user_height
    FROM users
    WHERE id = NEW.user_id;


    bmi_index = (user_weight / (user_height * user_height)) * 10000;


    IF bmi_index < 16 THEN
        bmi_classification := 'Severe Thinness';
    ELSIF bmi_index < 17  THEN
        bmi_classification := 'Moderate Thinness';
    ELSIF bmi_index < 18.5 THEN
        bmi_classification := 'Mild Thinness';
    ELSIF bmi_index < 25  THEN
        bmi_classification := 'Normal';
    ELSIF bmi_index < 30  THEN
        bmi_classification := 'Overweight';
    ELSIF bmi_index < 35  THEN
        bmi_classification := 'Obese Class I';
    ELSIF bmi_index < 40  THEN
        bmi_classification := 'Obese Class II';
    ELSE
        bmi_classification := 'Obese Class III';
    END IF;


    NEW.bmi_index := bmi_index;
    NEW.classification := bmi_classification;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER bmi_calculation_trigger
    BEFORE INSERT ON bmi
    FOR EACH ROW
EXECUTE PROCEDURE calculate_bmi_classification();