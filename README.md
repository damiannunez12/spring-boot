# SNPP - Sistema de Gestión de Créditos

API REST para la gestión de un sistema de créditos financieros, incluyendo **clientes, productos, créditos, contratos y pagos**.

## 🚀 Servidor

La aplicación se ejecuta localmente en:

**http://localhost:8082/snpp**

## 📚 Documentación de la API

La documentación interactiva está disponible mediante **Swagger UI**:

**http://localhost:8082/snpp/swagger-ui/index.html**

Desde Swagger es posible consultar los endpoints, probar las operaciones y visualizar los esquemas de petición y respuesta.

---

# 📌 Módulos de la API

## 💰 Pagos

Gestión de los pagos asociados a créditos.

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/pagos` | Listar todos los pagos |
| `POST` | `/api/pagos` | Registrar un nuevo pago |
| `GET` | `/api/pagos/{id}` | Buscar un pago por ID |
| `DELETE` | `/api/pagos/{id}` | Eliminar un pago |

### Ejemplo

```http
GET http://localhost:8082/snpp/api/pagos