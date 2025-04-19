# System Patterns

**System Architecture:**

The application follows a layered architecture, with the following layers:

*   **Presentation Layer:** Handles user interface and user interactions.
*   **Service Layer:** Contains the business logic for document version control.
*   **Data Access Layer:** Interacts with the database and AWS S3.

**Key Technical Decisions:**

*   Using AWS S3 for storing document versions.
*   Using a relational database for storing metadata.
*   Using Spring Boot for building the application.

**Design Patterns:**

*   **Service Layer Pattern:** Encapsulates the business logic in a separate layer.
*   **Data Access Object (DAO) Pattern:** Provides an abstraction layer for accessing the database and AWS S3.
*   **Strategy Pattern:** Allows for different storage strategies (e.g., different S3 storage classes).

**Component Relationships:**

```mermaid
graph LR
    A[User] --> B(Presentation Layer);
    B --> C(Service Layer);
    C --> D(Data Access Layer);
    D --> E[Database];
    D --> F[AWS S3];
