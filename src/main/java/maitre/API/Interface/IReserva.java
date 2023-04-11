<<<<<<<< HEAD:src/main/java/maitre/API/repositorio/IReserva.java
package maitre.API.repositorio;

import maitre.API.entidade.User;
========
package maitre.API.Interface;

import maitre.API.User;
>>>>>>>> 721539f1b779c385c216e2e9b1bc369e5daa5880:src/main/java/maitre/API/Interface/IReserva.java

public interface IReserva {
    public void checkIn(User u);

    public void checkOut(User u);
}
