# COMP90015-Multi-threaded-Dictionary-Server

In light of the assignment problem description, this project implements a client-server architecture with a thread pool to handle concurrent requests of dictionary services. 

Communication between client and server is completed by TCP sockets. Message exchange protocol is simple. When users enter inputs in GUIs, the name of the functionality such as “query”, “add” or “remove” and the word (and meaning, if any) will form a string formatted like ```<functionality>,<word>(,<meaning>)```. The string then is sent to server in socket. When server gets the string, it splits it by “,” and gets the functionality requested, word (and meaning). By the functionality requested, the server invokes corresponding dictionary services and sends back the result.

The system mainly consists of 4 parts, which are ```Swing Windows```, ```Dictionary Services```,```Client``` and ```Server```. 

More implementation details and illustrations can be found in Report.pdf
