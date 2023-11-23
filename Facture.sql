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