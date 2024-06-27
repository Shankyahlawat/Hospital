#                                     HOSPITAL

# Doctor's Entity
![Screenshot (77)](https://github.com/Shankyahlawat/Hospital/assets/139940082/52d5bef9-037e-42a1-9f86-73eedc8bc07b)

# Curl
curl --location 'http://localhost:8080/api/doctors' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "Shashank01",
  "city": "Noida",
  "email": "johndoe@example.com",
  "phoneNumber": "1234567890",
  "speciality": "Orthopaedic"
 
  
}'

# Patient's Entity
![Screenshot (76)](https://github.com/Shankyahlawat/Hospital/assets/139940082/384b7798-3518-4f00-b6fb-11c0c2da2e29)

# Curl
curl --location 'http://localhost:8080/api/patients' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "Jane01fghjk",
  "city": "Noida",
  "email": "janedoe@example.com",
  "phoneNumber": "0987654321",
  "symptom": "Back Pain",
  "id": "2"
}'

# Suggested Doctors
![Screenshot (78)](https://github.com/Shankyahlawat/Hospital/assets/139940082/97f59680-73fc-467b-b60a-facbe6204db5)

# Curl
curl --location 'http://localhost:8080/api/suggestions?patientId=4'
