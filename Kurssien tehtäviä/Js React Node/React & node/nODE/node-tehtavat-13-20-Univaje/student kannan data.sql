delete from student;
delete from studentype;
delete from postinro;
delete from osoite;

insert into studentype (typeid, selite, status) values(1, 'Varsinainen opiskelija', 0);
insert into studentype (typeid, selite, status) values(2, 'Avoimen AMK:n opiskelija', 0);
insert into studentype (typeid, selite, status) values(3, 'Muu opiskelija', 0);
insert into studentype (typeid, selite, status) values(4, 'Vanhentunut', 1);
insert into studentype (typeid, selite, status) values(5, 'Väärä', 1);

insert into postinro (postinumero, postitoimipaikka) values ('00100','Helsinki');
insert into postinro (postinumero, postitoimipaikka) values ('70100','Kuopio');
insert into postinro (postinumero, postitoimipaikka) values ('70200','Kajaani 20');
insert into postinro (postinumero, postitoimipaikka) values ('71800','Siilinjärvi');

insert into osoite(idosoite, lahiosoite) values(1, 'Opistotie 2');
insert into osoite(idosoite, lahiosoite) values(2, 'Microkatu 1');
insert into osoite(idosoite, lahiosoite) values(3, 'Tekniikkapolku 23');
insert into osoite(idosoite, lahiosoite) values(4, 'Kauppakatu 10'); 

insert into student (etunimi, sukunimi, osoite_idosoite, postinro, typeid) values ('Kalle', 'Tappinen', 1, '70100', 1);
insert into student (etunimi, sukunimi, osoite_idosoite, postinro, typeid) values ('Maija', 'Mehiläinen', 1, '70100', 2);
insert into student (etunimi, sukunimi, osoite_idosoite, postinro, typeid) values ('Liisa', 'Leppänen', 3, '70200', 2);
insert into student (etunimi, sukunimi, osoite_idosoite, postinro, typeid) values ('Teija', 'Testaaja 13-20', 3, '70100', 1);
insert into student (etunimi, sukunimi, osoite_idosoite, postinro, typeid) values ('Maija', 'Makkonen', 2, '00100', 3);
