# 🏫 Sistema de Control de Asistencia y Gestión de Personal (ESPE-CRUD)

## 📝 1. Descripción del Proyecto
Este software es una solución tecnológica orientada a objetos (POO) diseñada específicamente para la automatización, auditoría y control bitácora de los flujos de ingreso (entradas) y egreso (salidas) del personal de la **Universidad de las Fuerzas Armadas ESPE**. 

El núcleo del sistema integra **persistencia de datos local a través de archivos planos (`.txt`)**, un motor de procesamiento lógico estructurado bajo contratos de interfaces y un diseño arquitectónico modular alineado con las mejores prácticas del desarrollo de software académico.

---

## 🛠️ 2. Arquitectura de Software y Pilares POO
El sistema fue modelado previamente en *PowerDesigner* y mapeado rigurosamente en código, demostrando la aplicación de los cuatro pilares fundamentales de la Programación Orientada a Objetos:

| Pilar | Mecanismo de Implementación en el Código | Beneficio Técnico |
| :--- | :--- | :--- |
| **Abstracción** | Clase base conceptual `Persona` e Interfaz acoplada `CRUD`. | Aísla la complejidad del sistema definiendo moldes genéricos de comportamiento. |
| **Encapsulamiento** | Atributos declarados de forma estricta como `private` gestionados por métodos accesores públicos `Getters` y `Setters`. | Restringe la mutabilidad directa de variables críticas (Cédulas, Horas de entrada) previniendo la corrupción de estados. |
| **Herencia** | La clase especializada `Empleado` extiende (`extends`) el estado formal de `Persona`. | Promueve la reutilización de código al heredar propiedades de identidad e integrar atributos de control laboral. |
| **Polimorfismo** | Métodos abstractos y firmas de la interfaz implementados en `SistemaCrud` mediante directivas `@Override`. | Permite desacoplar el comportamiento de los objetos, alterando dinámicamente cómo se despliegan e imprimen los datos. |

---

## 📁 3. Mapeo de Entidades y Estructura de Datos
El sistema captura y procesa de forma estructurada los siguientes tipos de datos atómicos para cada registro de auditoría:

* **Identidad Base:** Cédula de Identidad, Nombre y Apellido completos.
* **Localización y Contacto:** Dirección de domicilio y Teléfono móvil.
* **Cronometría del Sistema:** Marca de tiempo exacta de Entrada (`yyyy-MM-dd HH:mm:ss`) y Marca de tiempo de Salida.

### Modelo de Persistencia (Estructura Física del Archivo)
Los registros se sincronizan automáticamente en tiempo de ejecución en el archivo físico **`asistencia_espe.txt`**, utilizando un formateo basado en delimitadores por comas (CSV estándar):
```text
1726354890,Danny Sebastian Sigcho,Sangolqui,0987654321,2026-05-18 08:00:12,2026-05-18 16:30:45

---

## Repositorio GitHub

Proyecto desarrollado para la materia de Programación Orientada a Objetos.
