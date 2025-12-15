# Aplicación de Recomendación de Películas  
**Proyecto de Ingeniería de Software**  
Repostiorio:
https://github.com/csantillgar/Proyecto-Ingenieria-de-Software.git

---

## 1. Introducción

### 1.1 Objetivo general del sistema
El objetivo principal del sistema es diseñar e implementar una aplicación multiplataforma (móvil y escritorio) que recomiende películas a los usuarios de forma personalizada, basándose en sus preferencias, historial de visualizaciones y valoraciones.

La aplicación permite:
- Registro e inicio de sesión de usuarios.
- Consulta del catálogo de películas.
- Valoración y reseñas.
- Generación de recomendaciones mediante un algoritmo híbrido de filtrado colaborativo y basado en contenido.

---

### 1.2 Justificación del proyecto
Hemos decidido desarrollar una aplicación de recomendación de películas porque se trata de un tipo de sistema muy presente en la vida cotidiana de los usuarios y fácil de entender, lo que permite centrarnos en los conceptos clave del proyecto sin necesidad de un conocimiento previo complejo. El cine es un ámbito de interés general, por lo que resulta sencillo obtener ejemplos, probar la aplicación y evaluar su funcionamiento.

Además, este proyecto nos permite trabajar con funcionalidades importantes como el inicio de sesión de usuarios, la gestión de valoraciones y la personalización de contenidos, aplicando de forma práctica los conocimientos adquiridos en clase.

---

### 1.3 Alcance y limitaciones

#### Alcance funcional
- Registro, autenticación y gestión de usuarios.
- Consulta del catálogo de películas (por género, título y popularidad).
- Gestión del catálogo por parte de administradores (alta, modificación y eliminación).
- Valoraciones y reseñas de usuarios.
- Algoritmo de recomendación basado en preferencias y valoraciones.
- Interfaz móvil y de escritorio con sincronización centralizada.

#### Limitaciones
- No se almacenan ni reproducen películas; únicamente se gestionan datos informativos.
- El motor de recomendación se basa en datos internos, sin integración con plataformas externas.
- No se contempla un escenario de carga masiva de usuarios (no es un sistema distribuido a gran escala).

---

### 1.4 Beneficios esperados
- Experiencia personalizada para cada usuario.
- Centralización de datos y control administrativo del catálogo.
- Escalabilidad modular del sistema.
- Iteraciones y mejoras continuas mediante un ciclo de vida ágil.
- Aplicación de buenas prácticas de ingeniería del software: trazabilidad, modelado, control de versiones y calidad del código.

---

### 1.5 Glosario de términos

| Término | Definición |
|------|-----------|
| **Actor** | Rol que interactúa con el sistema (usuario, administrador). |
| **Caso de uso** | Funcionalidad observable por un actor que produce un resultado concreto. |
| **Recomendación** | Sugerencias de películas según hábitos y valoraciones. |
| **Catálogo** | Base de datos de películas con metadatos. |
| **Backend** | Lógica de negocio implementada en Java con Spring Boot. |
| **Frontend** | Interfaz de usuario en JavaFX (escritorio) y Flutter (móvil). |
| **API REST** | Servicios HTTP que intercambian datos en formato JSON. |
| **Scrum** | Metodología ágil basada en sprints e iteración continua. |

---

## 2. Ingeniería del Software: Enfoque y contexto

### 2.1 Naturaleza del software y motivación
Sistema de información inteligente orientado a la personalización. Se trata de un software evolutivo, dependiente del comportamiento del usuario, que requiere un proceso sistemático para reducir riesgos de desalineación con los requisitos.

---

### 2.2 Tipo de sistema y clasificación
- Sistema de información con componente inteligente (motor de recomendación).
- Aplicación híbrida multiplataforma (escritorio y móvil).
- Arquitectura cliente-servidor RESTful.
- Componentes:
  - **Datos**: base de datos relacional.
  - **Lógica**: Spring Boot.
  - **Presentación**: JavaFX / Flutter.

---

### 2.3 Ciclo de vida elegido
Ciclo de vida ágil iterativo-incremental basado en Scrum, con sprints de 2–3 semanas.  
Cada sprint entrega incrementos funcionales: usuarios, catálogo y recomendaciones.

---

### 2.4 Roles implicados

| Rol | Descripción |
|----|-------------|
| Product Owner | Prioriza el backlog y valida las entregas. |
| Scrum Master | Facilita el proceso y elimina impedimentos. |
| Equipo de desarrollo | Programadores, diseñadores UI y QA. |
| Usuarios finales | Aportan retroalimentación funcional y de usabilidad. |
| Administrador del sistema | Gestiona catálogo, cuentas y estadísticas. |

---

### 2.5 Riesgos y mitigación

| Riesgo | Descripción | Mitigación |
|------|-------------|-----------|
| Requisitos cambiantes | Cambios en prioridades o criterios de recomendación | Backlog dinámico y revisiones periódicas |
| Desviaciones de tiempo | Subestimación de integración multiplataforma | Estimación por puntos y burndown |
| Errores en BD | Pérdida o corrupción de datos | Backups y pruebas de integración |
| Falta de validación | Código sin revisión | Análisis estático y TDD |
| Dependencias tecnológicas | Limitaciones de frameworks | Inventario y plan de actualización |

---

## 3. Ingeniería de requisitos

### 3.1 Stakeholders

| Rol | Interés | Influencia |
|----|---------|------------|
| Usuario | Usabilidad y calidad de recomendaciones | Alto |
| Administrador | Control del catálogo | Alto |
| Desarrolladores | Correcta implementación | Alto |


---

### 3.2 Requisitos funcionales

| Código | Descripción | Prioridad |
|-----|------------|----------|
| RF-01 | Registro de usuarios | Must |
| RF-02 | Inicio y cierre de sesión | Must |
| RF-03 | Modificar o eliminar cuenta | Should |
| RF-04 | Catálogo filtrable | Must |
| RF-05 | Valoraciones y reseñas | Must |
| RF-06 | Recomendaciones personalizadas | Must |
| RF-07 | Gestión del catálogo | Must |
| RF-08 | Estadísticas | Should |

---

### 3.3 Requisitos no funcionales

| Código | Descripción | Tipo |
|-----|-------------|------|
| RNF-01 | Disponibilidad ≥ 99 % | Fiabilidad |
| RNF-02 | Respuesta ≤ 3 s | Eficiencia |
| RNF-03 | Multiplataforma | Portabilidad |
| RNF-04 | Interfaz intuitiva | Usabilidad |
| RNF-05 | Cumplimiento RGPD | Seguridad |
| RNF-06 | Buenas prácticas Java | Mantenibilidad |

---

### 3.4 Priorización y planificación
**MoSCoW**:
- Must: RF-01, RF-02, RF-04, RF-05, RF-06, RF-07
- Should: RF-03, RF-08, RF-10
- Could: RF-09

**Sprints**:
1. Registro, login y catálogo básico  
2. Valoraciones y recomendaciones  
3. Administración y estadísticas  

---

## 4. Modelado UML y modelo de datos

### 4.1 Casos de uso
Actores: Cliente y Administrador.

Casos principales:
- Autenticarse
- Gestionar cuenta
- Explorar catálogo
- Gestionar catálogo

---

### 4.2 Diagramas
- Diagrama de casos de uso  
- Diagrama de clases  
- Diagrama de secuencia  
- Diagrama de actividad  
- Modelo Entidad-Relación  

---

### 1. Diagrama de casos de uso
   ![Texto alternativo](ImagenesREADME/imagen_2025-10-23_124823558.png)

### 2. Diagrama de clases

<img width="931" height="604" alt="diagramadeclases2" src="https://github.com/user-attachments/assets/fecc6744-b3f9-42c8-8f13-e0fd29a92127" />

### 3. Diagrama de secuencia
<img width="1497" height="807" alt="DiagramaSecuenciaIngSoftware" src="https://github.com/user-attachments/assets/c3e8dd31-7127-4a7d-9db9-7014651b6b26" />

### 4. Diagrama de Actividad

<img width="543" height="526" alt="DiagramaActividadIngSoftware" src="https://github.com/user-attachments/assets/446edc4c-b4b8-4f41-9726-785b14ac68ee" />

### 5. Modelo Entidad-Relacion

<img width="741" height="905" alt="ModeloEntidadRelacion" src="https://github.com/user-attachments/assets/cdd4bc30-9927-4929-9c50-0db883c1681f" />

   

