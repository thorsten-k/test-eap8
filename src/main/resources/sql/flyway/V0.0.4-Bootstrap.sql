
INSERT INTO SecurityView (id,code) VALUES (1,'settings');
INSERT INTO SecurityView (id,code) VALUES (2,'settingsSystem');

INSERT INTO SecurityMenu (id,view_id,parent_id) VALUES (1,1,NULL);
INSERT INTO SecurityMenu (id,view_id,parent_id) VALUES (2,2,1);