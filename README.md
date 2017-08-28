# desafioGlobo

O projeto roda com o SpringBoot, utilizando o endereço:
http://localhost:8080/crawler

*****Exemplo de retorno ************

{  
   "feed":[  
      {  
         "item":{  
            "title":".......",
            "link":"http://.....html",
            "description"":[  
               {  
                  "type":"image",
                  "content":".....jpg"
               },
               {  
                  "type":"text",
                  "content":"...."
               },
               {  
                  "type":"links",
                  "content":[  
                     "http://......html",
                     "http://....html",
                     "http://...html"
                  ]
               }
            ]
         }
      },
      {  
         "item":{ ... }
      },
      {  
         "item":{ ... }
      },
      {  
         "item":{ ... }
      },
   ]
}
