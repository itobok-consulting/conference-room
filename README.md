# PROJECT NAME: conference-room-service
This is an API to book conference room

### Tech
Java 17
Maven
Spring Boot 2.7.14
H2 Database


###########  End Points ########### 

1. Used to book conference room

   URL: http://localhost:8081/conference-room/
   @PostMapping(path = "/book-conference-room", produces = "application/json")
    public Bookings bookMeetingRoom(@RequestBody BookingDTO bookingDTO)
    Example:
         {
            "startTime": "09:01",
            "endTime": "09:14",
            "numberOfPeopleAttending": "15"
        }
    
3. List meeting rooms by giving time range

  URL: http://localhost:8081/conference-room/{startTime}/list-rooms/{endTime}
  @GetMapping(path = "/listRooms/{startTime}/{endTime}", produces = "application/json")
    public List<Bookings> listConferenceRoom(@PathVariable String endTime, @PathVariable String startTime)
    
###########  Database  ########### 
This API uses in memory H2 database and it can be viewed running this link http://localhost:8081/conference-room/h2-console/

########### How to run the project  ########### 

-- Using MAVEN

1. checkout the project from repo
2. goto the folder where it saved
3. from command line:
   compile : mvn clean install
   build the project : mvn spring-boot:run

-- From the COMMAND

java -jar target/conference-room-service-0.0.01-SNAPSHOT.jar

########### Postman curls to test the application ###########  

* Book conference room:

curl --location 'http://localhost:8081/conference-room/book-conference-room' \
--header 'Content-Type: application/json' \
--data '{
    "startTime": "02:01",
    "endTime": "02:14",
    "numberOfPeopleAttending": "15"
}'

* List Available rooms:
  
url --location 'http://localhost:8081/conference-room/02:01/list-rooms/02:04' \
--data ''





