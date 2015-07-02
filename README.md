# PRIR_Search

Parallel text searching in stored files.

--------------
#API documentation

- GET   http://localhost:4567/files
 
*Returns list of all files*
- GET   http://localhost:4567/search/[text]
  
*Return found text matches in all files* 
- POST  http://localhost:4567/push
  JSON{
        filename: "",
        data: "",
        folder: ""
     }

*Sends file to webservice*
