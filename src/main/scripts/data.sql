insert into
	Admin
values
	(
		CONCAT('Admin', nextval('seq_Admin')),
		'admin@gmail.com',
		'admin'
	);

insert into
	Utilisateur
values
	(
		CONCAT('Utilisateur', nextval('seq_Utilisateur')),
		'Martin',
		'martin',
		'martin@gmail.com',
		'1111'
	),
	(
		CONCAT('Utilisateur', nextval('seq_Utilisateur')),
		'Koto',
		'koto',
		'koto@gmail.com',
		'222'
	),
	(
		CONCAT('Utilisateur', nextval('seq_Utilisateur')),
		'Bob',
		'bob',
		'bob@gmail.com',
		'333'
	),
	(
		CONCAT('Utilisateur', nextval('seq_Utilisateur')),
		'Raozy',
		'raozy',
		'raozy@gmail.com',
		'444'
	);

insert into
	Categorie
values
	(
		concat('Categorie', nextval('seq_Categorie')),
		'oeuvre'
	),
	(
		concat('Categorie', nextval('seq_Categorie')),
		'meuble'
	),
	(
		concat('Categorie', nextval('seq_Categorie')),
		'technologie'
	),
	(
		concat('Categorie', nextval('seq_Categorie')),
		'fashion'
	);

insert into
	Enchere
values
	(
		concat('Enchere', nextval('seq_Enchere')),
		default,
		'24:00:00',
		110000,
		default,
		'Tableau',
		'objet de valeur',
		'Utilisateur1',
		'Categorie1'
	),
	(
		concat('Enchere', nextval('seq_Enchere')),
		default,
		'24:00:00',
		70000,
		default,
		'Table',
		'table a manger en marbre',
		'Utilisateur2',
		'Categorie2'
	),
	(
		concat('Enchere', nextval('seq_Enchere')),
		default,
		'24:00:00',
		500000,
		default,
		'Smartphone',
		'samsung A7 2018',
		'Utilisateur3',
		'Categorie3'
	),
	(
		concat('Enchere', nextval('seq_Enchere')),
		default,
		'24:00:00',
		35000,
		default,
		'Chaussure',
		'occasion de france',
		'Utilisateur4',
		'Categorie4'
	),
	(
		concat('Enchere', nextval('seq_Enchere')),
		default,
		'24:00:00',
		30000,
		default,
		'Batterie',
		'neuve 80A',
		'Utilisateur1',
		'Categorie3'
	);

insert into
	Photo
values
	(
		concat('Photo', nextval('seq_Photo')),
		'tableau.jpg',
		'Enchere1'
	),
	(
		concat('Photo', nextval('seq_Photo')),
		'table.jpg',
		'Enchere2'
	),
	(
		concat('Photo', nextval('seq_Photo')),
		'smartphone.jpg',
		'Enchere3'
	),
	(
		concat('Photo', nextval('seq_Photo')),
		'chaussure.jpg',
		'Enchere4'
	),
	(
		concat('Photo', nextval('seq_Photo')),
		'batterie.jpg',
		'Enchere5'
	);

insert into
	RechargeCompte
values
	(
		concat('RechargeCompte', nextval('seq_RechargeCompte')),
		200000,
		default,
		default,
		'Utilisateur2'
	),
	(
		concat('RechargeCompte', nextval('seq_RechargeCompte')),
		400000,
		default,
		default,
		'Utilisateur3'
	),
	(
		concat('RechargeCompte', nextval('seq_RechargeCompte')),
		600000,
		default,
		default,
		'Utilisateur2'
	),
	(
		concat('RechargeCompte', nextval('seq_RechargeCompte')),
		250000,
		default,
		default,
		'Utilisateur4'
	);

insert into
	Config
values
	('tauxCommission', '10');