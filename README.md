# Servlet-Based Calculator Application

## Description
This is a simple web-based calculator application built using **Java Servlets**, **Maven**, and **GlassFish**. It allows users to perform basic arithmetic operations (addition, subtraction, multiplication, and division) while maintaining session state to track the last access time.

## Features  
- HTML form to input numbers and select an operation.  
- Java Servlet to perform calculations and manage sessions.  
- Storage of the last access date using HttpSession.
  
## 🛠 Technologies Used

- **Java Development Kit (JDK):** 11
- **Apache Maven:** 3.9.9
- **GlassFish 7 Application Server:** 7.0.22
- **Servlet API:** 6.0
- **HTML, CSS:** For front-end styling

## 📂 Project Structure
```
CalculatriceServletProject/
│── src/main/java/com/example/
│   ├── CalculatriceServlet.java
│── index.html
├── styles.css
│── pom.xml
│── README.md
```

## ⚙️ Prerequisites
Before running the project, ensure you have the following installed:
1. **Java 11:**
   - Check if installed: `java -version`
   - Download: [https://www.oracle.com/java/technologies/javase-jdk11-downloads.html](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

2. **Maven 3.9.9:**
   - Check if installed: `mvn -v`
   - Download: [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
   - Add Maven to PATH and set `MAVEN_HOME`

3. **GlassFish 7.0.22:**
   - Download: [https://glassfish.org/download](https://glassfish.org/download)
   - Install and add `GLASSFISH_HOME` to your system path

## 🚀 How to Run the Application

### **1️⃣ Clone the Repository**
```sh
 git clone https://github.com/your-repo/calculatrice-servlet.git
 cd calculatrice-servlet
```

### **2️⃣ Build the Project Using Maven**
```sh
mvn clean install
```

### **3️⃣ Deploy on GlassFish**
1. Start GlassFish Server:
   ```sh
   glassfish5/bin/asadmin start-domain
   ```
2. Deploy the application:
   ```sh
   glassfish5/bin/asadmin deploy "here goes your war file name"
   ```
3. Access the application in a browser:
   ```
   http://localhost:8080
   ```

### **4️⃣ Stop GlassFish**
```sh
glassfish5/bin/asadmin stop-domain
```

## 🔍 Troubleshooting
**Issue:** `javax.servlet package not found`
- Ensure **Servlet API dependency** is added in `pom.xml`:
```xml
<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>6.0.0</version>
    <scope>provided</scope>
</dependency>
```
- Make sure you're running the project inside a Servlet-compatible container like **GlassFish**.

**Issue:** `mvn not recognized`
- Ensure Maven is installed and added to the system `PATH`.
- Check with `mvn -v`.




