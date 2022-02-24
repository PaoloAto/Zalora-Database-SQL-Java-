SELECT * 
FROM contacts_db.contacts;


INSERT INTO contacts_db.contacts VALUES (7,'MErt','04040440404','mert@dlsu.edu.ph',NULL);

DELETE FROM contacts_db.contacts WHERE id = '1';

UPDATE contacts_db.contacts 
set name = 'MERT'
WHERE id = '5';


