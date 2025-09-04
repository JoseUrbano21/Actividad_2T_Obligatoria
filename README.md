# Servidor Multihilo Pokémon

📚 Curso DAM – Programación de Servicios y Procesos (PSP)  
✍️ Entrega: desarrollo de un servidor multihilo (temática **Pokémon**).

## 🛠️ Tecnologías
![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white&style=for-the-badge)
![Sockets](https://img.shields.io/badge/Sockets-3949AB?style=for-the-badge)
![Multithreading](https://img.shields.io/badge/Multithreading-8E24AA?style=for-the-badge)

## ⚙️ Funcionalidad
- El **servidor** mantiene un banco compartido de Pokémon.  
- Cada **cliente** puede conectarse y realizar inscripciones.  
- Se gestionan múltiples conexiones concurrentes gracias a **hilos**.  

## 📸 Vista previa
Ejecución en consola del servidor y un cliente conectándose:

Servidor estableciendo conexión
![Server_conect](Conexion_servidor.png)

Cliente estableciendo conexión
![Client_conect](Conexion_cliente.png)

Servidor escuchando la petición del cliente y enviando la respuesta
![Server_listening](Servidor_escuchando.png)

Cliente enviando la petición y recibiendo la respuesta del servidor
![Client_listening](Cliente_enviando_recibiendo.png)
