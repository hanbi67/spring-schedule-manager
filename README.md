# CH 3. 일정 관리 앱 만들기

---

# API 명세서
### 일정 API 명세서
1. 일정(Schedule) 생성
   - **Request**
     - Method: POST
     - URL: http://localhost:8080/schedules
     - Content-Type: application/json
     - Body:
        ``````{"title": "title", "contents": "contents", "authorName: "authorName", "password": "password"}``````
   
   - **Response**
     - Status Code: `201 Created`
     - Body: `````{"id": 1, "title": "title", "contents": "contents", "authorName: "authorName", "createdAt": "2021-08-23T14:20:00.000+00:00", "modifiedAt": "2021-08-23T14:20:00.000+00:00"}`````
     
     <br/>
     
2. 일정(Schedule) 전체 조회
    - **Request**
      - Method: GET
      - URL: http://localhost:8080/schedules
      - Content-Type: application/json
      
    - **Response**
      - Status Code: `200 OK`
      - Body: `````{"id": 1, "title": "title", "contents": "contents", "authorName: "authorName", "createdAt": "2021-08-23T14:20:00.000+00:00", "modifiedAt": "2021-08-23T14:20:00.000+00:00"}`````

      <br/>

3. 일정(Schedule) 단 건 조회
    - **Request**
      - Method: GET
      - URL: http://localhost:8080/schedules/{scheduleId}
      - Path Parameters: `{scheduleId}`
      - Content-Type: application/json
    
    - **Response**
      - Status Code: `200 OK`
      - Body: `````[ {"id": 1, "title": "title", "contents": "contents", "authorName: "authorName", "createdAt": "2021-08-23T14:20:00.000+00:00", "modifiedAt": "2021-08-23T14:20:00.000+00:00"}, {"id": 2, ...} ]`````

      <br/>

4. 일정(Schedule) 수정
    - **Request**
        - Method: PUT
        - URL: http://localhost:8080/schedules/{scheduleId}
        - Path Parameters: `{scheduleId}`
        - Content-Type: application/json
        - Body:
          ``````{"title": "title", "contents": "contents", "authorName: "authorName", "password": "password"}``````

    - **Response**
        - Status Code: `200 OK`
        - Body: `````{"id": 1, "title": "title", "contents": "contents", "authorName: "authorName", "createdAt": "2021-08-23T14:20:00.000+00:00", "modifiedAt": "2021-08-23T14:20:00.000+00:00"}`````

      <br/>
    
5. 일정(Schedule) 삭제
    - **Request**
        - Method: DELETE
        - URL: http://localhost:8080/schedules/{scheduleId}
        - Path Parameters: `{scheduleId}`
        - Content-Type: application/json

<br/>
---

### 댓글 API 명세서
<br/>

---

# ERD
### 일정(Schedule) ERD
```
Table schedules {
    id long [primary key]
    title varchar(30) [not null]
    contents text(200) [not null]
    authorName varchar [not null]
    password varchar [not null]
    createdAt timestamp
    modifiedAt timestamp
}
```

![img.png](img.png)

### 댓글(Comment) ERD
<br/>
<br/>
