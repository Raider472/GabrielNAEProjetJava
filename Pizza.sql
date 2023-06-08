-- Suppression des tables existantes;

DROP TABLE IF EXISTS Pizza;

-- Création des tables;

CREATE TABLE Pizza (
    id_Pizza INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nom_Pizza VARCHAR(50) NOT NULL,
    prix_Pizza FLOAT(4,2) NOT NULL,
    nbIngredients_Pizza INT NOT NULL
);

-- Création de données
INSERT INTO Pizza (nom_Pizza, prix_Pizza, nbIngredients_Pizza) VALUES ("margherita", 10.50, 3), ("salami", 7.50, 6);