
INSERT INTO SecurityView (id,code) VALUES (1,'a');
INSERT INTO SecurityView (id,code) VALUES (2,'b');

INSERT INTO SecurityMenu (id,view_id,parent_id) VALUES (1,1,NULL);
INSERT INTO SecurityMenu (id,view_id,parent_id) VALUES (2,2,1);