# Proyecto CRUD - Registro de Personal ESPE

## Descripción

Este proyecto fue desarrollado en Java utilizando Programación Orientada a Objetos (POO) y sus cuatro pilares:

* Encapsulamiento
* Herencia
* Abstracción
* Polimorfismo

El sistema permite registrar la entrada y salida del personal de la ESPE, almacenando la información en un archivo `.txt`.

---

## Funcionalidades

* Registro de datos del personal
* Captura automática de hora de entrada
* Captura automática de hora de salida
* Guardado de información en archivo TXT
* Implementación de operaciones CRUD

---

## Datos registrados

* Cédula
* Nombre
* Dirección
* Teléfono
* Hora de entrada
* Hora de salida

---

## Tecnologías utilizadas

* Java
* NetBeans
* PowerDesigner
* GitHub

---

## Estructura del proyecto

### Clases principales

* `Persona`
* `Empleado`
* `CRUD`
* `SistemaCRUD`
* `Principal`

---

## Pilares de POO aplicados

### Encapsulamiento

Uso de atributos privados y métodos getters/setters.

### Herencia

La clase `Empleado` hereda de la clase `Persona`.

### Abstracción

Uso de la interfaz `CRUD`.

### Polimorfismo

Implementación de métodos mediante `@Override`.

---

## Archivo generado

El sistema genera un archivo:

```text
personal.txt
```

Donde se almacenan los registros del personal.

---

## Autores

* Danny Sebastian Sigcho Sigcho
* Dahir Alejandro Salinas Vargas
* Luis Enrique Vazcones Guingla

---

## Repositorio GitHub

Proyecto desarrollado para la materia de Programación Orientada a Objetos.
