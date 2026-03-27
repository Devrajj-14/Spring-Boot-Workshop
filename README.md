# AddressBookApp - Spring Boot REST API

## Project Summary
A Spring Boot Address Book application providing REST APIs to manage address book entries. Demonstrates Spring MVC architecture with layered separation: Controller → Service → Model/DTO.

---

## Tech Stack
| Technology | Version |
|---|---|
| Java | 17 |
| Spring Boot | 3.2.3 |
| Spring Web (MVC) | Included |
| Spring Data JPA | Included |
| MySQL Connector/J | Included |
| Spring Boot Validation | Included |
| Spring Boot DevTools | Included |
| Maven | 3.x |

---

## Package Structure
```
src/main/java/com/bridgelabz/addressbookapp/
├── controller/
│   └── AddressBookController.java
├── dto/
│   └── AddressBookDTO.java
├── model/
│   └── AddressBookData.java
├── service/
│   ├── IAddressBookService.java
│   └── AddressBookService.java
└── AddressBookAppApplication.java
```

---

## Implemented Use Cases

| UC | Branch | Description |
|---|---|---|
| UC1 | `feature/UC1-AddressBook-Project-Setup` | Spring Boot project setup with all dependencies |
| UC2 | `feature/UC2-AddressBook-RestController` | REST controller with GET/POST/PUT/DELETE endpoints |
| UC3 | `feature/UC3-AddressBook-DTO-Model` | AddressBookDTO and AddressBookData model classes |
| UC4 | `feature/UC4-AddressBook-Service-Layer` | Service interface + implementation with @Autowired injection |
| UC5 | `feature/UC5-AddressBook-Local-List` | In-memory List storage with full CRUD support |

---

## REST Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/addressbook/` | Get all address book entries |
| GET | `/addressbook/get/{id}` | Get entry by ID |
| POST | `/addressbook/create` | Create new entry |
| PUT | `/addressbook/update/{id}` | Update entry by ID |
| DELETE | `/addressbook/delete/{id}` | Delete entry by ID |

---

## Sample CURL Commands

```bash
# Get all entries
curl localhost:8080/addressbook/ -w "\n"

# Get entry by ID
curl localhost:8080/addressbook/get/1 -w "\n"

# Create a new entry
curl -X POST -H "Content-Type: application/json" \
  -d '{"name":"John Doe","address":"MG Road","city":"Bengaluru","phoneNumber":"9876543210"}' \
  "http://localhost:8080/addressbook/create" -w "\n"

# Update entry by ID
curl -X PUT -H "Content-Type: application/json" \
  -d '{"name":"John Updated","address":"Brigade Road","city":"Bengaluru","phoneNumber":"9999999999"}' \
  "http://localhost:8080/addressbook/update/1" -w "\n"

# Delete entry by ID
curl -X DELETE localhost:8080/addressbook/delete/1 -w "\n"
```

---

## Branch Strategy

This project follows **Git Flow**:

- **`master`** — Stable release branch. Contains only the README.
- **`develop`** — Integration branch. All UC feature branches are merged here.
- **`feature/UCx-*`** — Individual UC feature branches (retained for code review via `-k` flag).

### Feature branches (all retained):
- `feature/UC1-AddressBook-Project-Setup`
- `feature/UC2-AddressBook-RestController`
- `feature/UC3-AddressBook-DTO-Model`
- `feature/UC4-AddressBook-Service-Layer`
- `feature/UC5-AddressBook-Local-List`

---

## Service Layer Explanation

The service layer decouples business logic from the REST controller:

- **`IAddressBookService`** — Interface defining all operations: `getAllEntries()`, `getEntryById()`, `createEntry()`, `updateEntry()`, `deleteEntry()`
- **`AddressBookService`** — Concrete implementation annotated with `@Service`
- **Controller** uses `@Autowired` to inject `IAddressBookService` — controller has no business logic

---

## Local List Storage (UC5)

`AddressBookService` maintains an in-memory `ArrayList<AddressBookData>`:

- **Storage**: `private final List<AddressBookData> addressBookList = new ArrayList<>()`
- **ID generation**: `AtomicInteger` auto-increments for each new entry
- **GET all**: Returns a copy of the full list
- **GET by ID**: Streams the list and filters by ID
- **POST**: Creates new `AddressBookData` from DTO, appends to list
- **PUT**: Finds entry by ID and updates fields in-place
- **DELETE**: Uses `removeIf()` to remove matching entry

Data is held in memory only — it resets on application restart.

---

## How to Run

### Prerequisites
- Java 17+
- Maven 3.x

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/Devrajj-14/Spring-Boot-Workshop.git
   cd Spring-Boot-Workshop
   git checkout develop
   ```

2. (Optional) Configure MySQL in `src/main/resources/application.properties` if you wish to use the database.

3. Build and run:
   ```bash
   mvn spring-boot:run
   ```

4. The app starts on `http://localhost:8080`

5. Test with CURL commands from the section above.

---

## Commit Convention

All commits follow the format:
```
[Devraj]: <message>
```

Each UC has at minimum:
- A **progress commit**: `[Devraj]: progress on UCx ...`
- A **completion commit**: `[Devraj]: complete UCx ...`
