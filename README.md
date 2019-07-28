# Example of Neo4J working on spring Boot
  **Problem**  : Try to find all families  from some node 
  

------------


  To create nodes and  their connections
  http://localhost:8080/start
  

------------


  To get ancestors and descendants for node name 3
  http://localhost:8080/families?jobName=3
  

------------


  example
  ////////////////
  

------------


{
  "family": {
    "progenies": [
      {
        "id": 41,
        "name": "4"
      }
    ],
    "accents": [
      {
        "id": 20,
        "name": "2"
      },
      {
        "id": 40,
        "name": "3"
      },
      {
        "id": 0,
        "name": "1"
      }
    ]
  }
}
