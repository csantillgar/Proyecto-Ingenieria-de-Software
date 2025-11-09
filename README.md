# Proyecto Ingeniería de Software
https://github.com/csantillgar/Proyecto-Ingenieria-de-Software.git
# Aplicación de Recomendación de Películas

## 1. Introducción

### 1.1 Objetivo general del sistema
El objetivo principal del sistema es diseñar e implementar una aplicación multiplataforma (móvil y escritorio) que recomiende películas a los usuarios de manera personalizada, basándose en sus preferencias, historial de visualizaciones y valoraciones.  
La aplicación permitirá al usuario registrarse, iniciar sesión, consultar el catálogo, valorar películas y recibir recomendaciones generadas mediante un algoritmo híbrido de filtrado colaborativo y basado en contenido.

### 1.2 Justificación del proyecto
La proliferación de contenido audiovisual ha generado la necesidad de sistemas que orienten la elección del usuario. Plataformas como Netflix, Filmin o Prime Video utilizan motores de recomendación que, aunque efectivos, están restringidos a sus propios catálogos.  
El proyecto busca crear una plataforma independiente que permita a cualquier usuario gestionar su biblioteca y recibir recomendaciones personalizadas sin depender de un proveedor concreto.

### 1.3 Alcance y limitaciones

#### Alcance funcional
- Registro, autenticación y gestión de usuarios.  
- Consulta del catálogo de películas (por género, título, popularidad).  
- Gestión del catálogo por parte de administradores (añadir, modificar o eliminar películas).  
- Valoraciones y reseñas de usuarios.  
- Algoritmo de recomendación basado en preferencias y valoración.  
- Módulo de facturación (suscriptores o pagos de servicios premium).  
- Interfaz móvil y de escritorio con sincronización centralizada.  

#### Limitaciones
- No se almacenarán ni reproducirán películas; solo se gestionarán datos informativos.  
- El motor de recomendación se basará en datos internos, sin integración con plataformas externas.  
- No se contemplan métricas de carga masiva de usuarios (no es un sistema distribuido a gran escala).  

### 1.4 Beneficios esperados
- Experiencia personalizada para cada usuario.  
- Centralización de datos y control administrativo sobre el catálogo.  
- Escalabilidad modular del sistema (añadir nuevos tipos de contenido o filtros).  
- Iteraciones y mejoras constantes mediante ciclo de vida ágil.  
- Buenas prácticas de ingeniería del software: trazabilidad, modelado, control de versiones y calidad del código.

### 1.5 Glosario de términos
| Término | Definición |
|---|---|
| **Actor** | Rol que interactúa con el sistema (usuario, técnico, administrador). |
| **Caso de uso** | Funcionalidad observable por un actor que produce un resultado concreto. |
| **Recomendación** | Sugerencias de películas según hábitos y valoraciones. |
| **Catálogo** | Base de datos de películas con metadatos (título, género, año, sinopsis, valoración). |
| **Backend** | Lógica de negocio en Java Spring Boot. |
| **Frontend** | Interfaz de usuario en JavaFX (escritorio) y Flutter (móvil). |
| **API REST** | Servicios HTTP/JSON. |
| **Scrum** | Metodología ágil basada en sprints y mejora continua. |

---

## 2. Ingeniería del Software: Enfoque y contexto

### 2.1 Naturaleza del software y motivación
Sistema de información inteligente orientado a personalización. Software evolutivo y dependiente de datos de usuario. Se requiere proceso sistemático para reducir riesgos de desalineación con expectativas.

### 2.2 Tipo de sistema y clasificación
- Sistema de información con componente inteligente (motor de recomendación).  
- Aplicación híbrida multiplataforma (escritorio + móvil).  
- Arquitectura cliente-servidor RESTful.  
- Componentes: datos (MySQL), lógica (Spring Boot), presentación (JavaFX / Flutter).

### 2.3 Ciclo de vida elegido
Ciclo ágil iterativo-incremental con Scrum. Sprints de 2–3 semanas, cada uno entregando incrementos funcionales (usuarios, catálogo, recomendaciones, pagos).

### 2.4 Roles implicados
| Rol | Descripción |
|---|---|
| Product Owner | Prioriza backlog, valida entregas, acepta incrementos. |
| Scrum Master | Facilita el proceso, elimina impedimentos. |
| Equipo de desarrollo | Programadores, UI y QA. |
| Usuarios finales | Retroalimentación funcional y de usabilidad. |
| Administrador del sistema | Gestión de catálogo, cuentas y estadísticas. |

### 2.5 Riesgos y mitigación
| Riesgo | Descripción | Mitigación |
|---|---|---|
| Requisitos cambiantes | Cambios en prioridades o criterios de recomendación. | Backlog dinámico y revisiones periódicas. |
| Desviaciones de tiempo | Subestimación de integración móvil/escritorio. | Estimación por puntos e informes burndown. |
| Errores en BD | Pérdida o corrupción de datos. | Backups y pruebas de integración. |
| Falta de validación | Código sin revisión ni métricas. | Análisis estático y TDD. |
| Dependencias tecnológicas | Limitaciones de librerías/frameworks. | Inventario de dependencias y plan de actualización. |

### 2.6 Estándares de calidad aplicables
- ISO/IEC 25010 (calidad del producto).  
- IEEE 829:2008 (documentación de pruebas).  
- ISO/IEC 12207 (procesos del ciclo de vida).  
- Convenciones Java/Spring (estilo, Javadoc, modularidad, manejo de excepciones).

---

## 3. Ingeniería de requisitos

### 3.1 Stakeholders
| Rol | Interés | Influencia |
|---|---|---|
| Usuario | Usabilidad y calidad de recomendaciones. | Alto |
| Administrador | Control de catálogo y estadísticas. | Alto |
| Técnico/Soporte | Mantenimiento y rendimiento. | Medio |
| Desarrolladores | Implementar conforme a requisitos y estándares. | Alto |
| Product Owner | Priorización y aceptación de entregas. | Muy alto |
| Scrum Master | Cumplimiento metodológico. | Medio |

### 3.2 Obtención y análisis
Entrevistas, observación, análisis comparativo (Netflix, IMDb, FilmAffinity), prototipos, backlog de historias. Resultado: requisitos del MVP.

### 3.3 Requisitos funcionales
| Código | Descripción | Prioridad |
|---|---|---|
| RF-01 | Registro de usuarios con correo y contraseña. | Must |
| RF-02 | Inicio y cierre de sesión. | Must |
| RF-03 | Modificar o eliminar cuenta propia. | Should |
| RF-04 | Catálogo filtrable por género, año y popularidad. | Must |
| RF-05 | Valoraciones y reseñas de usuarios. | Must |
| RF-06 | Recomendaciones personalizadas. | Must |
| RF-07 | Gestión de catálogo por administradores. | Must |
| RF-08 | Estadísticas de visualización y valoración. | Should |
| RF-09 | Gestión de pagos premium. | Could |
| RF-10 | Reportes técnicos de incidencias y mantenimiento. | Should |

### 3.4 Requisitos no funcionales
| Código | Descripción | Tipo |
|---|---|---|
| RNF-01 | Disponibilidad ≥ 99%. | Fiabilidad |
| RNF-02 | Tiempo de respuesta ≤ 3 s por consulta. | Eficiencia |
| RNF-03 | Operativo en móvil (Android/iOS) y escritorio (Windows/Linux). | Portabilidad |
| RNF-04 | Interfaz intuitiva y coherente. | Usabilidad |
| RNF-05 | Cumplimiento RGPD. | Seguridad |
| RNF-06 | Estilo Java y buenas prácticas. | Mantenibilidad |
| RNF-07 | Arquitectura cliente-servidor con API REST. | Arquitectura |
| RNF-08 | Métricas y análisis estático por sprint. | Calidad |
| RNF-09 | Soporte de hasta 1.000 usuarios concurrentes (pruebas). | Escalabilidad |

### 3.5 Priorización (MoSCoW) y plan de sprints
- Must: RF-01, RF-02, RF-04, RF-05, RF-06, RF-07  
- Should: RF-03, RF-08, RF-10  
- Could: RF-09  
- Won’t (por ahora): Integraciones externas, IA predictiva avanzada

**Orden de sprints**:  
1) Registro, login, catálogo básico.  
2) Valoraciones y recomendaciones.  
3) Administración y estadísticas.  
4) Pagos y refinamiento de usabilidad.

### 3.6 Validación y gestión de cambios
Criterios de aceptación por historia, refinamiento de backlog, trazabilidad en issues, evaluación de impacto: requisito → caso de uso → código → prueba.

---

## 4. Modelado UML y modelo de datos

### 4.1 Casos de uso

#### Actores
- Cliente  
- Administrador  
- Técnico  
- Sistema de pagos (externo)

#### Casos principales y relaciones
- **Autenticarse** → incluye: *iniciar sesión*, *cerrar sesión*.  
- **Gestionar cuenta** → incluye: *modificar datos*, *eliminar cuenta*.  
- **Explorar catálogo** → incluye: *buscar película*, *ver detalles*, *valorar película*; **extiende**: *recibir recomendaciones*.  
- **Gestionar catálogo (administrador)** → incluye: *añadir película*, *modificar película*, *eliminar película*.  
- **Gestionar facturación** → incluye: *registrar pago*, *consultar mensualidades*, *ver ingresos*.  
- **Gestionar usuarios (administrador)** → incluye: *eliminar cuentas*, *modificar información de usuarios*.  
- **Mantenimiento técnico** → incluye: *registrar incidencia*, *generar reporte*.

### 4.2 Diagrama de clases (texto)
```
Usuario
 ├ atributos: idUsuario, nombre, correo, contraseña, rol
 ├ métodos: registrar(), autenticar(), modificarPerfil(), eliminarCuenta()

Pelicula
 ├ atributos: idPelicula, titulo, genero, año, sinopsis, puntuacionPromedio
 ├ métodos: obtenerDetalles(), actualizarValoracion()

Valoracion
 ├ atributos: idValoracion, idUsuario, idPelicula, puntuacion, comentario

Recomendador
 ├ métodos: generarRecomendaciones(idUsuario)

Factura
 ├ atributos: idFactura, idUsuario, monto, fechaPago, estado

Administrador : Usuario
 ├ métodos: gestionarCatalogo(), gestionarUsuarios(), consultarEstadisticas()

Tecnico : Usuario
 ├ métodos: registrarIncidencia(), generarReporte()
```

**Relaciones**
- Un **Usuario** tiene muchas **Valoraciones** (1:N).  
- Una **Valoracion** pertenece a una **Pelicula** (N:1).  
- Un **Administrador** gestiona múltiples **Peliculas** y **Usuarios** (N:M según el caso de uso; en BD se materializa por acciones de auditoría, no como relación directa).  
- El **Recomendador** consulta **Valoraciones** y **Peliculas** (dependencias de uso).

### 4.3 Diagrama de secuencia (consulta de recomendaciones)
1. Usuario → Interfaz: “Ver recomendaciones”.  
2. Interfaz → Controlador (Spring): `GET /recomendaciones`.  
3. Controlador → Servicio de recomendación: `generarRecomendaciones(idUsuario)`.  
4. Servicio → DAO: consultas a películas y valoraciones.  
5. DAO → Base de datos: retorna datos.  
6. Servicio → Controlador: lista de películas recomendadas.  
7. Controlador → Interfaz: muestra resultados.

### 4.4 Diagrama de actividad (flujo de valoración)
1. Usuario inicia sesión.  
2. Accede al catálogo.  
3. Selecciona una película.  
4. Introduce puntuación y reseña.  
5. Sistema guarda los datos.  
6. Recalcula promedio de valoraciones.  
7. Actualiza sugerencias del recomendador.

### 4.5 Modelo Entidad–Relación (MER)

#### Entidades
- **Usuarios** (`id_usuario` PK, `nombre`, `correo`, `contraseña`, `rol`)  
- **Películas** (`id_pelicula` PK, `titulo`, `genero`, `anio`, `sinopsis`, `promedio_valoracion`)  
- **Valoraciones** (`id_valoracion` PK, `id_usuario` FK, `id_pelicula` FK, `puntuacion`, `comentario`)  
- **Facturas** (`id_factura` PK, `id_usuario` FK, `monto`, `fecha_pago`, `estado`)  
- **Incidencias** (`id_incidencia` PK, `id_tecnico` FK, `descripcion`, `fecha`)

#### Relaciones
- Un **Usuario** puede valorar muchas **Películas** → relación **1:N** de `Usuarios` a `Valoraciones`.  
- Una **Película** puede recibir muchas **Valoraciones** → relación **1:N** de `Películas` a `Valoraciones`.  
- Un **Usuario** puede tener múltiples **Facturas** → relación **1:N** de `Usuarios` a `Facturas`.  
- Un **Técnico** puede registrar múltiples **Incidencias** → relación **1:N** de `Usuarios(rol=tecnico)` a `Incidencias`.  
- Para auditoría de gestión de catálogo por **Administrador**, las operaciones se registran en una tabla de **Eventos** (opcional): `Eventos(id_evento, id_admin, tipo, id_pelicula, fecha, detalle)` con relaciones `Usuarios(rol=admin) 1:N Eventos` y `Películas 1:N Eventos`.

---

1. Diagrama de casos de uso
   ![Texto alternativo](imagen_2025-10-23_124823558.png)

2. Diagrama de clases

      <img width="691" height="647" alt="Diagramadeclases drawio" src="https://github.com/user-attachments/assets/8b6c0ee6-7367-410f-8ca2-77046d688271" />


3. Diagrama de secuencia
<img width="1497" height="807" alt="DiagramaSecuenciaIngSoftware" src="https://github.com/user-attachments/assets/c3e8dd31-7127-4a7d-9db9-7014651b6b26" />

   
