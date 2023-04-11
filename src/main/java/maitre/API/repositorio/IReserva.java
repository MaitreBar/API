package maitre.API.repositorio;

import maitre.API.entidade.User;

public interface IReserva {
    public void checkIn(User u);

    public void checkOut(User u);
}
