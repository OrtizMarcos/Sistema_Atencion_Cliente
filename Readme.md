<!DOCTYPE html>
<html>
<head>
  <title>Simulación de un Sistema de Atención al Cliente con Colas de Prioridad</title>
</head>
<body>
  <h1>Simulación de un Sistema de Atención al Cliente con Colas de Prioridad</h1>
  <p>Este programa simula un sistema de atención al cliente utilizando colas de prioridad. En este sistema, los clientes tienen diferentes niveles de prioridad y son atendidos en orden de prioridad, con aquellos de mayor prioridad siendo atendidos primero.</p>
  <h2>Descripción</h2>
  <p>En un centro de atención al cliente, los clientes llegan con diferentes niveles de urgencia. Los niveles de prioridad se representan con números enteros, donde un número más bajo indica una mayor prioridad. Consideramos que existen tres prioridades: 1 es la prioridad más alta, 2 prioridad media y 3 prioridad baja.</p>
  <h2>Clases y Métodos</h2>
  <ul>
    <li><strong>Cliente</strong>: Representa a un cliente con los atributos nombre y nivelPrioridad.</li>
    <li><strong>SistemaAtencionCliente</strong>: Gestiona el sistema de atención al cliente con los métodos:
      <ul>
        <li><code>llegadaCliente(nombre, nivelPrioridad)</code>: Añade un nuevo cliente a la cola de prioridad.</li>
        <li><code>atenderCliente()</code>: Atiende al siguiente cliente en la cola, según su nivel de prioridad, y lo elimina de la cola.</li>
        <li><code>mostrarCola()</code>: Muestra la lista de clientes en la cola en orden de prioridad.</li>
      </ul>
    </li>
  </ul>
  <h2>Funcionalidad</h2>
  <p>El programa permite la llegada de nuevos clientes con diferentes niveles de prioridad y los atiende en orden de prioridad. Implementa una lógica de negocio que garantiza que todos los clientes sean atendidos.</p>
  <h2>Interfaz de Usuario</h2>
  <p>Implementa una interfaz simple que permite:</p>
  <ul>
    <li>Añadir un nuevo cliente.</li>
    <li>Atender al siguiente cliente.</li>
    <li>Mostrar la lista de clientes en espera.</li>
  </ul>
</body>
</html>




