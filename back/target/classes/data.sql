INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

              
INSERT INTO mesto(id, grad, drzava) VALUES(1, 'Novi Sad', 'SER');
INSERT INTO mesto(id, grad, drzava) VALUES(2, 'Sibenik', 'CRO');
INSERT INTO mesto(id, grad, drzava) VALUES(3, 'Beograd', 'SER');
INSERT INTO mesto(id, grad, drzava) VALUES(4, 'Berlin', 'GER');
INSERT INTO mesto(id, grad, drzava) VALUES(5, 'Boom', 'BEL');


INSERT INTO festival(id, naziv, datum_pocetka, datum_zavrsetka, cena_karte, broj_dostupnih_karata, mesto_id) 
			VALUES(1, 'Berlin Festival', '2021-08-12', '2021-08-15', 1850, 78, 4);
INSERT INTO festival(id, naziv, datum_pocetka, datum_zavrsetka, cena_karte, broj_dostupnih_karata, mesto_id) 
			VALUES(2, 'EXIT', '2021-07-15', '2021-07-20', 9000, 137, 1);
INSERT INTO festival(id, naziv, datum_pocetka, datum_zavrsetka, cena_karte, broj_dostupnih_karata, mesto_id)
			VALUES(3, 'Terraneo Festival', '2021-08-18', '2021-08-22', 5000, 20, 2);
INSERT INTO festival(id, naziv, datum_pocetka, datum_zavrsetka, cena_karte, broj_dostupnih_karata, mesto_id)
			VALUES(4, 'Beer fest', '2021-09-28', '2021-10-02', 6500, 150, 3);
INSERT INTO festival(id, naziv, datum_pocetka, datum_zavrsetka, cena_karte, broj_dostupnih_karata, mesto_id)
			VALUES(5, 'Tomorrowland ', '2021-09-22', '2021-10-27', 18000, 145, 5);
