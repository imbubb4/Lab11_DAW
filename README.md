# 💊 Lab11_Heredia_DAW - CRUD con Spring Boot, JPA y MySQL

Proyecto de laboratorio para el curso **Desarrollo de Aplicaciones Web (DAW)**. Se implementan **CRUDs RESTful** de tres entidades (`Producto`, `TipoMedic` y `Medicamento`) usando:

- Spring Boot + JPA
- MySQL
- Postman para pruebas
- IntelliJ IDEA + Maven

---

## 📦 Tecnologías utilizadas

| Herramienta         | Versión     |
|---------------------|-------------|
| Java                | 24          |
| Spring Boot         | 3.5.0       |
| MySQL               | 8.x         |
| Maven               | Integrado   |
| Postman             | Para pruebas|
| IntelliJ IDEA       | 2024.x      |

---

## 📁 Estructura del proyecto

```
src
├── controller
│   ├── ProductoController.java
│   ├── TipoMedicController.java
│   └── MedicamentoController.java
├── model
│   ├── Producto.java
│   ├── TipoMedic.java
│   └── Medicamento.java
├── repository
│   ├── ProductoRepository.java
│   ├── TipoMedicRepository.java
│   └── MedicamentoRepository.java
└── resources
    └── application.properties
```

---

## ⚙️ Configuración

### 1. Crea la base de datos en SQLyog o MySQL Workbench

```sql
CREATE DATABASE bd_farmacia;
```

---

### 2. Configura `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bd_farmacia?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

---

### 3. Ejecuta el proyecto

- Desde IntelliJ IDEA: ejecuta `Lab11HerediaDawApplication.java`
- Espera a que diga `Tomcat started on port 8080`

---

## 🔄 Endpoints de la API REST

### ✅ Producto

| Método | Endpoint                    | Descripción             |
|--------|-----------------------------|--------------------------|
| GET    | `/api/productos`           | Listar todos            |
| GET    | `/api/productos/{id}`      | Buscar por ID           |
| POST   | `/api/productos`           | Crear producto          |
| PUT    | `/api/productos/{id}`      | Actualizar producto     |
| DELETE | `/api/productos/{id}`      | Eliminar producto       |

---

### ✅ TipoMedic

| Método | Endpoint                | Descripción             |
|--------|-------------------------|--------------------------|
| GET    | `/api/tipos`           | Listar todos            |
| GET    | `/api/tipos/{id}`      | Buscar por ID           |
| POST   | `/api/tipos`           | Crear tipo              |
| PUT    | `/api/tipos/{id}`      | Actualizar tipo         |
| DELETE | `/api/tipos/{id}`      | Eliminar tipo           |

#### Ejemplo de POST:

```json
{
  "descripcion": "Antibiótico"
}
```

---

### ✅ Medicamento

| Método | Endpoint                       | Descripción               |
|--------|--------------------------------|----------------------------|
| GET    | `/api/medicamentos`           | Listar todos              |
| GET    | `/api/medicamentos/{id}`      | Buscar por ID             |
| POST   | `/api/medicamentos`           | Crear medicamento         |
| PUT    | `/api/medicamentos/{id}`      | Actualizar medicamento    |
| DELETE | `/api/medicamentos/{id}`      | Eliminar medicamento      |

#### Ejemplo de POST:

```json
{
  "descripcion": "Amoxicilina 500mg",
  "stock": 80,
  "precio": 5.50,
  "tipoMedic": {
    "id": 1
  }
}
```

> ⚠️ Asegúrate de crear el `TipoMedic` primero antes de asociarlo.

---

## ✅ Solución a recursividad infinita

Para evitar el ciclo entre `Medicamento` ↔ `TipoMedic`, se aplicaron:

```java
// en TipoMedic.java
@JsonManagedReference
@OneToMany(mappedBy = "tipoMedic", cascade = CascadeType.ALL)
private List<Medicamento> medicamentos;

// en Medicamento.java
@JsonBackReference
@ManyToOne
@JoinColumn(name = "tipo_medic_id")
private TipoMedic tipoMedic;
```

O alternativamente con:

```java
@JsonIgnoreProperties("medicamentos")
@JsonIgnoreProperties("tipoMedic")
```

---

## 🧪 Pruebas en Postman

Todas las operaciones CRUD fueron verificadas mediante Postman. Cada error 500 o 405 fue resuelto con controladores actualizados y relación funcional.

---

## 📌 Conclusiones

1. Se implementó con éxito un CRUD completo con relación `@ManyToOne`.
2. Se configuró Spring Boot con MySQL y JPA usando IntelliJ.
3. Se aprendió a resolver errores comunes de foreign keys y ciclos infinitos.
4. Se utilizó Postman para validar toda la API.
5. El proyecto quedó listo para escalar o integrar un frontend.

---

## 👩‍💻 Autor

**Adrian Heredia**  
TECSUP – 2025  
[Repositorio GitHub](https://github.com/imbubb4/Lab11_Heredia_DAW)

---
