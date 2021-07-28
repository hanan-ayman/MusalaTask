INSERT INTO gateway (SERIAL_NUMBER , HUMAN_NAME , IPV4 ) VALUES
  ('zKbMLFgx', 'Default gateway', '192.168.1.0'),
  ('YCHCmNpZ', 'Residential gateway', '192.168.1.1'),
  ('66CBHCeV', 'Payment gateway', '192.168.1.2');

INSERT INTO device (UID, vendor, DATE_CREATED , status , SERIAL_NUMBER ) VALUES
  (12356, 'x', TO_DATE('17/12/2015', 'DD/MM/YYYY') , 'online' , 'zKbMLFgx'),
  (12357, 'y', TO_DATE('17/12/2020', 'DD/MM/YYYY') , 'offline' , 'zKbMLFgx'),
  (12359, 'z', TO_DATE('17/12/2021', 'DD/MM/YYYY') , 'online' , '66CBHCeV');