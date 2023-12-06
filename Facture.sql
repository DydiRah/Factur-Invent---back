table validation
int idValidation
int idDemande
int etat 
date Validation


table etat:
    0 refuser
    20 valide par chef de departement
    30 valide par chef departement achat
    40 valide par Directeur Achat Financier


-----view ---- 
SELECT 
    d.*,
    COALESCE(valid.validation_etat, 0) AS validation_etat,
    valid.validation_date,
    COALESCE(valid.validation_id, 0) AS validation_id
FROM 
    demande d
LEFT JOIN  
    validation valid 
    ON d.demande_id = valid.demande_id 
WHERE 
    COALESCE(valid.validation_etat, 0) = 0;


SELECT  d.*,  COALESCE(valid.validation_etat, 0) AS validation_etat, valid.validation_date, COALESCE(valid.validation_id, 0) AS validation_id FROM demande d LEFT JOIN  validation valid ON d.demande_id = valid.demande_id WHERE COALESCE(valid.validation_etat, 0) = 0;

--creation view--
create view sortie_view as select rv.*,a.nature from reste_view rv join article a on rv.article_id = a.article_id where reste > 0;

create view stock_view as
select a.*,reste,total_prix as prix from
(select article_id,sum(reste) as reste,sum(total_prix) as total_prix from reste_view group by article_id) as s
join article a on s.article_id = a.article_id;

create view reste_view as
select a.*, coalesce(a.quantite-v.quantite,a.quantite) as reste,coalesce(a.quantite-v.quantite,a.quantite)*a.prix_unitaire as total_prix
from achat a left outer join (select source,sum(quantite) as quantite from vente group by source) as v on a.id_stock = v.source;

create view marge_view as
select v.*,a.prix_unitaire as pi,(v.prix_unitaire*v.quantite)-(a.prix_unitaire*v.quantite) as marge from vente v
join achat a on  v.source = a.id_stock;
