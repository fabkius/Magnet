# Instrucciones para ejecutar la API

- Servicio Válida es mutante o humano:
   
    Endpoint: http://localhost:8080/mutant/
    Tipo: POST
    
    Request (ejemplo): 
                         {
                            "dna":["ATACGA","GAGAGC","TTAGGT","AGCATG","CACCTA","GCACTG"]
                         }

    Response es Mutante:

                         status code: 200

    Response es Humano:  

                         status code: 403


- Servicio para estadísicas de validaciones:

    Endpoint: http://localhost:8080/stats
    Tipo: GET 

    Request:

               (no recibe parametros)
    
    
    Response (ejemplo):

               {
                  "count_mutant_dna": 8,
                  "count_human_dna": 11,
                  "ratio": 72.0
               }


