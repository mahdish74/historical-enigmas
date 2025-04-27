# Historical Enigmas

An API-based Java Enterprise (JEE) simulation of the historical Enigma machine, inspired by the movie *The Imitation Game*.

After watching *The Imitation Game*, I was deeply inspired by the incredible story of Alan Turing and the pivotal role of the Enigma machine during World War II.  
Driven by that excitement, I created this project to simulate the Enigma machine — not just as a standalone program, but as a modern **Java Enterprise API service**.

Historical Enigmas allows users to encrypt messages through a web API, simulating the core principles of the original Enigma machine, using Kotlin and Java EE technologies.

This project includes:
- RESTful API for encrypting text.
- Rotor-based encryption with rotation after each character.
- Plugboard (simple swapping) applied before and after rotor processing.
- Reflector simulation to reverse the encryption path.
- Rotor stepping mechanism (basic simulation).
- Kotlin + Java EE based architecture.
- Easy backend integration.

## How to Use

Send a POST request to the following endpoint:

POST /api/enigma/encrypt


### Request Body (JSON)

{
  "text": "HELLO-WORLD"
}

Example Response

{
  "encryptedText": "XZFJB-YQPKT"
}

You simply send your plain text and receive an encrypted output based on Enigma-like processing.
How to Run Locally

    Clone the repository:

git clone https://github.com/mahdish74/historical-enigmas.git

Open the project in IntelliJ IDEA (Ultimate Edition recommended) or any IDE supporting Java EE.

Deploy the project on a Java EE server (e.g., Payara, WildFly, or GlassFish).

Access the API locally at:

    http://localhost:8080/api/enigma/encrypt

    Test the API using Postman, curl, or integrate it into your frontend/backend application.

Future Improvements

    Implement full rotor notch and double-stepping behavior.

    Allow custom plugboard mappings via API.

    Support multiple reflectors and rotor selection.

    Add authentication (API keys, OAuth2).

    Expand to support decryption services.

Inspiration

This project was inspired by the movie The Imitation Game, showcasing Alan Turing's groundbreaking work in cracking the Enigma code.
This simulation merges my interest in cryptography with modern web technologies to recreate a piece of history in today's world.
License

This project is released under the MIT License.
Feel free to explore, use, modify, and contribute to the project

---

## 🤝 Let's Connect!

If you enjoyed this project or would like to collaborate, feel free to connect with me on www.linkedin.com/in/mehdi-shojaeirad-3839321b6


