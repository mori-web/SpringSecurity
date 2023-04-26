insert into issues (summary, description) values ('バグA', 'バグがあります');
insert into issues (summary, description) values ('機能要望B', 'Bに追加機能がほしいです');
insert into issues (summary, description) values ('画面Cが遅い', '早くしてほしいです');

-- password1234
insert into users (username, password, authority) values ('tom', '6d97bd9c1c49cdd5783bcc0ee7371eb701054101ea6fa5ad13ccee413563d9439a43ffee12532629', 'ADMIN');
insert into users (username, password, authority) values ('bob', 'e5024307241b77e860d8b71e0df246274ee1ee6ceee6a12e0c3a454ec596818cc8dbc58d6d8d4239', 'USER');