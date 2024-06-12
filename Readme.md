<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de Gestión de Cola de Prioridad</title>
</head>
<body>
    <h1>Sistema de Gestión de Cola de Prioridad</h1>
    <p>Este proyecto implementa un sistema de gestión de colas de prioridad en Java. Utiliza tres colas internas para manejar diferentes niveles de prioridad (alta, media y baja), permitiendo agregar, atender y mostrar clientes en la cola según su nivel de prioridad.</p>

<h2>Características</h2>
    <ul>
        <li><strong>Encolar</strong>: Permite agregar nuevos clientes a la cola con diferentes niveles de prioridad.</li>
        <li><strong>Desencolar</strong>: Atiende al siguiente cliente de acuerdo a la política de prioridades.</li>
        <li><strong>Mostrar Cola</strong>: Muestra la lista de clientes en espera según su prioridad.</li>
        <li><strong>Validación</strong>: Valida los nombres de los clientes y la prioridad ingresada.</li>
    </ul>

<h2>Estructura del Proyecto</h2>
    <pre>
.
├── ColaDePrioridad.java
├── Cola.java
└── README.html
    </pre>

<h2>Descripción de Clases</h2>
    <h3>ColaDePrioridad.java</h3>
    <p>Esta clase maneja la lógica principal del sistema de colas de prioridad. Contiene métodos para encolar, desencolar, mostrar la cola y validar las entradas del usuario.</p>

<h3>Cola.java</h3>
    <p>Esta clase representa una cola simple que se utiliza para implementar las colas de alta, media y baja prioridad.</p>

<h2>Uso</h2>
    <h3>Ejecución del Programa</h3>
    <ol>
        <li>Compila el programa:
            <pre>javac ColaDePrioridad.java Cola.java</pre>
        </li>
        <li>Ejecuta el programa:
            <pre>java ColaDePrioridad</pre>
        </li>
    </ol>

<h3>Menú de Opciones</h3>
    <ul>
        <li><strong>1. Añadir un nuevo cliente</strong>: Permite agregar un cliente a la cola especificando su nombre y nivel de prioridad.</li>
        <li><strong>2. Atender al siguiente cliente</strong>: Atiende al siguiente cliente según la prioridad.</li>
        <li><strong>3. Mostrar lista de clientes en espera</strong>: Muestra la lista de todos los clientes en espera.</li>
        <li><strong>4. Salir</strong>: Termina el programa.</li>
    </ul>

<h3>Ejemplo de Uso</h3>
    <ol>
        <li>Selecciona la opción <strong>1</strong> para añadir un nuevo cliente.</li>
        <li>Ingresa el nombre del cliente y su prioridad.</li>
        <li>Selecciona la opción <strong>2</strong> para atender al siguiente cliente.</li>
        <li>Selecciona la opción <strong>3</strong> para mostrar la lista de clientes en espera.</li>
        <li>Selecciona la opción <strong>4</strong> para salir del programa.</li>
    </ol>

<h2>Contribuciones</h2>
    <p>Si deseas contribuir a este proyecto, puedes hacerlo mediante pull requests. Por favor, asegúrate de seguir las mejores prácticas de codificación y de comentar adecuadamente tu código.</p>

<h2>Licencia</h2>
    <p>Este proyecto está licenciado bajo la Licencia MIT. Para más detalles, consulta el archivo LICENSE.</p>

<h2>Contacto</h2>
    <p>Si tienes alguna pregunta o sugerencia, no dudes en contactarme a través de mi perfil de GitHub.</p>
</body>
</html>
