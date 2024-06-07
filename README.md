ONG ------------------------

Post ->


{
    "nome": "ONG Exemplo",
    "localizacao": "Cidade Exemplo",
    "tipoDeOng": "Assistência Social"
}


Post /api/ongs/{id}/adicionar-necessidade ->

{
    "nome": "Feijão",
    "tipo": "Grão",
    "quantidade": 50,
    "armazem": {
        "id": "9593228d-e408-4fe6-a7c7-c0c86201d98e"
    }
}


Get -> /api/ongs/{id}/listar-necessidades

------------------------------------------



ALIMENTO -----------------------------------


Post /api/alimentos  ->


{
    "nome": "Arroz",
    "tipo": "Grão",
    "quantidade": 100,
    "armazem": {
        "id": "9593228d-e408-4fe6-a7c7-c0c86201d98e"
    },
    "ong": {
        "id": "1"
    }
}


--------------------------------------------

EMPRESA ---------------------------------------

POST /api/empresas ->


{
    "nome": "Empresa Exemplossa",
    "localizacao": "Localização Exemplo",
    "tipoIndustria": "Indústria Exemplo"
}


ARMAZEM ---------------------------------------

POST /api/armazens   ->


{
    "nome": "Armazém Central 2",
    "localizacao": "Centro da Cidade",
    "capacidade": 500.0,
    "empresa": {
        "id": "2"
    }
}


REGISTER ------------------------------------------

POST /api/register

{
    "email": "test@eexample.com",
    "password": "1223456",
    "username": "testuserr",
    "gender": "male"
}


VOLUNTARIOS ---------------------------------------------

Post /api/voluntarios ->

{
    "nome": "Nome do Voluntário",
    "localizacao": "Localização do Voluntário",
    "disponibilidade": true
}


PUT /api/voluntarios/{id} ->

{
    "nome": "Novo Nome do Voluntário",
    "localizacao": "Nova Localização do Voluntário",
    "disponibilidade": false
}


DELETE /api/voluntarios/{id}

------------------------------------------------------------

TRANSPORTADORAS -----------------------------------------------

POST /api/transportadoras ->

{
    "nome": "Nome da Transportadora",
    "localizacao": "Localização da Transportadora",
    "capacidade": 1000.0
}


PUT /api/transportadoras/{id

DELETE /api/transportadoras/{id}













