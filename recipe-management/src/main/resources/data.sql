insert into user(id, first_name, last_name, email_address, admin_flag, approved_flag) 
values(10000, 'firstNameUser1', 'lastNameUser1', 'test@table.com', false, false);

insert into recipe(id, instructions, title, user_id) values(100, 'These are the instructions to make Tomato Soup', 'Tomato Soup Recipe', 10000);

insert into recipe_ingredient(id, name, quantity, recipe_id) values (1, 'Tomato', '1', 100);
insert into recipe_ingredient(id, name, quantity, recipe_id) values (2, 'Water', '1', 100);
insert into recipe_ingredient(id, name, quantity, recipe_id) values (3, 'Salt', '0.05', 100);
