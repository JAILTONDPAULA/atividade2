INSERT INTO CLIENTE (
    NOME_COMPLETO   ,
    CPF             ,
    DATA_NASCIMENTO ,
    ST_CIVIL        ,
    RENDA_MENSAL    ,
    E_MAIL          ,
    ABERTURA_CONTA
)
VALUES
--Cliente menor de idade
(
    'GABRIEL DE JESUS',
    '12345678909'     ,
    '2010-01-01'      ,
    '1'               ,
    '1500'            ,
    'jailton.viana2@hotmail.com',
    '2024-11-01'
),
--cliente com mais de 80 anos
(
    'MARIA DE JESUS'  ,
    '98765432100'     ,
    '1944-11-01'      ,
    '3'               ,
    '1520'            ,
    'jailton.viana2@hotmail.com',
    '2000-01-01'
),
--cliente divorciado
(
    'ANTONIO AZUL'    ,
    '45678912345'     ,
    '2000-03-30'      ,
    '4'               ,
    '1600'            ,
    'jailton.viana2@hotmail.com',
    '2023-06-15'
),
--cliente viúva
(
    'ALICIA BLUE'     ,
    '32165498700'     ,
    '1990-12-15'      ,
    '3'               ,
    '5000'            ,
    'jailton.viana2@hotmail.com',
    '2005-12-05'
);