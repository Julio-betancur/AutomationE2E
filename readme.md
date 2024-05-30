# Proyecto de Automatización E2E - SauceDemo

## Descripción del Proyecto
Este proyecto de automatización realiza una prueba End-to-End (E2E) en la página web [SauceDemo](https://www.saucedemo.com/). La prueba cubre los siguientes pasos:

1. **Autenticarse** con el usuario: `standard_user` y password: `secret_sauce`.
2. **Agregar dos productos** al carrito.
3. **Visualizar el carrito**.
4. **Completar el formulario** de compra.
5. **Finalizar la compra** hasta la confirmación: "THANK YOU FOR YOUR ORDER".

## Prerrequisitos
Para ejecutar esta automatización en un entorno local, asegúrate de tener instalados los siguientes componentes:

- JDK 17 o superior.
- IntelliJ IDEA.
- Navegador Google Chrome.

## Configuración del Proyecto
Este proyecto utiliza el lenguaje de programación **Java** y el marco de automatización **SerenityBDD** con el patrón de diseño **Screenplay**. Las dependencias se gestionan con **Gradle**.

### Dependencias Principales
Las principales dependencias del proyecto están especificadas en el archivo `build.gradle`, incluyendo:

- Serenity Core
- Serenity Cucumber
- Serenity Screenplay y Screenplay WebDriver
- JUnit5
- Lombok

### Configuración de SerenityBDD
La configuración de la URL y otras propiedades de la prueba están alojadas en el archivo `serenity.conf`.

## Ejecución de las Pruebas
Para ejecutar las pruebas, sigue estos pasos:

1. Clona el repositorio del proyecto en tu máquina local.
2. Abre el proyecto en IntelliJ IDEA.
3. Asegúrate de que JDK 17 o superior esté configurado en tu entorno de desarrollo.
4. Asegúrate de tener el navegador Google Chrome instalado.
5. Ejecuta el siguiente comando en la terminal gradle de IntelliJ para iniciar las pruebas:

    ```sh
    gradle clean test aggregate
    ```

    Este comando ejecutará las pruebas y generará un reporte agregado de SerenityBDD.

## Contacto
Para cualquier pregunta o asistencia adicional, puedes contactar al correo juliobetancur2@gmail.com
