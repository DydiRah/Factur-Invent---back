create table Utilisateur(
    idUtilisateur serial primary key,
    nom varchar(255),
    prenom varchar(255),
    dateNaissance date,
    poste varchar(255),
    email varchar(255) unique,
    motDePasse varchar(255)
);

create table vehicule(
    matricule varchar(10) primary key,
    marque varchar(255),
    modele varchar(255),
    anneeFabrication integer,
    typeCarburant varchar(255),
    etat integer
);